package com.asteci.customer.products.repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.asteci.customer.products.dto.DetailSaleDTO;

import lombok.Data;

@Data
public class CarSaleCustomerRepository {
	
	public static Map<String, List<DetailSaleDTO>> listCarCustomer = new TreeMap<String,  List<DetailSaleDTO> >();
	public static List<DetailSaleDTO> detailCte;
	
}
