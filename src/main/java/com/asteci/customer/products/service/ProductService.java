package com.asteci.customer.products.service;

import org.springframework.http.ResponseEntity;


public interface ProductService {

	
	ResponseEntity<?> consultaProduct();
	ResponseEntity<?> borrarProduct(long product);
	boolean findByIdProduct(long id);
	double findByPrice(long id);
}
