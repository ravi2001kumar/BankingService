package com.transaction.Users.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.Users.entity.User;
import com.transaction.Users.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	public UserRepository uRepo;
	
	public List<User> getAllCustomers() {
		List<User> bank = new ArrayList<>();
		uRepo.findAll().forEach(bank::add);
		return bank;
	}

	public User fetchCustomerById(Long id) {
		return uRepo.findById(id);
	}

	

	public void deleteCustomerById(Long id) {
		uRepo.deleteById(id);
	}

	public User updateCustomer(Long id, User user) {
		User bnkDB = uRepo.findById(id);
		if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
			bnkDB.setName(user.getName());
		}
		if (Objects.nonNull(user.getPin()) && !"".equalsIgnoreCase(user.getPin())) {
			bnkDB.setPin(user.getPin());
		}
		if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
			bnkDB.setEmail(user.getEmail());
		}
		if (Objects.nonNull(user.getContactNo()) && !"".equalsIgnoreCase(user.getContactNo())) {
			bnkDB.setContactNo(user.getContactNo());
		}
		
		
		return uRepo.save(bnkDB);
	}

	public User addCustomer(User bank) {
		// TODO Auto-generated method stub
		return uRepo.save(bank);
	}

	public User fetchByContactNumber(String contactNo) {
		// TODO Auto-generated method stub
		return uRepo.findByContactNo(contactNo);
	}

	public User fetchCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return uRepo.findByUsername(username);
	}
}

