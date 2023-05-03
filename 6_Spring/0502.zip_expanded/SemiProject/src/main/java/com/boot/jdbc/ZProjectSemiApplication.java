package com.boot.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
public class ZProjectSemiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZProjectSemiApplication.class, args);
	}
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}

}
