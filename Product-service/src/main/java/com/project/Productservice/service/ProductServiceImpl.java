package com.project.Productservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Productservice.entity.ProductModel;
import com.project.Productservice.exceptions.NoRecordFoundException;
import com.project.Productservice.repo.ProductRepo;


@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepo productDao;
	
	 
	@Override
	public List<ProductModel> getAllProducts() throws NoRecordFoundException{

		List<ProductModel> productDTO = new ArrayList<>();
		for(ProductModel c:productDao.findAll())
		{
			productDTO.add(c);
		}
		if(productDTO.isEmpty())
		{
			throw new NoRecordFoundException("Records Not Exists");
		}
		
		
		return productDTO;
	}
	
	@Override
	public ProductModel add(ProductModel productDto){
		
		ProductModel prodReturn=productDao.save(productDto);
		return prodReturn;
	}	

	@Override
		public ProductModel delete(String Name) throws NoRecordFoundException {
			try {
				productDao.deleteByName(Name);
				}
				catch(Exception e) {
					throw new NoRecordFoundException("No records found.");
				}
			
			return null;
		}


	@Override
	public ProductModel findByName(String Name) throws NoRecordFoundException{
		if(Name.length() == 0)
		{
			return null;
		}
		Optional<ProductModel>find = Optional.of(productDao.findByName(Name));
		if(!find.isPresent() || find == null)
		{
			throw new NoRecordFoundException("Records Not Exists");
		}
		
		
		return (find.get());
	}


	@Override
	public ProductModel update(ProductModel bean){
		ProductModel prodReturn=productDao.save(bean);
		return prodReturn;
		
	}


}