package org.ricamn.account.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Account account;
	
	public Customer(){
		
	}

	public Customer(String firstName, String lastName, String email, Account account) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.account = account;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public Account getAccount() {
		return account;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
