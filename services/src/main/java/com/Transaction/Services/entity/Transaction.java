package com.Transaction.Services.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String accountTo;
	private String accountFrom;
	private Long amount;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Transaction(int id, String accountTo, String accountFrom,Long amount, String date) {
		super();
		this.id = id;
		this.accountTo = accountTo;
		this.accountFrom = accountFrom;
		this.amount = amount;
		this.date = date;
	}
	public Transaction() {
		super();
	}
	
	
	
}
