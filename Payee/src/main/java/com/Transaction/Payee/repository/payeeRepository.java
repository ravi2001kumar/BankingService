package com.Transaction.Payee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Transaction.Payee.entity.Payee;

@Repository
public interface payeeRepository extends JpaRepository<Payee, String>{

	Payee findById(int id);
	
	void deleteById(int id);
	
	Payee findByHolderName(String accHolderName);
	
}
