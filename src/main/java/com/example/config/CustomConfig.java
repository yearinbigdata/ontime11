package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig implements CommandLineRunner{


	@Value("${spring.profiles.active}")
	String profile;

	@Value("${spring.datasource.driver-class-name}")
	String cls;
	@Value("${spring.datasource.url}")
	String url;
	@Value("${spring.datasource.username}")
	String username;

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("###");
		System.out.println("### profile=" + profile);
		System.out.println("### cls=" + cls);
		System.out.println("### url=" + url);
		System.out.println("### username=" + username);
		System.out.println("###");
	}
	
}
