package com.auth.jwt;

import com.auth.jwt.controller.LoginController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JwtApplication {

	//private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
		//applicationContext = SpringApplication.run(JwtApplication.class, args);
		LoginController initalLogCtrl = new LoginController() ;

	}
}
