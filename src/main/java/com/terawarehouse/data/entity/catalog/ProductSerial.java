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
package com.terawarehouse.data.entity.catalog;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.broodcamp.data.entity.BaseEntity;
import com.terawarehouse.data.entity.trading.Dealer;
import com.terawarehouse.data.entity.trading.TradingBranch;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Entity
@Table(name = "cat_serial" //
		, uniqueConstraints = @UniqueConstraint(columnNames = { "product_id", "branch_id", "serial_no" }) //
		, indexes = { @Index(columnList = "serial_no", unique = false), @Index(columnList = "warranty_card_no", unique = false) } //
)
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class ProductSerial extends BaseEntity {

	private static final long serialVersionUID = 7901377279454273062L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_id")
	private TradingBranch tradingBranch;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@NotNull
	@Column(name = "serial_no", length = 100, nullable = false, updatable = false)
	private String serialNo;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private ProductSerialStatusEnum status = ProductSerialStatusEnum.CREATED;

	@Column(name = "warranty_card_no", length = 100)
	private String warrantyCardNo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dealer_id", nullable = true)
	private Dealer dealer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false)
	private Date created;

}
