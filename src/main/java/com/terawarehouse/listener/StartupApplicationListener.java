package com.terawarehouse.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Edward P. Legaspi
 */
@Component
public class StartupApplicationListener {

	private static final Logger log = LoggerFactory.getLogger(StartupApplicationListener.class);

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("Welcome to TeraWHARS");
	}
}
