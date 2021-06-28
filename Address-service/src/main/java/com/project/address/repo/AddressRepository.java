package com.project.address.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.address.entity.AddressModel;


public interface AddressRepository extends MongoRepository<AddressModel, Integer>{

	

}
