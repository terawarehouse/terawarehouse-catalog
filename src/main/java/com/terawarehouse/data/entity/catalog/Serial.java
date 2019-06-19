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
 * @author Edward P. Legaspi
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
public class Serial extends BaseEntity {

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
	private SerialStatusEnum status = SerialStatusEnum.CREATED;

	@Column(name = "warranty_card_no", length = 100)
	private String warrantyCardNo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dealer_id", nullable = true)
	private Dealer dealer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false)
	private Date created;

}
