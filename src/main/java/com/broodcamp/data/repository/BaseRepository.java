package com.broodcamp.data.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.broodcamp.data.entity.BaseEntity;

/**
 * @author Edward P. Legaspi
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {

	@Override
	<S extends T> S save(S entity);

	void detach(T entity);

	void refresh(T entity);

	Optional<T> retrieveIfNotManaged(T entity);

	List<T> retrieveIfNotManaged(List<T> entities);

	Set<T> retrieveIfNotManaged(Set<T> entities);

	Optional<T> refreshOrRetrieve(T entity);

	List<T> refreshOrRetrieve(List<T> entities);

	Set<T> refreshOrRetrieve(Set<T> entities);

}
