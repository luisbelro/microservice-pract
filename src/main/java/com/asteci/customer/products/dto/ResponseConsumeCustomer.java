package com.asteci.customer.products.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ResponseConsumeCustomer implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private List<DetailSaleDTO> card;
	private double totals;
	

}
