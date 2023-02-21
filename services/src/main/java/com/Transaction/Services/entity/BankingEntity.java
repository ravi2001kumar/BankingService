package com.Transaction.Services.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class BankingEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	private String accountnumber;
	private String IFSCCode;
	private String branch;
	private Long balance;
	
	
	
	public BankingEntity(String username, String password, String accountnumber, String iFSCCode, String branch,
			Long balance, int id) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.accountnumber = accountnumber;
		this.IFSCCode = iFSCCode;
		this.branch = branch;
		this.balance = balance;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public BankingEntity() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getaccountnumber() {
		return accountnumber;
	}
	public void setaccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getIFSCCode() {
		return IFSCCode;
	}
	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}


	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
