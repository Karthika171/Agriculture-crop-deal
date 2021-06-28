package com.project.Userservice.service;



import java.util.List;

import com.project.Userservice.entity.UserModel;
import com.project.exceptions.DupDataFoundException;
import com.project.exceptions.NoRecordFoundException;

public interface IUserService {
	    
    public void add(UserModel userDto) throws DupDataFoundException;
    
    public List<UserModel> getAllUsers();
	
	public UserModel deleteByEmailId(String emailId)throws NoRecordFoundException;
	
	public UserModel update(String emailId, UserModel userDto ) throws NoRecordFoundException ;
	
	public UserModel findByLogin(String login) throws NoRecordFoundException;

	public UserModel signIn(String emailId, String password);
}
