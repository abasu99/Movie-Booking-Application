package com.backend.moviebooking.service;

import java.net.http.HttpResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {
	
	public Boolean validateJwt(String jwt) {
		RestTemplate restTemplate=new RestTemplate();
		
		String authUrl="http://localhost:8081/auth/validate";
//		String authUrl="http://ec2-34-220-181-255.us-west-2.compute.amazonaws.com:8081/auth/validate";
		
		
		HttpHeaders header = new HttpHeaders();
		header.set("Authorization", jwt);
		header.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		header.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity<?> entity=new HttpEntity<>(header);
		
		ResponseEntity<Boolean> response=restTemplate.postForEntity(authUrl, entity, Boolean.class);
		return response.getBody();
	}

}
