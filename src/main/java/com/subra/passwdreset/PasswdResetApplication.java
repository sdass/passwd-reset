package com.subra.passwdreset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class PasswdResetApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswdResetApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	ShaPasswordEncoder shaPasswordEncoder(){
		//return new ShaPasswordEncoder(512);
		return new ShaPasswordEncoder(256);
	}
}
