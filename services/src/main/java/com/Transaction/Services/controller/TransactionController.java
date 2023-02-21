package com.Transaction.Services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Transaction.Services.entity.Transaction;
import com.Transaction.Services.repository.TransactionRepository;
import com.Transaction.Services.service.TransactionService;



@RestController
@CrossOrigin
public class TransactionController {

	
	@Autowired
	public TransactionService tranServ;
	
	@GetMapping("AllTransaction")
	public List<Transaction> getAllTransactions(){
		return tranServ.findAllTransaction();
	}
	
	@GetMapping("/Transaction/{id}") //get Customer Details by Customer Id
	public Transaction fetchCustomerById(@PathVariable("id") int id)
	{
		return tranServ.fetchByTransactionId(id);
				
	}
	
	@PutMapping("/Transaction/{id}") // Update Customer Details by Customer Id
	public Transaction updateCustomer(@PathVariable("id") int id,@RequestBody Transaction tran)
	{
		return tranServ.updateTransaction(id, tran);
	}
	
	
	@DeleteMapping("/Transaction/{id}") //delete transaction Details By Id
	public String deleteAppointmentById(@PathVariable("id") int id)
	{
		 tranServ.deleteById(id);
		 return "Customer details Deleted Successfully";
	}
	@PostMapping("/Transaction")
	public String addTransaction(@RequestBody Transaction transaction) {
		return tranServ.addTransaction(transaction);
	}
}
