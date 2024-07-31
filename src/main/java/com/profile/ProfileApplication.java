package com.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



@SpringBootApplication
public class ProfileApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProfileApplication.class, args);
		System.out.println("=============== START =============== ");
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
//	@Bean
//	public String init() {
//		BaseEndpoint.Gateway.IP=ip;
//	    return null;
//	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

	    CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
	    corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
	    corsConfiguration.addAllowedMethod(HttpMethod.PATCH);
	    source.registerCorsConfiguration("/**", corsConfiguration);

	    return source;
	}
	

}
