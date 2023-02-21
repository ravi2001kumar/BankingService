package com.Transaction.Services.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Transaction.Services.entity.BankingEntity;
import com.Transaction.Services.entity.Transaction;
import com.Transaction.Services.repository.TransactionRepository;

@Service
public class TransactionService {

	
	private RestTemplate restTemplate=new RestTemplate();
	
	@Autowired
	public TransactionRepository tranRepo;
	
	public List<Transaction> findAllTransaction(){
		List<Transaction> tran = new ArrayList();
		tranRepo.findAll().forEach(tran::add);
		return tran;
	}

	public void deleteById(int id) {
		tranRepo.deleteById(id);
	}
	
	public Transaction fetchByTransactionId(int id) {
		return tranRepo.findById(id);
	}
	
	public Transaction updateTransaction(int id, Transaction tran) {
		Transaction tranDb = tranRepo.findById(id);
		if(Objects.nonNull(tran.getAccountFrom()) && !"".equalsIgnoreCase(tran.getAccountFrom())) {
			tranDb.setAccountFrom(tran.getAccountFrom());
		}
		if(Objects.nonNull(tran.getAccountTo()) && !"".equalsIgnoreCase(tran.getAccountTo())) {
			tranDb.setAccountTo(tran.getAccountTo());
		}
//		if(Objects.nonNull(tran.getAmount()) && !"".equalsIgnoreCase(tran.getAmount())) {
//			tranDb.setAmount(tran.getAmount());
//		}
		if(Objects.nonNull(tran.getDate()) && !"".equalsIgnoreCase(tran.getDate())) {
			tranDb.setDate(tran.getDate());
		}
		
		return tranRepo.save(tranDb);
	}

	public String addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		BankingEntity user2= restTemplate.getForObject("http://localhost:9901/customer/accountnumber/"+transaction.getAccountTo(),BankingEntity.class);
		BankingEntity user=restTemplate.getForObject("http://localhost:9901/customer/accountnumber/"+transaction.getAccountFrom(),BankingEntity.class);
//		Long remaining=user2.getBalance()+transaction.getAmount();
		if(user.getBalance()>=transaction.getAmount()) {
			BankingEntity user3=new BankingEntity(user2.getUsername(),user2.getPassword(),user2.getaccountnumber(),user2.getIFSCCode(),user2.getBranch(),user2.getBalance()+transaction.getAmount(),user2.getId());
			restTemplate.put("http://localhost:9901/customer/"+user2.getId(), user3);
			System.out.println(user3);
//			user2.setBalance(user2.getBalance()+transaction.getAmount());
			BankingEntity user4=new BankingEntity(user.getUsername(),user.getPassword(),user.getaccountnumber(),user.getIFSCCode(),user.getBranch(),user.getBalance()-transaction.getAmount(),user.getId());
			restTemplate.put("http://localhost:9901/customer/"+user.getId(), user4);
//			user.setBalance(user.getBalance()-transaction.getAmount());
			return "Transaction Successfull";
		}
		else {
			return "Transaction Failed";
		}
		
	}
}
