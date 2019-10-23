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
package com.terawarehouse.web.application.trading;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.data.entity.shared.Name;
import com.terawarehouse.business.domain.trading.DealerV1;
import com.terawarehouse.business.domain.trading.DealerV2;

/**
 * Using version in parameter is useful for book marking.
 * 
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@RestController
public class DealerVersionController {

	@GetMapping("v1/dealers")
	public DealerV1 dealerV1() {
		return new DealerV1("Kerri Chan");
	}

	@GetMapping("v2/dealers")
	public DealerV2 dealerV2() {
		return new DealerV2(new Name("Kerri", "Chan"));
	}

	@GetMapping(value = "/dealers/param", params = "version=1")
	public DealerV1 paramV1() {
		return new DealerV1("Kerri Chan");
	}

	@GetMapping(value = "/dealers/param", params = "version=2")
	public DealerV2 paramV2() {
		return new DealerV2(new Name("Kerri", "Chan"));
	}

	@GetMapping(value = "/dealers/header", headers = "X-API-VERSION=1")
	public DealerV1 headerV1() {
		return new DealerV1("Kerri Chan");
	}

	@GetMapping(value = "/dealers/header", headers = "X-API-VERSION=2")
	public DealerV2 headerV2() {
		return new DealerV2(new Name("Kerri", "Chan"));
	}

	@GetMapping(value = "/dealers/produces", produces = "application/vnd.czetsuya.app-v1+json")
	public DealerV1 producesV1() {
		return new DealerV1("Kerri Chan");
	}

	@GetMapping(value = "/dealers/produces", produces = "application/vnd.czetsuya.app-v2+json")
	public DealerV2 producesV2() {
		return new DealerV2(new Name("Kerri", "Chan"));
	}
	
}
