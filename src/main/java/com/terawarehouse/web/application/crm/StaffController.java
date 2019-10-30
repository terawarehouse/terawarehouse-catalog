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
package com.terawarehouse.web.application.crm;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.UUID;

import javax.transaction.NotSupportedException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.web.application.AbstractEnableController;
import com.terawarehouse.business.domain.crm.StaffDto;
import com.terawarehouse.business.service.crm.StaffService;
import com.terawarehouse.data.entity.crm.Staff;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@RestController
@RequestMapping(path = "/crm/staffs", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class StaffController extends AbstractEnableController<Staff, StaffDto, UUID> {

    @Autowired
    private StaffService staffService;

    @Override
    public ResponseEntity<EntityModel<StaffDto>> create(@RequestBody @NotNull @Valid StaffDto dto) throws NotSupportedException {

        Staff entity = genericMapper.toModel(dto);

        final EntityModel<StaffDto> resource = modelAssembler.toModel(genericMapper.toDto(staffService.save(entity)));
        return ResponseEntity.created(linkTo(controllerClass).slash(entity.getId()).withSelfRel().toUri()).body(resource);
    }
}
