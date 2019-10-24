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
package com.terawarehouse.web.assembler.trading;

import org.springframework.stereotype.Component;

import com.broodcamp.web.assembler.AbstractEnableResourceAssember;
import com.terawarehouse.data.dto.trading.TradingProvinceDto;
import com.terawarehouse.web.application.trading.TradingProvinceController;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Component
public class TradingProvinceResourceAssembler extends AbstractEnableResourceAssember<TradingProvinceDto> {

    public TradingProvinceResourceAssembler() {

        super(TradingProvinceController.class);
    }

}
