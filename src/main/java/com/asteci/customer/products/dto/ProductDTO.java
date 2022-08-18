package com.asteci.customer.products.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
	private long id;
	private String nombre;
	private String descripcion;
	private double precio;

}
