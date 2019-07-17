package com.terawarehouse.data.entity.catalog;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.broodcamp.data.entity.BusinessEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Edward P. Legaspi
 */
@Entity
@Table(name = "cat_product", uniqueConstraints = @UniqueConstraint(columnNames = { "category_id", "code" }))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ApiModel
public class Product extends BusinessEntity {

	private static final long serialVersionUID = 28353879194705314L;

	@JsonIgnore
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@NotNull
	@Column(name = "srp", precision = NB_PRECISION, scale = NB_DECIMALS)
	@Digits(integer = NB_PRECISION, fraction = NB_DECIMALS)
	private BigDecimal srp;

	@Column(name = "release_date")
	@Temporal(TemporalType.DATE)
	private Date releaseDate;

	public Product(Category category, String code, String description, BigDecimal srp) {
		super(code, description);
		this.category = category;
		this.srp = srp;
	}

	@Override
	public String toString() {
		return "Product [category=" + category.getCode() + ", brand=" + brand + ", srp=" + srp + ", releaseDate=" + releaseDate + "]";
	}

}
