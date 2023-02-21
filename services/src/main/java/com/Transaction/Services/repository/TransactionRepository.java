package com.Transaction.Services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Transaction.Services.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String>{

	Transaction findById(int id);
	
	void deleteById(int id);
	
	
	
	
	
}
