package com.project.Productservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.Productservice.entity.ProductModel;
import com.project.Productservice.service.IProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/test")
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	
	@GetMapping("/products")
	@ApiOperation(value="Get all products")
	ResponseEntity <List<ProductModel>> getAllProducts(){
		List<ProductModel> products=service.getAllProducts();
		return new ResponseEntity<List<ProductModel>>(products,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	@ApiOperation(value="Add products")

	public ResponseEntity <ProductModel> add(@Valid @RequestBody ProductModel productDto)
	{
		ProductModel products= service.add(productDto);
		return new ResponseEntity <ProductModel>(products, HttpStatus.OK);		

	}
	
	@PutMapping("/update")
	@ApiOperation(value="Update products")
	public ResponseEntity <ProductModel> update(@Valid @RequestBody ProductModel productDto)
	{
		ProductModel products=service.update(productDto);
		return new ResponseEntity <ProductModel>(products, HttpStatus.OK);		
	}
	
	@GetMapping("/products/{productName}")
	@ApiOperation(value="Find products by name")
	public ResponseEntity <ProductModel> findByName(@Valid @PathVariable("productName") String productName)  
	{
		ProductModel products=service.findByName(productName);
		return new ResponseEntity <ProductModel>(products, HttpStatus.OK);		

	}
	
	@DeleteMapping("/delete/{productName}")
	@ApiOperation(value="Delete products by name")
	public ResponseEntity <ProductModel> delete (@Valid @PathVariable("productName") String productName)  
	{
		ProductModel products= service.delete(productName);
		return new ResponseEntity <ProductModel>(products, HttpStatus.OK);		

	}
	
	
	

}
