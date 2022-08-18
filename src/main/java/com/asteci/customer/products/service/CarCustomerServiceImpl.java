package com.asteci.customer.products.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.asteci.customer.products.dto.DetailSaleDTO;
import com.asteci.customer.products.dto.ResponseConsumeCustomer;
import com.asteci.customer.products.repository.CarSaleCustomerRepository;
import com.asteci.customer.products.repository.ProcessConsole;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CarCustomerServiceImpl implements CarCustomerService {

	@Autowired
	ProductService prod;
	
	@Override
	public ResponseEntity<?> addProductCar(DetailSaleDTO dto, String idCustomer) {
		
		boolean flgSave = false;
		List<DetailSaleDTO> listProduct = new ArrayList<DetailSaleDTO>() ;
		
		
		try {
			for (Entry<String, List<DetailSaleDTO>> carCustomer : CarSaleCustomerRepository.listCarCustomer.entrySet()){
				if(idCustomer.equals(carCustomer.getKey()))					
					listProduct = carCustomer.getValue();
			}
			
		
			if(prod.findByIdProduct(dto.getIdProducto()) && dto.getPieces()>0) {
				List<DetailSaleDTO> listAux =  new ArrayList<>(listProduct);
				Iterator<DetailSaleDTO> listRecorre = listAux.iterator();
				
					while(listRecorre.hasNext()) {	
						DetailSaleDTO prod = listRecorre.next();
						if(prod.getIdProducto() == dto.getIdProducto()) {
							listProduct.remove(prod);	
						} 
						
					}
				listProduct.add(dto);
				
						
				CarSaleCustomerRepository.listCarCustomer.put(new String(idCustomer),listProduct);
				CarSaleCustomerRepository.detailCte =listProduct;
				flgSave = true;
				
				
			}else {
				return new ResponseEntity<>("Validar Datos COD_PRODUCTO, PIECES",HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {}
		
		finally {
			try {
				if(flgSave)
					ejecutaDAO();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		ResponseConsumeCustomer resObject = new ResponseConsumeCustomer();
		for (Entry<String, List<DetailSaleDTO>> carCustomer : CarSaleCustomerRepository.listCarCustomer.entrySet()){
			if(idCustomer.equals(carCustomer.getKey()))	{
				resObject.setId(idCustomer);
				resObject.setCard(carCustomer.getValue());
				Double montototal = new Double(0);
				for(DetailSaleDTO producto :carCustomer.getValue()) {
					montototal +=   prod.findByPrice(producto.getIdProducto()) * producto.getPieces();
					
				}
				resObject.setTotals(montototal);
			}				
				
		}
		ResponseEntity<?> response = new ResponseEntity<>(resObject,HttpStatus.OK);
		return response;
		
	}

	@Override
	public ResponseEntity<?> viewCard(String idCustomer) {
		ResponseConsumeCustomer resObject = new ResponseConsumeCustomer();
		for (Entry<String, List<DetailSaleDTO>> carCustomer : CarSaleCustomerRepository.listCarCustomer.entrySet()){
			if(idCustomer.equals(carCustomer.getKey()))	{
				resObject.setId(idCustomer);
				resObject.setCard(carCustomer.getValue());
				Double montototal = new Double(0);
				for(DetailSaleDTO producto :carCustomer.getValue()) {
					montototal +=   prod.findByPrice(producto.getIdProducto()) * producto.getPieces();
					
				}
				resObject.setTotals(montototal);
			}				
				
		}
		ResponseEntity<?> response = new ResponseEntity<>(resObject,HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<?> updateProductCard(DetailSaleDTO dto, String idCustomer) {
		boolean flgSave = false;
		List<DetailSaleDTO> listProduct = new ArrayList<DetailSaleDTO>() ;
		
		
		try {
			for (Entry<String, List<DetailSaleDTO>> carCustomer : CarSaleCustomerRepository.listCarCustomer.entrySet()){
				if(idCustomer.equals(carCustomer.getKey()))					
					listProduct = carCustomer.getValue();
			}
			
		
			if(prod.findByIdProduct(dto.getIdProducto()) && dto.getPieces()>0) {
				List<DetailSaleDTO> listAux =  new ArrayList<>(listProduct);
				Iterator<DetailSaleDTO> listRecorre = listAux.iterator();
					boolean flgCtrol = false;
					while(listRecorre.hasNext()) {	
						DetailSaleDTO prod = listRecorre.next();
						if(prod.getIdProducto() == dto.getIdProducto()) {
							listProduct.remove(prod);	
							flgCtrol = true;
						} 
						
					}
				if(!flgCtrol) {
					return new ResponseEntity<>("No exite  producto a modificar",HttpStatus.ACCEPTED);	
					
				}
				listProduct.add(dto);
				
						
				CarSaleCustomerRepository.listCarCustomer.put(new String(idCustomer),listProduct);
				CarSaleCustomerRepository.detailCte =listProduct;
				flgSave = true;
				
				
			}else {
				return new ResponseEntity<>("Validar Datos COD_PRODUCTO, PIECES",HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {}
		
		finally {
			try {
				if(flgSave)
					ejecutaDAO();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		ResponseConsumeCustomer resObject = new ResponseConsumeCustomer();
		for (Entry<String, List<DetailSaleDTO>> carCustomer : CarSaleCustomerRepository.listCarCustomer.entrySet()){
			if(idCustomer.equals(carCustomer.getKey()))	{
				resObject.setId(idCustomer);
				resObject.setCard(carCustomer.getValue());
				Double montototal = new Double(0);
				for(DetailSaleDTO producto :carCustomer.getValue()) {
					montototal +=   prod.findByPrice(producto.getIdProducto()) * producto.getPieces();
					
				}
				resObject.setTotals(montototal);
			}				
				
		}
		ResponseEntity<?> response = new ResponseEntity<>(resObject,HttpStatus.OK);
		return response;
	}
	
	  public void ejecutaDAO() throws InterruptedException {
		  log.info("save data ..." );
		  ProcessConsole p = new ProcessConsole();
		  p.setMensaje("El producto ha sido agregado exitosamente.");
		 
		    Thread task = new Thread((Runnable)p);
		    task.sleep(8000);
		    task.start();
		     
		    } 
		  
	
	

}
