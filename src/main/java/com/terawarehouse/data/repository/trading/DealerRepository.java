package com.terawarehouse.data.repository.trading;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.broodcamp.data.repository.BusinessRepository;
import com.terawarehouse.data.entity.trading.Dealer;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
@Repository
public interface DealerRepository extends BusinessRepository<Dealer, UUID> {

}
