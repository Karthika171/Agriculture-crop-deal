package com.project.Productservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.Productservice.entity.ProductModel;


@Repository
public interface ProductRepo extends MongoRepository<ProductModel, String> {
	public ProductModel findByName(String Name);
	public void deleteByName(String Name);
}