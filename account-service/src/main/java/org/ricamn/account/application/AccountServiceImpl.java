package org.ricamn.account.application;

import java.util.List;

import org.ricamn.account.domain.Account;
import org.ricamn.account.domain.AccountJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	private final AccountJpaRepository repository;

	// private final RestTemplate restTemplate;

	@Autowired
	// public AccountServiceImpl(AccountJpaRepository repository, RestTemplate
	// restTemplate) {
	public AccountServiceImpl(AccountJpaRepository repository) {
		this.repository = repository;
		// this.restTemplate = restTemplate;
	}

	@Override
	public void save(Account account) {
		repository.save(account);
	}

	@Override
	public Account getAccountByUserId(Long userId) {

		// restTemplate.getForObject("http://localhost:8081/users/me",
		// User.class);

		return repository.findByUserId(userId).orElseThrow(() -> new AccountNotFound());
	}

	@Override
	public List<Account> getAll() {
		return repository.findAll();
	}
}
