package com.terawarehouse.data.repository.catalog;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.broodcamp.data.repository.BusinessRepository;
import com.terawarehouse.data.entity.catalog.Brand;

/**
 * @author Edward P. Legaspi
 */
@Repository
public interface BrandRepository extends BusinessRepository<Brand, UUID> {

}
