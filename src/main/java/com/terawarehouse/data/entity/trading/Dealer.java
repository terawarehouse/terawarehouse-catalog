package com.terawarehouse.data.entity.trading;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.broodcamp.data.entity.BusinessEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
@Entity
@Table(name = "trading_dealer", uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class Dealer extends BusinessEntity {

	private static final long serialVersionUID = 4043233094839421557L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dealer_group_id", nullable = true)
	private DealerGroup dealerGroup;

}
