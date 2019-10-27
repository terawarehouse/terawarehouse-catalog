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
package com.terawarehouse.web.application.trading;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.web.application.AbstractEnableController;
import com.terawarehouse.business.domain.trading.TradingCountryDto;
import com.terawarehouse.data.entity.trading.TradingCountry;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@RestController
@RequestMapping(path = "trading/countries")
@Validated
public class TradingCountryController extends AbstractEnableController<TradingCountry, TradingCountryDto, UUID> {

}
