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
package com.terawarehouse.data.mapper.crm;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import com.broodcamp.data.mapper.GenericMapper;
import com.terawarehouse.business.domain.crm.StaffDto;
import com.terawarehouse.data.entity.crm.Staff;
import com.terawarehouse.data.repository.crm.AgencyRepository;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Mapper
public abstract class StaffMapper implements GenericMapper<Staff, StaffDto> {

    @Autowired
    private AgencyRepository agencyRepository;

    @Override
    @Mapping(target = "agencyId", source = "agency.id")
    public abstract StaffDto toDto(Staff source);

    @AfterMapping
    public void fillAgency(StaffDto source, @MappingTarget Staff target) {

        if (source.getAgencyId() != null) {
            agencyRepository.findById(source.getAgencyId()).ifPresent(target::setAgency);
        }
    }
}
