package com.terawarehouse.data.repository.trading;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.broodcamp.data.repository.BusinessRepository;
import com.terawarehouse.data.entity.trading.DealerGroup;

/**
 * @author Edward P. Legaspi
 */
@Repository
public interface DealerGroupRepository extends BusinessRepository<DealerGroup, UUID> {

}
