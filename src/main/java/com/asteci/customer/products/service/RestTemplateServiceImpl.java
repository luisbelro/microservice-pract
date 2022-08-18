package com.asteci.customer.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.asteci.customer.products.constants.Constantes;

@Service
public class RestTemplateServiceImpl implements RestTemplateService{

	@Autowired
	RestTemplate rest;
	
	@Value(Constantes.END_POINT_HOLDER)
	String URL;
	
	
	@Override
	public ResponseEntity<?> viewJsonHolder() {
		
		
		ResponseEntity<Object> res;
		
		
		HttpEntity<Object> head = new HttpEntity<Object>(null);
		res = rest.exchange(URL, HttpMethod.GET , head,Object.class);
		return res;
	}

}
