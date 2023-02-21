package com.Transaction.Payee.controller;

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

import com.Transaction.Payee.entity.Payee;
import com.Transaction.Payee.repository.payeeRepository;
import com.Transaction.Payee.service.payeeService;



@RestController
@CrossOrigin
public class PayeeController {

	
	public payeeService pyServ;

	public payeeRepository pyRepo;
	
	@GetMapping("AllPayee")
	public List<Payee> getAllPayees(){
		return pyServ.FindallPayee();
	}
	
	@GetMapping("/Payee/{id}") //get Customer Details by Customer Id
	public Payee fetchCustomerById(@PathVariable("id") int id)
	{
		return pyServ.fetchDetailsById(id);
				
	}
	@GetMapping("/Payee/{accHolderName}")//get Customer DEtails by HolderName
	public Payee fetchByHolderName(@PathVariable("accHolderName") String accHolderName)
	{
		return pyServ.FetchdetailsByHolderName(accHolderName);
	}
	
	@PutMapping("/Payee/{id}") // Update Customer Details by Customer Id
	public Payee updateCustomer(@PathVariable("id") int id,@RequestBody Payee tran)
	{
		return pyServ.updatePayee(id, tran);
	}
	
	
	@DeleteMapping("/Payee/{id}") //delete Payee Details By Id
	public String deleteAppointmentById(@PathVariable("id") int id)
	{
		 pyServ.deleteById(id);
		 return "Customer details Deleted Successfully";
	}
	
	@PostMapping("/PayeeTransfer")
	public String addPayee(@RequestBody Payee py) {
		return pyServ.addPayee(py);
	}
	
}
