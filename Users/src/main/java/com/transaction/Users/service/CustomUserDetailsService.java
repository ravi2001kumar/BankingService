package com.transaction.Users.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.transaction.Users.repository.UserRepository;

@Service
public class CustomUserDetailsService  implements UserDetailsService {
	@Autowired
	public UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(!repo.findByUsername(username).isEmpty())
		{
			return new User(username,repo.findByUsername(username).getPassword(),new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("User not found !!");
		}
	}

}
