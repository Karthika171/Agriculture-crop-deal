package com.project.Userservice.controller;


import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.client.RestTemplate;

import com.project.Userservice.entity.UserModel;
import com.project.Userservice.service.IUserService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin
@RestController
@RequestMapping("/test")
public class UserController {
	
	
	  @Autowired 
	  private IUserService userService;
	  
	
	@PostMapping("/add")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiOperation(value="Add address")
	public String add(@RequestBody UserModel userModel)
	{ 
		userService.add(userModel);
		return ("user added successfully");
		
	}

	@GetMapping("/users")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiOperation(value="Get all users")
	public List<UserModel> getAllUsers()
	{
		return userService.getAllUsers();
	}

		  
	  @DeleteMapping("/delete/{emailId}") 
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	  @ApiOperation(value="Delete by emailId")

	  public ResponseEntity<UserModel> deleteByEmailId(@PathVariable("emailId") String emailId) {
	  UserModel users= userService.deleteByEmailId(emailId);
	  if(users==null)
	  {
	  return new ResponseEntity("Sorry! emailId not available!", 
				HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<UserModel>(users, HttpStatus.OK);
		
	  }
		

		
		  @PutMapping("/address") 
		  @SuppressWarnings({ "unchecked", "rawtypes" })
		  @ApiOperation(value="Update address")
		  
		  public ResponseEntity<UserModel> update(@RequestBody UserModel address,String
		  emailId){ UserModel addresses= userService.update(emailId, address);
		  if(addresses==null) { return new
		  ResponseEntity("Sorry! Address Not available!",HttpStatus.NOT_FOUND); }
		  
		  return new ResponseEntity<UserModel>(addresses, HttpStatus.OK); }
		 
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/find/{email}")
	@ApiOperation(value="Find by emailId")

	public ResponseEntity<UserModel> findByLogin(@Valid @PathVariable("email") String emailId) {

		UserModel user = userService.findByLogin(emailId);
		if (user == null) {
			return new ResponseEntity("Sorry! User not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserModel>(user, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/login")
	@ApiOperation(value="Sign in")

	public ResponseEntity<UserModel> loginUser(@RequestBody UserModel userDto) {
		UserModel user = userService.findByLogin(userDto.getEmailId());
		if(user == null) {
			return new ResponseEntity("Sorry! Users not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserModel>(user, HttpStatus.OK);
	
	}
}
