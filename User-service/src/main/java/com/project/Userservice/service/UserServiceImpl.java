package com.project.Userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Userservice.entity.UserModel;
import com.project.Userservice.repo.UserRepo;
import com.project.exceptions.DupDataFoundException;
import com.project.exceptions.NoRecordFoundException;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepo userDao;
	
	@Override
	public void add(UserModel userDto) throws DupDataFoundException {
		Optional<UserModel> userOptional= userDao.findById(userDto.getEmailId());
		if(userOptional.isPresent())
		{
			throw new DupDataFoundException("User Already Exists");
		}
		else {
			userDao.save(userDto);
		}

	}

	@Override
	public List<UserModel> getAllUsers()  {

		List<UserModel> userDto = new ArrayList<UserModel>();
		userDao.findAll().forEach(userDto1 -> userDto.add(userDto1));
		return userDto;

	}

	@Override
	public UserModel deleteByEmailId(String emailId) throws NoRecordFoundException {
		Optional<UserModel> userOptional= userDao.findById(emailId);
		if(!userOptional.isPresent())
		{
			throw new DupDataFoundException("User not Found");
		}
		else {
		return userDao.deleteByEmailId(emailId);
		}
	}
	
	
	@Override
	public UserModel update(String emailId, UserModel userDto) throws NoRecordFoundException {
		Optional<UserModel> userDto1= userDao.findById(emailId);
		if(userDto1.isPresent())
		{
			UserModel userUpdate=userDto1.get();
			userUpdate.setAddress(userDto.getAddress());
			userUpdate.setCity(userDto.getCity());
			userUpdate.setDistrict(userDto.getDistrict());
			userUpdate.setEmailId(userDto.getEmailId());
			userUpdate.setFirstName(userDto.getFirstName());
			userUpdate.setLastName(userDto.getFirstName());
			userUpdate.setMobileNo(userDto.getMobileNo());
			userUpdate.setPassword(userDto.getPassword());
			userUpdate.setPincode(userDto.getPincode());
			userUpdate.setState(userDto.getState());
			userUpdate.setRole(userDto.getRole());
			return userDao.save(userUpdate); 

		}
		return userDao.save(null); 
	}

	

	@Override
	public UserModel findByLogin(String login) throws NoRecordFoundException {

		if (login == null) {
			return null;
		}

		UserModel user = null;
		Optional<UserModel> find = userDao.findById(login);
		if (!find.isPresent() || find == null) {
			throw new NoRecordFoundException("User Not Found");
		}

		return userDao.findByEmailId(login);
	}

	@Override
	public UserModel signIn(String emailId, String password) {

		if (emailId == null && password == null) {
			return null;
		}
		UserModel user = userDao.findByEmailId(emailId);
		String email = user.getEmailId();
		String password1 = user.getPassword();
		if (!(email.equals(emailId) && password1.equals(password))) {
			return null;
		}
		return user;
	}

	
	

}