package com.asteci.customer.products.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asteci.customer.products.constants.Constantes;
import com.asteci.customer.products.dto.DetailSaleDTO;
import com.asteci.customer.products.service.CarCustomerService;
import com.asteci.customer.products.service.ProductService;
import com.asteci.customer.products.service.RestTemplateService;
 


@RestController
@RequestMapping(value = Constantes.CONTEXT_DOMAIN)
public class CardCustomerController {
	
	@Autowired
	ProductService prodServ;
	
	@Autowired
	CarCustomerService car;
	
	@Autowired
	RestTemplateService consume;
	
	@PostMapping(path = "/addproductcar",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveProductInCar(@Valid @RequestBody DetailSaleDTO productDTO, @RequestHeader(Constantes.HTTPHEAD_USER) String idCustomer ){
		return car.addProductCar(productDTO, idCustomer);
		
	}
	
	@GetMapping(path = "/carcustomer",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> viewCardCostumer( @RequestHeader(Constantes.HTTPHEAD_USER) String idCustomer ){
		
		return car.viewCard(idCustomer);
		}
	
	@PutMapping(path = "/updateproductcar",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatepiecesProductInCar(@Valid @RequestBody DetailSaleDTO dto, @RequestHeader(Constantes.HTTPHEAD_USER) String idCustomer ){
		
		
		return car.updateProductCard(dto, idCustomer);
		}
	
	@GetMapping(path = "/listproducts",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getProducts() {

		return prodServ.consultaProduct();
	}
	
	@DeleteMapping(path = "/delproduct/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteProducts(@Valid @PathVariable(value = "id") long idProduct ) {

		return prodServ.borrarProduct(idProduct);
	}
	
	
	@GetMapping(path = "/getholder",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getHolder() {

		return consume.viewJsonHolder();
	}
	


}
