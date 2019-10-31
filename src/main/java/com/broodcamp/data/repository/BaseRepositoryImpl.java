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
package com.broodcamp.data.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.broodcamp.bean.CurrentUser;
import com.broodcamp.data.entity.AuditableEntity;
import com.broodcamp.data.entity.BaseEntity;
import com.broodcamp.data.repository.BaseRepository;

/**
 * Overriden base repository. Must not be abstract.
 * 
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
public class BaseRepositoryImpl<T extends BaseEntity, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private EntityManager entityManager;

    @Autowired
    private CurrentUser currentUser;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public <S extends T> S save(S entity) {

        if (entity instanceof AuditableEntity) {
            ((AuditableEntity) entity).updateAudit(currentUser.getName());
        }

        return super.save(entity);
    }

    @Override
    public void detach(T entity) {
        getEntityManager().detach(entity);
    }

    @Override
    public void refresh(T entity) {

        if (getEntityManager().contains(entity)) {
            getEntityManager().refresh(entity);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<T> retrieveIfNotManaged(T entity) {

        Optional<T> optEntity;

        if (getEntityManager().contains(entity)) {
            optEntity = Optional.of(entity);

        } else {
            optEntity = findById((ID) entity.getId());
        }

        return optEntity;
    }

    @Override
    public List<T> retrieveIfNotManaged(List<T> entities) {

        if (entities == null) {
            return new ArrayList<>();
        }

        List<T> refreshedEntities = new ArrayList<>();
        for (T entity : entities) {
            Optional<T> optT = retrieveIfNotManaged(entity);
            if (optT.isPresent()) {
                refreshedEntities.add(optT.get());
            }
        }

        return refreshedEntities;
    }

    @Override
    public Set<T> retrieveIfNotManaged(Set<T> entities) {

        if (entities == null) {
            return null;
        }

        Set<T> refreshedEntities = new HashSet<>();
        for (T entity : entities) {
            refreshedEntities.add(retrieveIfNotManaged(entity).get());
        }

        return refreshedEntities;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<T> refreshOrRetrieve(T entity) {

        Optional<T> optEntity = Optional.empty();

        if (entity == null) {
            optEntity = Optional.of(entity);
        }

        if (getEntityManager().contains(entity)) {
            getEntityManager().refresh(entity);
            optEntity = Optional.of(entity);

        } else {
            return findById((ID) entity.getId());
        }

        return optEntity;
    }

    @Override
    public List<T> refreshOrRetrieve(List<T> entities) {

        if (entities == null) {
            return null;
        }

        List<T> refreshedEntities = new ArrayList<>();
        for (T entity : entities) {
            refreshedEntities.add(refreshOrRetrieve(entity).get());
        }

        return refreshedEntities;
    }

    @Override
    public Set<T> refreshOrRetrieve(Set<T> entities) {

        if (entities == null) {
            return null;
        }

        Set<T> refreshedEntities = new HashSet<>();
        for (T entity : entities) {
            refreshedEntities.add(refreshOrRetrieve(entity).get());
        }

        return refreshedEntities;
    }
}
