package org.jsp.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.validation.constraints.Email;
@OpenAPIDefinition(info = @Info(title = "Rest API creation" ,  version = "4.3",   description = "this project is used to create rest api to perform the crud opration", contact = @Contact(name = "soumya",email="soumyabiradar856@gmail.com")))
@SpringBootApplication
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

}
