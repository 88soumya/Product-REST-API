package org.jsp.products.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jsp.products.dto.Product;
import org.jsp.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class Productservice {
	@Autowired
	ProductRepository repository;
	public ResponseEntity<Object> saveProduct(Product product) {
		repository.save(product);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Product Added Success");
		map.put("data", product);
		return new ResponseEntity<Object>(map, HttpStatus.CREATED);//the HTTPStatus.Created is used to give the status code
	}
	public ResponseEntity<Object> saveProducts(List<Product> products) {
		repository.saveAll(products);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Product Added Success");
		map.put("data", products);
		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
	}
	
	//fetching
	public ResponseEntity<Object> fechAllproduct() {
		// TODO Auto-generated method stub
		List<Product> list=repository.findAll();
		if(list.isEmpty()) {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("error", "no product found");
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
		}
		else {
			List<Product> list1=repository.findAll();
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("message", "all items are fetched sucessfully");
			map.put("data", list1);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		}
	}
	public ResponseEntity<Object> fetchById(int id) {
		// TODO Auto-generated method stub
		//we have to take the optional when we are fetching the only one value i.e if no object is there means that should be return somthing 
		//instead of null
		Optional<Product> list=repository.findById(id);
		if(list.isEmpty()) {
			Map<String, Object>map=new HashMap<String, Object>();
			map.put("error", "no data found with id "+id);
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
		}
		else {
			
			Map<String, Object>map=new HashMap<String, Object>();
			map.put("message", "the value is found with id ");
			map.put("data", list);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		}
	}
	public ResponseEntity<Object> fetchByName(String name) {
		// TODO Auto-generated method stub
		List<Product>list=repository.findByName(name);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found with Name :"+name);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	
	}
	
	public ResponseEntity<Object> fetchByPriceGreater(double price) {
		List<Product> list = repository.findByPriceGreaterThanEqual(price);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found Price Greater Than: "+price);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	public ResponseEntity<Object> fetchByStockBetween(int min, int max) {
		List<Product> list = repository.findByStockBetween(min,max);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found Stock Between: "+min+" and "+max);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	public ResponseEntity<Object> fetchByPriceBetween(double min, double max) {
		// TODO Auto-generated method stub
		List<Product> list = repository.findByPriceBetween(min,max);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found Stock Between: "+min+" and "+max);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	public ResponseEntity<Object> findByNameContaining(String infi) {
		// TODO Auto-generated method stub
		List<Product> list = repository.findByNameContaining(infi);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found ");
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	public ResponseEntity<Object> deleteById(int id) {
		// TODO Auto-generated method stub
	   Optional<Product> optional=repository.findById(id);
	   if(optional.isEmpty()) {
		   Map<String, Object>map=new HashMap<String,Object>();
		   map.put("error", "the id is not found");
		   return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
	   }
	   else {
		   Map<String, Object>map=new HashMap<String,Object>();
		   repository.deleteById(id);
		   map.put("message", "the data is deleted ");
		   return new ResponseEntity<Object>(map,HttpStatus.OK);
	   }
	}
	public ResponseEntity<Object> updateProduct(Product product) {
		// TODO Auto-generated method stub
	   repository.save(product);
	   Map<String,Object>map=new HashMap<String, Object>();
	   map.put("message", "products are successfully updated");
	   return new ResponseEntity<Object>(map,HttpStatus.OK);
	}
	
	public ResponseEntity<Object> updateProduct(int id, Product product) {
		Optional<Product> optional = repository.findById(id);
		if(optional.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Product Found with Id: "+id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}else {
Map<String, Object> map = new HashMap<String, Object>();
			
			Product existingProduct = optional.get();
			if(product.getName()!=null)
				existingProduct.setName(product.getName());
			if(product.getDescription()!=null)
				existingProduct.setDescription(product.getDescription());
			if(product.getPrice()!=0)
				existingProduct.setPrice(product.getPrice());
			if(product.getStock()!=0)
				existingProduct.setStock(product.getStock());
			
			repository.save(existingProduct);
			
			
			map.put("message", "Product Updated Success");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
		}

}
