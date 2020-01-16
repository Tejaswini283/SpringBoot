package com.deloitte.demospringtool.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.deloitte.demospringtool.model.Product;
import com.deloitte.demospringtool.repo.ProductRepo;





@Service

public class ProductService {



	@Autowired

	ProductRepo repo;

	public Product saveProduct(Product product)

	{

		return repo.save(product);

	}

	

	public List<Product> getAllProducts()

	{

		return repo.findAll();

	}

	public Product getProductById(int pId)

	{

		return repo.getOne(pId);



	}
	public void deleteProductById(int pId) {
		repo.deleteById(pId);
	}
	public boolean checkIfExists(int pId) {
		return repo.existsById(pId);
		
	}
	

	

	public Product getProductByName(String pName)

	{

		return repo.findByproductName(pName);



	}

	public Product getProductByNameAndPrice(String pName,float price)

	{

		return repo.findByproductNameAndPrice(pName,price);



	}

	public List<Product> getProductsInRange(float from,float to)

	{

		return repo.findProductsInRange(from,to);

	}
	

	

}