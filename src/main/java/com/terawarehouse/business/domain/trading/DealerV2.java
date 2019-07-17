package com.terawarehouse.business.domain.trading;

import com.broodcamp.data.entity.Name;

/**
 * @author Edward P. Legaspi
 */
public class DealerV2 {

	private Long id;
	private Name name;

	public DealerV2() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DealerV2(Name name) {
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}
