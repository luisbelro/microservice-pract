package com.asteci.customer.products.service;

import org.springframework.http.ResponseEntity;

import com.asteci.customer.products.dto.DetailSaleDTO;


public interface CarCustomerService {
	
	ResponseEntity<?> addProductCar(DetailSaleDTO dto, String idCustomer);
	ResponseEntity<?> viewCard(String idCustomer);
	ResponseEntity<?> updateProductCard(DetailSaleDTO dto, String idCustomer);

}
