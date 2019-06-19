package com.broodcamp.data.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;

import com.broodcamp.data.entity.EnableEntity;

/**
 * @author Edward P. Legaspi
 */
@NoRepositoryBean
public interface EnableRepository<T extends EnableEntity, ID extends Serializable> extends AuditableRepository<T, ID> {

}
