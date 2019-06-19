package com.terawarehouse.data.entity.catalog;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.broodcamp.data.entity.BusinessEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Edward P. Legaspi
 */
@Entity
@Table(name = "cat_brand", uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class Brand extends BusinessEntity {

	private static final long serialVersionUID = 8264597326662589889L;

	public Brand(String code, String description) {
		super(code, description);
	}
}
