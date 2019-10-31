/**
 * An Open Source Inventory and Sales Management System
 * Copyright (C) 2019 Edward P. Legaspi (https://github.com/czetsuya)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.broodcamp.bean;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import com.broodcamp.data.repository.BaseRepositoryImpl;

/**
 * Extend {@link JpaRepositoryFactoryBean} so that we can add custom features
 * and enable auto wiring of beans.
 * 
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @see JpaRepositoryFactoryBean
 */
public class ExtendedJPARepositoryFactoryBean<R extends JpaRepository<T, ID>, T, ID extends Serializable> extends JpaRepositoryFactoryBean<R, T, ID> {

	public ExtendedJPARepositoryFactoryBean(Class<? extends R> repositoryInterface) {
		super(repositoryInterface);
	}

	/**
	 * A custom Extended Jpa executor factory.
	 * 
	 * @param <T>
	 * @param <I>
	 */
	private static class ExtendedJpaExecutorFactory<T, I extends Serializable> extends JpaRepositoryFactory {

		@SuppressWarnings("unused")
		private EntityManager entityManager;

		/**
		 * Extended jpa executor factory constructor.
		 * 
		 * @param entityManager entity manager
		 */
		public ExtendedJpaExecutorFactory(EntityManager entityManager) {
			super(entityManager);
			this.entityManager = entityManager;
		}

		@Override
		protected JpaRepositoryImplementation<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
			JpaRepositoryImplementation<?, ?> jpaRepositoryImplementation = super.getTargetRepository(information, entityManager);
			SpringContextUtil.getApplicationContext().getAutowireCapableBeanFactory().autowireBean(jpaRepositoryImplementation);
			return jpaRepositoryImplementation;
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		protected Class getRepositoryBaseClass(RepositoryMetadata metadata) {
			return BaseRepositoryImpl.class;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new ExtendedJpaExecutorFactory(entityManager);
	}
}