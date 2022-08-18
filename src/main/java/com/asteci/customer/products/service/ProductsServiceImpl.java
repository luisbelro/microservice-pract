package com.asteci.customer.products.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.asteci.customer.products.dto.ProductDTO;
import com.asteci.customer.products.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductService {

	@Override
	public ResponseEntity<?> consultaProduct() {
		ResponseEntity<?> response = new ResponseEntity<>(ProductsRepository.productDTOs,HttpStatus.OK);
		return response;

	}

	@Override
	public ResponseEntity<?> borrarProduct(long product) {
		List<ProductDTO> listP = ProductsRepository.productDTOs;
		List<ProductDTO> listAux =  new ArrayList<>(listP);
		Iterator<ProductDTO> listRecorre = listAux.iterator();
		
		boolean flgDel = false;
			while(listRecorre.hasNext()) {	
				ProductDTO prod = listRecorre.next();
				if(prod.getId() == product) {
					listP.remove(prod);
					flgDel = true;
				} 

		}
		
		if(flgDel) {
			 ProductsRepository.productDTOs = listP;
			return ResponseEntity.ok().build();
		}else 
		{
			return ResponseEntity.notFound().build();
		}
		
	}

	@Override
	public boolean findByIdProduct(long id) {
		List<ProductDTO> listP = ProductsRepository.productDTOs;
		List<ProductDTO> listAux =  new ArrayList<>(listP);
		Iterator<ProductDTO> listRecorre = listAux.iterator();
		
		boolean flgDel = false;
			while(listRecorre.hasNext()) {	
				ProductDTO prod = listRecorre.next();
				if(prod.getId() == id) {
					flgDel = true;
				} 		
		
		}
		return flgDel;
	}

	@Override
	public double findByPrice(long id) {
		List<ProductDTO> listP = ProductsRepository.productDTOs;
		List<ProductDTO> listAux =  new ArrayList<>(listP);
		Iterator<ProductDTO> listRecorre = listAux.iterator();
		
		double monto = 0;
			while(listRecorre.hasNext()) {	
				ProductDTO prod = listRecorre.next();
				if(prod.getId() == id) {
					monto = prod.getPrecio();
				} 		
		
		}
		return monto;
	}
	
	
	

}
