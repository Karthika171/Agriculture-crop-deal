package com.project.address.service;




import java.util.List;

import org.springframework.stereotype.Service;

import com.project.address.entity.AddressModel;
import com.project.address.exceptions.RecordNotFoundException;

@Service
public interface IAddressService {
	
	public AddressModel add(AddressModel address) ; 
	
	public AddressModel update(AddressModel address) ;
	
	public AddressModel delete(Integer id) throws  RecordNotFoundException;

	public AddressModel findById(Integer addressId);

	public List<AddressModel> getAddress();

}


