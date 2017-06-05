package org.ricamn.account.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.ricamn.account.application.AccountService;
import org.ricamn.account.domain.Account;

@RestController
@RequestMapping(value = "/accounts", produces = "application/json")
public class AccountController {

	@Autowired
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Account>> getAccounts() throws NoAccountsAvaliableException {
		
		return Optional.ofNullable(accountService.getAll())
				.map((a) -> new ResponseEntity<List<Account>>(a, HttpStatus.OK))
				.orElseThrow(() -> new NoAccountsAvaliableException("No accounts available"));
	}
}
