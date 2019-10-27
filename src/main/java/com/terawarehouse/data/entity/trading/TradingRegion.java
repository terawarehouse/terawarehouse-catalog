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
package com.terawarehouse.data.entity.trading;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.broodcamp.data.entity.EnableEntity;
import com.broodcamp.data.entity.adm.Region;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Entity
@Table(name = "trading_region", uniqueConstraints = @UniqueConstraint(columnNames = { "region_id" }))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class TradingRegion extends EnableEntity {

    private static final long serialVersionUID = 7237526425436248970L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trading_country_id")
    private TradingCountry tradingCountry;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;
}
