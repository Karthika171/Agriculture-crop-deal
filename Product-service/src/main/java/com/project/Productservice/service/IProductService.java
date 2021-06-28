package com.project.Productservice.service;

import java.util.List;

import com.project.Productservice.entity.ProductModel;
import com.project.Productservice.exceptions.NoRecordFoundException;

public interface IProductService {

	public ProductModel add(ProductModel productDto);

	public ProductModel update(ProductModel bean);

	public ProductModel delete(String Name) throws NoRecordFoundException;

	public ProductModel findByName(String Name) throws NoRecordFoundException;

	public List<ProductModel> getAllProducts() throws NoRecordFoundException;

}