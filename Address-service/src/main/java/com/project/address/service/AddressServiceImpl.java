package com.project.address.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.address.entity.AddressModel;
import com.project.address.exceptions.RecordNotFoundException;
import com.project.address.repo.AddressRepository;


@Service
public class AddressServiceImpl implements IAddressService{

	 @Autowired
	  public AddressRepository addressRepository;

		

			
	@Override
	public AddressModel add(AddressModel addressDTO) {
		AddressModel addressReturn=addressRepository.save(addressDTO);
		return addressReturn;
	}

	@Override
	public AddressModel update(AddressModel addressDTO) {
		AddressModel addressReturn=addressRepository.save(addressDTO);
		return addressReturn;
	}

	@Override
	public AddressModel delete(Integer addressId) throws RecordNotFoundException {
		try {
			addressRepository.deleteById(addressId);
			}
			catch(Exception e) {
				throw new RecordNotFoundException("No records found.");
			}
		
		return null;
	}

	@Override
	public AddressModel findById(Integer addressId) {
	Optional<AddressModel> address = addressRepository.findById(addressId);
		
		return address.get();
	}
	@Override
	public List<AddressModel> getAddress() {
		
		List<AddressModel> addressReturn = new ArrayList<>();
		List<AddressModel> addresses = addressRepository.findAll();
		for (AddressModel a : addresses ) {
			addressReturn.add(a);
		}
		
		return addressReturn;
	}


	
	}
