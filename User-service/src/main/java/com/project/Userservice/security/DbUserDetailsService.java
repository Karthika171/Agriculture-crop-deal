package com.project.Userservice.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.project.Userservice.entity.UserModel;
import com.project.Userservice.repo.UserRepo;

@Component
public class DbUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepo repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = repository.findByEmailId(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
		return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(),
				authorities);
	}
}