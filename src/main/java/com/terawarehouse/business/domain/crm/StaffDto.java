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
package com.terawarehouse.business.domain.crm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.broodcamp.data.dto.EnableEntityDto;
import com.broodcamp.data.dto.adm.UserAccountDto;
import com.terawarehouse.business.domain.trading.TradingStaffBranchDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StaffDto extends EnableEntityDto {

    @NotNull
    private UserAccountDto userAccount;

    @NotNull
    private UUID agencyId;

    @NotNull
    private Date dateHired;

    private BigDecimal quota;
    private List<TradingStaffBranchDto> tradingStaffBraches;
}
