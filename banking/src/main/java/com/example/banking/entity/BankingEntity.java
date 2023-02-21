package com.example.banking.entity;

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
	private String Userid;
	private String accountnumber;
	private String IFSCCode;
	private String branch;
	private Long balance;
	
	
	
	public BankingEntity(String userid, String accountnumber, String iFSCCode, String branch,
			Long balance, int id) {
		super();
		this.id = id;
		this.Userid=userid;
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
	
	public String getUserid() {
		return Userid;
	}


	public void setUserid(String userid) {
		Userid = userid;
	}


	public String getAccountnumber() {
		return accountnumber;
	}


	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
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
