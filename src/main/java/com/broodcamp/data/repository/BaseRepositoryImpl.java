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

/**
 * Overriden base repository. Must not be abstract.
 * 
 * @author Edward P. Legaspi
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

		Optional<T> optEntity = Optional.empty();

		if (entity.getId() == null) {
			optEntity = Optional.of(entity);
		}

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
			return null;
		}

		List<T> refreshedEntities = new ArrayList<>();
		for (T entity : entities) {
			refreshedEntities.add(retrieveIfNotManaged(entity).get());
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
