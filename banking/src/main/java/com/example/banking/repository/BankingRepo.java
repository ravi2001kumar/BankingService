package com.example.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.banking.entity.BankingEntity;

@SuppressWarnings("unused")
@Repository
public interface BankingRepo extends JpaRepository<BankingEntity, String>{

	BankingEntity findById(int id);

	void deleteById(int id);

//	public BankingEntity findByusername(String username);

	BankingEntity findByaccountnumber(String accountnumber);

	
}
