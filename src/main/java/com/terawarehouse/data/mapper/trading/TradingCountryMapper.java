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

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import com.broodcamp.data.mapper.GenericMapper;
import com.terawarehouse.business.domain.trading.TradingCountryDto;
import com.terawarehouse.data.entity.trading.TradingCountry;

import adm.com.broodcamp.data.repository.CountryRepository;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Mapper
public abstract class TradingCountryMapper implements GenericMapper<TradingCountry, TradingCountryDto> {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "country.name", target = "name")
    public abstract TradingCountryDto toDto(TradingCountry source);

    @AfterMapping
    public void afterMapping(TradingCountryDto source, @MappingTarget TradingCountry target) {

        if (source.getCountryId() != null) {
            countryRepository.findById(source.getCountryId()).ifPresent(target::setCountry);
        }
    }
}
