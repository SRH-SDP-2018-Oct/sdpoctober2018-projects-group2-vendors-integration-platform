package org.srh.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Netti Application
 * 
 * Date: 28 Nov 2018
 * @author Vivek
 */
@SpringBootApplication
@ComponentScan("org.srh.nettiapp")
public class Application {

	public static void main(String[] args) {
	    System.setProperty("server.servlet.context-path", "/nettiapp");
		SpringApplication.run(Application.class, args);
	}

}
