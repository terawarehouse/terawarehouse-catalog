package com.terawarehouse.data.entity.catalog;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.broodcamp.data.entity.BusinessEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
@Entity
@Table(name = "cat_category", uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class Category extends BusinessEntity {

	private static final long serialVersionUID = -5720318999765569672L;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category parentCategory;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Product> models;

	public Category(String code, String description) {
		super(code, description);
	}

}
