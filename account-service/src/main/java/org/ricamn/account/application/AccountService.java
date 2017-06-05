package org.ricamn.account.application;

import java.util.List;

import org.ricamn.account.domain.Account;

public interface AccountService {

	public void save(Account account);

	public Account getAccountByUserId(Long userId);

	public List<Account> getAll();
}
