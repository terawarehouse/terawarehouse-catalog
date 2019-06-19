package com.terawarehouse.data.repository.trading;

import org.springframework.stereotype.Repository;

import com.broodcamp.data.repository.BusinessRepository;
import com.terawarehouse.data.entity.trading.TradingBranch;

/**
 * @author Edward P. Legaspi
 */
@Repository
public interface TradingBranchRepository extends BusinessRepository<TradingBranch, String> {

}
