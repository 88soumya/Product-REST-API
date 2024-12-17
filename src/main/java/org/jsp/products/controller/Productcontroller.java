package org.jsp.products.controller;

import java.util.List;

import org.jsp.products.dto.Product;
import org.jsp.products.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//combination of the contoller and the responsebody
//Responseentity is used when we want the response along with the status code like 201 cod efor saving

public class Productcontroller {
	@Autowired
	Productservice service;
	
	//Saving One Product
	@PostMapping("/products")
	public ResponseEntity<Object> saveProduct(@RequestBody Product product){
		return service.saveProduct(product);
		//@requestBody it's a convenient way to receive complex data structures from clients, such as a Product with multiple attributes,
		//in a structured and standardized format (JSON).
	}
	
	//Save Multiple Products
	@PostMapping("/products/many")
	public ResponseEntity<Object> saveProducts(@RequestBody List<Product> products){
		return service.saveProducts(products);
	}
	
	//fectching ny id
	@GetMapping("/products")
	public ResponseEntity<Object> fetchAllProducts(){
		return service.fechAllproduct();
	}
	
	//fetch by id
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Object> fetchById(@PathVariable int id){
		return service.fetchById(id);
	}
	//Fetch Product By Name
		@GetMapping("/products/name/{name}")
		public ResponseEntity<Object> fetchByName(@PathVariable String name){
			return service.fetchByName(name);
		}
		
		//Fetch Products Price Greater Than
		@GetMapping("/products/price/greater/{price}")
		public ResponseEntity<Object> fetchByPriceGreater(@PathVariable double price){
			return service.fetchByPriceGreater(price);
		}
		
		//Fetch Products By Stock Between
		@GetMapping("/products/stock/{min}/{max}")
		public ResponseEntity<Object> fetchByStockBetween(@PathVariable int min,@PathVariable int max){
			return service.fetchByStockBetween(min,max);
		}
		@GetMapping("/products/values/price/{min}/{max}")
		public ResponseEntity<Object> fetchByPriceBetween(@PathVariable double min,@PathVariable double max){
			return service.fetchByPriceBetween(min,max);
		}
		@GetMapping("/products/values/name/contains/{infi}")
		public ResponseEntity<Object> findByNameContaining( @PathVariable String infi){
			return service.findByNameContaining(infi);
		}
		@DeleteMapping("/products/{id}")
		public ResponseEntity<Object> deleteById(@PathVariable int id){
			return service.deleteById(id);
		}
		//update
		//for put mapping all values shoud be passed if not passed that will take the null
		//when we want full update of object we go for the put mapping
		//Update Product - PUT
		@PutMapping("/products")
		public ResponseEntity<Object> updateRecord(@RequestBody Product product){
			return service.updateProduct(product);
		}
		
		//patch
	
		@PatchMapping("/products/{id}")
		public ResponseEntity<Object> updateRecord(@PathVariable int id,@RequestBody Product product){
			return service.updateProduct(id,product);
		}
}
