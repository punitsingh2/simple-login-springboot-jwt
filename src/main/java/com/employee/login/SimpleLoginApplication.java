package com.employee.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.employee.login.config.JwtFilter;

@SpringBootApplication
public class SimpleLoginApplication {
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/employee/*");

		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleLoginApplication.class, args);
	}

}
