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
package com.terawarehouse.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Component
public class StartupApplicationListener {

    private static final Logger log = LoggerFactory.getLogger(StartupApplicationListener.class);

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("   \r\n<Terawarehouse Open-source Inventory and Management System>\r\n" + //
                "    Copyright (C) 2019 Edward P. Legaspi (https://github.com/czetsuya)\r\n" + //
                "    This program comes with ABSOLUTELY NO WARRANTY.\r\n" + //
                "    This is free software, and you are welcome to redistribute it\r\n" + //
                "    under certain conditions.");
    }
}
