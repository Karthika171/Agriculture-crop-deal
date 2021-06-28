package com.project.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.address.entity.AddressModel;
import com.project.address.exceptions.RecordNotFoundException;
import com.project.address.service.IAddressService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin
@RestController
@RequestMapping("/test")
public class AddressController {
	
	@Autowired
    private IAddressService service;

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/address")
	@ApiOperation(value="Add address")
	public ResponseEntity<AddressModel> addAddress( @RequestBody AddressModel address){
		AddressModel addresses= service.add(address);
		if(addresses==null)
		{
			return new ResponseEntity("Sorry! Address not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AddressModel>(addresses, HttpStatus.OK);
	}  
	
	
	
	@PutMapping("/address")
	@ApiOperation(value="Update address")
	@SuppressWarnings({ "rawtypes", "unchecked" })

	public ResponseEntity<AddressModel> updateAddress(@RequestBody AddressModel address){
		AddressModel addresses= service.update(address);
		if(addresses==null)
		{
			return new ResponseEntity("Sorry! Address Not available!",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<AddressModel>(addresses, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/address/{addressId}")
	@ApiOperation(value="Delete address")

	public ResponseEntity<AddressModel> delete(@PathVariable("addressId")Integer addressId) throws RecordNotFoundException{
		AddressModel addresses= service.delete(addressId);
		if(addresses==null) {
			return new ResponseEntity("Sorry! AddressId not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AddressModel>(addresses, HttpStatus.OK);
}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/address/{addressId}")
	@ApiOperation(value="Find address by Id")

	public ResponseEntity<AddressModel> findById(@PathVariable("addressId")Integer addressId) throws RecordNotFoundException{
		AddressModel address= service.findById(addressId);
		if(address==null) {
			return new ResponseEntity("Sorry! Address not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<AddressModel>(address, HttpStatus.OK);
	}

	@GetMapping("/address")
	@ApiOperation(value="Get all address")

	public ResponseEntity<List<AddressModel>> getAddress(){
		List<AddressModel> addresses= service.getAddress();
		
		return new ResponseEntity<List<AddressModel>>(addresses, HttpStatus.OK);
	}
	
}





