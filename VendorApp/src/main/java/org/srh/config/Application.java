package org.srh.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.srh.vipapp")
public class Application {

	public static void main(String[] args) {
	    System.setProperty("server.servlet.context-path", "/vip");
		SpringApplication.run(Application.class, args);
	}

}
