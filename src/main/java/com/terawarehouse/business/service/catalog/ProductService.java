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
package com.terawarehouse.business.service.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broodcamp.business.exception.ResourceFoundException;
import com.terawarehouse.data.entity.catalog.Product;
import com.terawarehouse.data.repository.catalog.ProductRepository;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * 
 * @since 0.0.1
 * @version 0.0.1
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product entity) {

        if (productRepository.findByCode(entity.getCode()).isPresent()) {
            throw new ResourceFoundException(Product.class, entity.getCode());
        }

        return productRepository.save(entity);
    }
}
