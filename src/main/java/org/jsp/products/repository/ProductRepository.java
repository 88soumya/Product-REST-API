package org.jsp.products.repository;

import java.util.List;

import org.jsp.products.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByName(String name);
	//JpaRepository is the interface which is used to perform the CRUD operation
	//<product,Interger>here the product which reresent the entity that is for which class object is created
	//the Integer is the wrapper class of the primapry key datatype 

	List<Product> findByPriceGreaterThanEqual(double price);

	List<Product> findByStockBetween(int min, int max);

	List<Product> findByPriceBetween(double min, double max);

	List<Product> findByNameContaining(String infi);
}