/**
 * (C) Copyright 2019 Edward P. Legaspi (https://github.com/czetsuya).
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.broodcamp.data.entity;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonView;
import com.terawarehouse.data.view.catalog.CategoryView;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
public abstract class AuditableEntity extends BaseEntity {

	private static final long serialVersionUID = 2522072952461930125L;

	@Embedded
	@JsonView(CategoryView.Internal.class)
	private Auditable auditable;

	public void updateAudit(String userRef) {
		if (auditable == null) {
			auditable = new Auditable(userRef);
		} else {
			auditable.updateWith(userRef);
		}
	}

}
