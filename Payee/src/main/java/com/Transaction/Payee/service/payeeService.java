package com.Transaction.Payee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Transaction.Payee.entity.BankingEntity;
import com.Transaction.Payee.entity.Payee;
import com.Transaction.Payee.repository.payeeRepository;



@Service
public class payeeService {
	
	private RestTemplate restTemplate = new RestTemplate();
	

	public payeeRepository paRepo;
	
	public List<Payee> FindallPayee(){
		List<Payee> py = new ArrayList();
		paRepo.findAll().forEach(py::add);
		return py;
	}
	
	public void deleteById(int id) {
		paRepo.deleteById(id);
	}
	
	public Payee fetchDetailsById(int id) {
		return paRepo.findById(id);
	}
	
	public Payee FetchdetailsByHolderName(String accHolderName) {
		return paRepo.findByHolderName(accHolderName);
	}

	public Payee updatePayee(int id, Payee py) {
		Payee pyDb = paRepo.findById(id);
		if(Objects.nonNull(py.getAccountFrom()) && !"".equalsIgnoreCase(py.getAccountFrom())) {
			pyDb.setAccountFrom(py.getAccountFrom());
		}
		if(Objects.nonNull(py.getAccountTo()) && !"".equalsIgnoreCase(py.getAccountTo())) {
			pyDb.setAccountTo(py.getAccountTo());
		}
		if(Objects.nonNull(py.getDate()) && !"".equalsIgnoreCase(py.getDate())) {
			pyDb.setDate(py.getDate());
		}
		if(Objects.nonNull(py.getBankName()) && !"".equalsIgnoreCase(py.getBankName())) {
			pyDb.setBankName(py.getBankName());
		}
		
		return paRepo.save(pyDb);
	}

	public String addPayee(Payee py) {
		BankingEntity user2= restTemplate.getForObject("http://localhost:9901/customer/accountnumber/"+py.getAccountTo(),BankingEntity.class);
		BankingEntity user=restTemplate.getForObject("http://localhost:9901/customer/accountnumber/"+py.getAccountFrom(),BankingEntity.class);
//		Long remaining=user2.getBalance()+transaction.getAmount();
		if(user.getBalance()>=py.getAmount()) {
			BankingEntity user3=new BankingEntity(user2.getUsername(),user2.getPassword(),user2.getaccountnumber(),user2.getIFSCCode(),user2.getBranch(),user2.getBalance()+py.getAmount(),user2.getId());
			restTemplate.put("http://localhost:9901/customer/"+user2.getId(), user3);
			System.out.println(user3);
//			user2.setBalance(user2.getBalance()+transaction.getAmount());
			BankingEntity user4=new BankingEntity(user.getUsername(),user.getPassword(),user.getaccountnumber(),user.getIFSCCode(),user.getBranch(),user.getBalance()-py.getAmount(),user.getId());
			restTemplate.put("http://localhost:9901/customer/"+user.getId(), user4);
//			user.setBalance(user.getBalance()-transaction.getAmount());
			return "Payee Transaction Successfull";
		}
		else {
			return "Payee Transaction Failed";
		}
	}
}
