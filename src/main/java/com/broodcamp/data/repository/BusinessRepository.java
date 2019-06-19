package com.broodcamp.data.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;

import com.broodcamp.data.entity.BusinessEntity;

/**
 * @author Edward P. Legaspi
 */
@NoRepositoryBean
public interface BusinessRepository<T extends BusinessEntity, ID extends Serializable> extends EnableRepository<T, ID> {

	public T findByCode(String code);

}
