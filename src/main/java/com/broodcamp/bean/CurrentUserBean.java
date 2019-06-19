package com.broodcamp.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Edward P. Legaspi
 */
@Component
public class CurrentUserBean {

	@Bean
	public CurrentUser currentUser() {
		CurrentUser currentUser = new CurrentUser("Edward");
		return currentUser;
	}

}
