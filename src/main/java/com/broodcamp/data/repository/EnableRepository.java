package com.broodcamp.data.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.broodcamp.data.entity.EnableEntity;

/**
 * @author Edward P. Legaspi
 */
@NoRepositoryBean
public interface EnableRepository<T extends EnableEntity, ID extends Serializable> extends AuditableRepository<T, ID> {

	List<T> findByDisabled(boolean disabled);
}
