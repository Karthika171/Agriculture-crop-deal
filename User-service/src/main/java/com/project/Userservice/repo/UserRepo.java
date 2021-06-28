package com.project.Userservice.repo;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.Userservice.entity.UserModel;

@Repository
public interface UserRepo extends MongoRepository<UserModel,String> {

	UserModel findByEmailId(String EmailId);
	UserModel deleteByEmailId(String emailId);

	

} 
