package com.terawarehouse.data.entity.trading;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.broodcamp.data.entity.BusinessEntity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Edward P. Legaspi
 */
@Entity
@Table(name = "trading_dealer_group", uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel
public class DealerGroup extends BusinessEntity {

	private static final long serialVersionUID = 4913493997353328570L;

	@OneToMany(mappedBy = "dealerGroup")
	private List<Dealer> dealers;

}
