package com.asteci.customer.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.asteci.customer.products.util.JsonResourceUtils;

@SpringBootApplication
public class MsacmEDomainCustomerProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsacmEDomainCustomerProductsApplication.class, args);
		
		 JsonResourceUtils jsonsrc = new JsonResourceUtils();
		 jsonsrc.putProducts();
	}

}
