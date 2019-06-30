package com.broodcamp.data.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.broodcamp.bean.CurrentUser;
import com.broodcamp.data.entity.AuditableEntity;
import com.broodcamp.data.entity.BaseEntity;

/**
 * Overriden base repository. Must not be abstract.
 * 
 * @author Edward P. Legaspi
 */
public class BaseRepositoryImpl<T extends BaseEntity, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

	@SuppressWarnings("unused")
	private EntityManager entityManager;

	@Autowired
	private CurrentUser currentUser;

	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public <S extends T> S save(S entity) {
		if (entity instanceof AuditableEntity) {
			((AuditableEntity) entity).updateAudit(currentUser.getName());
		}

		return super.save(entity);
	}
}
