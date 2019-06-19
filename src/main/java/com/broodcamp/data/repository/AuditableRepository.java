package com.broodcamp.data.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;

import com.broodcamp.data.entity.AuditableEntity;

/**
 * @author Edward P. Legaspi
 */
@NoRepositoryBean
public interface AuditableRepository<T extends AuditableEntity, ID extends Serializable> extends BaseRepository<T, ID> {

}
