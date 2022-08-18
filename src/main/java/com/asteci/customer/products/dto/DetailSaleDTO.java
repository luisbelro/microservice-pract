package com.asteci.customer.products.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DetailSaleDTO {

	@NotNull(message ="se requiere el codigo del producto")
	private long idProducto;
	
	@NotNull(message ="se requiere por lo menos una pieza del producto")
	@Size(min = 1)
	private int pieces;
	
}
