package com.example.banking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banking.entity.BankingEntity;
import com.example.banking.repository.BankingRepo;


@Service
public class BankingService {
	
	@Autowired
	public BankingRepo bankRepo;
	public List<BankingEntity> getAllCustomers() {
		List<BankingEntity> bank = new ArrayList<>();
		bankRepo.findAll().forEach(bank::add);
		return bank;
	}

	public BankingEntity fetchCustomerById(int id) {
		return bankRepo.findById(id);
	}

	public BankingEntity saveCustomer(BankingEntity bank) throws Exception {
		String accountnumber = bank.getaccountnumber();
		String existingAccountNumber = bank.getaccountnumber();
		
		if(existingAccountNumber == null) {
			return bankRepo.save(bank);
		}
		else {
			throw new Exception(" account number already exists!!");
		}
		
	}

	public void deleteCustomerById(int id) {
		bankRepo.deleteById(id);
	}

	public BankingEntity updateCustomer(int id, BankingEntity bank) {
		BankingEntity bnkDB = bankRepo.findById(id);
		if (Objects.nonNull(bank.getaccountnumber()) && !"".equalsIgnoreCase(bank.getaccountnumber())) {
			bnkDB.setaccountnumber(bank.getaccountnumber());
		}
		if (Objects.nonNull(bank.getBranch()) && !"".equalsIgnoreCase(bank.getBranch())) {
			bnkDB.setBranch(bank.getBranch());
		}
		if (Objects.nonNull(bank.getBalance())) {
			bnkDB.setBalance(bank.getBalance());
		}
		if (Objects.nonNull(bank.getIFSCCode()) && !"".equalsIgnoreCase(bank.getIFSCCode())) {
			bnkDB.setIFSCCode(bank.getIFSCCode());
		}
		
		return bankRepo.save(bnkDB);
	}

	public BankingEntity addCustomer(BankingEntity bank) {
		// TODO Auto-generated method stub
		return bankRepo.save(bank);
	}

	public BankingEntity fetchByaccountnumber(String accountnumber) {
		// TODO Auto-generated method stub
		return bankRepo.findByaccountnumber(accountnumber);
	}
	
}
