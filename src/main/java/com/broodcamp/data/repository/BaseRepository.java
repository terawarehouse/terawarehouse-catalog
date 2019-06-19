package com.broodcamp.data.repository;

import java.io.Serializable;

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

}
