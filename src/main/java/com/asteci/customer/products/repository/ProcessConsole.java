package com.asteci.customer.products.repository;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class ProcessConsole implements Runnable{

	private String mensaje;

	@Override
	public void run() {
		 
		  log.info(mensaje);
		
	}
	
	
}
