package org.srh.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * VIP Application
 * 
 * Date: 28 Nov 2018
 * @author Vivek
 */
@SpringBootApplication
@ComponentScan("org.srh.vipapp")
public class Application {

	public static void main(String[] args) {
	    System.setProperty("server.servlet.context-path", "/vip");
		SpringApplication.run(Application.class, args);
	}

}
