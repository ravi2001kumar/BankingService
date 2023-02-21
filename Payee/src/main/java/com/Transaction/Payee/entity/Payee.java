package com.Transaction.Payee.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
//@Table(name="Tpt/Payee")
public class Payee {

	private String accountTo;
	private String accountFrom;
	private String bankName;
	private String date;
	private Long amount;
	private String IfscCode;
	private String accHolderName;
	
	
	public String getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(String accountTo) {
		this.accountTo = accountTo;
	}
	public String getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
	
	
	public String getIfscCode() {
		return IfscCode;
	}
	public void setIfscCode(String ifscCode) {
		IfscCode = ifscCode;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public Payee(String accountTo, String accountFrom, String bankName, String date, Long amount,String accHolderName, String IfscCode) {
		super();
		this.accountTo = accountTo;
		this.accountFrom = accountFrom;
		this.bankName = bankName;
		this.date = date;
		this.amount = amount;
		this.accHolderName=accHolderName;
		this.IfscCode=IfscCode;
	}
	public Payee() {
		super();
	}
	
	
}
