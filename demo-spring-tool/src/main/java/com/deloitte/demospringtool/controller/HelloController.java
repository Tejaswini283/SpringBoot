package com.deloitte.demospringtool.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import org.springframework.stereotype.Controller;





import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.deloitte.demospringtool.model.Product;
import com.deloitte.demospringtool.service.ProductService;
import com.deloitte.demospringtool.util.ProductNotFoundException;






@RestController



public class HelloController {



//	@GetMapping("/hello")

//	public String sayHello(Model m)

//	{

//		System.out.println("hello");

//		m.addAttribute("msg","How are you?");

//		return "show";

//	}

		@Autowired

		ProductService service;

	

		@PostMapping("/products")//post mapping is for creating resources

		public Product saveProduct(@RequestBody Product product)

		{

			return service.saveProduct(product);

		}

		

		@GetMapping("/products")//in get mapping it is retreiving

		public List<Product> getAllProducts()

		{

			return service.getAllProducts();

		}

		

		@GetMapping("/products/{pId}")

		public Product getProductById(@PathVariable("pId")int pId)

		{

			return service.getProductById(pId);

		}

		@GetMapping("/products/name/{pName}")

		public Product getProductByName(@PathVariable("pName") String pName)

		{

			return service.getProductByName(pName);

		}

		@GetMapping("/products/name/{pName}/price/{price}")

		public Product getProductByNameAndPrice(@PathVariable("pName") String pName,@PathVariable("price")float price)

		{

			return service.getProductByNameAndPrice(pName,price);

		}

		@GetMapping("/products/price/range/from/{from}/to/{to}")

		public List<Product> getProductsInRange(@PathVariable("from") float from,@PathVariable("to") float to)

		{

			return service.getProductsInRange(from,to);

		}


	@DeleteMapping("/products/{pId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("pId")int pId){
	ResponseEntity<Product>  deletedProduct;
	if(!service.checkIfExists(pId)) {
		throw new ProductNotFoundException("pId: "+pId);
	}
	service.deleteProductById(pId);
	deletedProduct =new  ResponseEntity<Product>(HttpStatus.OK);
	
	return deletedProduct;

	}	

}