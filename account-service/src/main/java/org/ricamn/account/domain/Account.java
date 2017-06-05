package org.ricamn.account.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {

	private Long id;
	private Long userId;
	private String accountNumber;
	private Set<Address> addresses;
	
	public Account(){
		
	}

	public Account(Long userId, String accountNumber) {
		this.userId = userId;
		this.accountNumber = accountNumber;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<Address> getAddresses() {
		return addresses;
	}

}
