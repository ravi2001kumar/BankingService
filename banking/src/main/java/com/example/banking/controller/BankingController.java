package com.example.banking.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.entity.BankingEntity;
import com.example.banking.repository.BankingRepo;
import com.example.banking.service.BankingService;


@RestController
@CrossOrigin
public class BankingController {

//	@Autowired
	public BankingService bankServ;
	@Autowired
	public BankingRepo bankRepo;
	
	@GetMapping("/customers/")
	public List<BankingEntity> getAllCutomers(){
		return bankServ.getAllCustomers();
	}
	@GetMapping("/customer/{id}") //get Customer Details by Customer Id
	public BankingEntity fetchCustomerById(@PathVariable("id") int id)
	{
		return bankServ.fetchCustomerById(id);
				
	}
	@GetMapping("/customer/{accountnumber}/{IFSCCode}/{Branch}/{Balance}") //Create Customers
	public BankingEntity saveAppointment(@PathVariable("accountnumber") String accountnumber,@PathVariable("IFSCCode") String IFSCCode,@PathVariable("Branch") String branch,@PathVariable("Balance") Long balance) throws Exception
	{
		BankingEntity bank = new BankingEntity();
		bank.setaccountnumber(accountnumber);
		bank.setIFSCCode(IFSCCode);
		bank.setBranch(branch);
		bank.setBalance(balance);
		return bankServ.saveCustomer(bank);
	}
	@DeleteMapping("/customer/{id}") //delete Customer Details By Customer Id
	public String deleteAppointmentById(@PathVariable("id") int id)
	{
		 bankServ.deleteCustomerById(id);
		 return "Customer details Deleted Successfully";
	}
	@PostMapping("/Addcustomer") //Create Customer
	public BankingEntity addCustomer(@RequestBody BankingEntity bank) throws Exception
	{
		return bankServ.addCustomer(bank);
	}
	@PutMapping("/customer/{id}") // Update Customer Details by Customer Id
	public BankingEntity updateCustomer(@PathVariable("id") String id,@RequestBody BankingEntity bank)
	{
		return bankServ.updateCustomer(Integer.parseInt(id), bank);
	}
	@GetMapping("/customer/accountnumber/{accountnumber}") // get Customer Details by Account Number
	public BankingEntity fetchByaccountnumber(@PathVariable("accountnumber") String accountnumber)
	{
		return bankServ.fetchByaccountnumber(accountnumber);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
    return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
  }
}
