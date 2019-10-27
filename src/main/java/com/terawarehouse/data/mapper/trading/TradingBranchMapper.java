/**
 * An Open Source Inventory and Sales Management System
 * Copyright (C) 2019 Edward P. Legaspi (https://github.com/czetsuya)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.terawarehouse.data.mapper.trading;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.broodcamp.data.mapper.GenericMapper;
import com.terawarehouse.business.domain.trading.TradingBranchDto;
import com.terawarehouse.data.entity.trading.TradingBranch;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Mapper
public abstract class TradingBranchMapper implements GenericMapper<TradingBranch, TradingBranchDto> {

    @Override
    @Mapping(source = "dealer.id", target = "dealerId")
    @Mapping(source = "tradingTown.id", target = "tradingTownId")
    @Mapping(target = "tradingAddress", source = "tradingTown.tradingAddress")
    public abstract TradingBranchDto toDto(TradingBranch source);
}