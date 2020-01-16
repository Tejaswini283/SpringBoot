package com.deloitte.demospringtool.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.deloitte.demospringtool.model.Product;





@Repository

public interface ProductRepo extends JpaRepository<Product,Integer>{

		

	

		@Query("from Product where productName=:productName")

		public Product findByproductName(String productName);

		public Product findByproductNameAndPrice(String productName,float price);

		@Query("from Product where price between :from and :to")

		public List<Product> findProductsInRange(float from,float to);

}

//localhost:8888/Products/name/{pName}/price/{price}
//localhost:8888/Products/price/from/{pName}/to/{to}