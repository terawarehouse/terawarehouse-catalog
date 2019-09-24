package com.broodcamp.data.entity;

import java.io.Serializable;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
public interface IEntity {

	Serializable getId();

	boolean isTransient();
}
