package com.transaction.Users.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transaction.Users.entity.User;



@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findByContactNo(String contactNo);
    
    
    
    User findByName(String name);



	User findById(Long id);



	void deleteById(Long id);



	User findByUsername(String username);



	User findByEmail(String username);




}

