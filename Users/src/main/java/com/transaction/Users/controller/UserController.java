package com.transaction.Users.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.Users.entity.User;
import com.transaction.Users.service.UserService;


@RestController
@CrossOrigin
public class UserController {

	@Autowired
	public UserService uServ;
	
	
	@GetMapping("/customers/")
	public List<User> getAllCutomers(){
		return uServ.getAllCustomers();
	}
	@GetMapping("/customer/{id}") //get Customer Details by Customer Id
	public User fetchCustomerById(@PathVariable("id") String id)
	{
		return uServ.fetchCustomerById(Long.parseLong(id));
				
	}
	@GetMapping("/customer/{username}") //get Customer Details by Customer Id
	public User fetchCustomerByUsername(@PathVariable("id") String username)
	{
		return uServ.fetchCustomerByUsername(username);
				
	}
	@GetMapping("/customer/{username}/{password}/{email}/{contactNo}/{age}/{pin}/{dob}") //Create Customers
	public User saveUser(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("email") String email,@PathVariable("contactNo") String contactNo,@PathVariable("pin") String pin,@PathVariable("age") int age,@PathVariable("dob") String dob) throws Exception
	{
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setContactNo(contactNo);
		user.setPin(pin);
		user.setAge(age);
		user.setDob(dob);
		return uServ.addCustomer(user);
	}
	@DeleteMapping("/customer/{id}") //delete Customer Details By Customer Id
	public String deleteAppointmentById(@PathVariable("id") String id)
	{
		 uServ.deleteCustomerById(Long.parseLong(id));
		 return "Customer details Deleted Successfully";
	}
	@PostMapping("/Addcustomer") //Create Customer
	public User addCustomer(@RequestBody User bank) throws Exception
	{
		return uServ.addCustomer(bank);
	}
	@PutMapping("/customer/{id}") // Update Customer Details by Customer Id
	public User updateCustomer(@PathVariable("id") String id,@RequestBody User bank)
	{
		return uServ.updateCustomer(Long.parseLong(id), bank);
	}
	@GetMapping("/customer/contactnumber/{contactnumber}") // get Customer Details by Contact Number
	public User fetchByaccountnumber(@PathVariable("contactnumber") String contactnumber)
	{
		return uServ.fetchByContactNumber(contactnumber);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
    return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
  }
    
}

