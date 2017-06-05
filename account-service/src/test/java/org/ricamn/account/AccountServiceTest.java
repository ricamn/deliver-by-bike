package org.ricamn.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.ricamn.account.application.AccountService;
import org.ricamn.account.domain.Account;
import org.ricamn.account.domain.Address;
import org.ricamn.account.domain.AddressType;
import org.ricamn.account.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AccountServiceApplication.class)
@ActiveProfiles(profiles = "test")
public class AccountServiceTest {

	@Autowired
	private AccountService service;

	@Test
	public void shouldSaveAccount() {
		Account account = new Account(1l, "1-test");
		Customer customer = new Customer("John", "Hardy", "john.hardy@domain.com", account);
		Address address = new Address("367 Boullevard", "TX", "Austin", 888888, AddressType.BILLING);
		Set<Address> addresses = new HashSet<>();
		addresses.add(address);
		account.setAddresses(addresses);
		service.save(account);

		account = service.getAccountByUserId(1l);

		assertNotNull(account);
		assertEquals("1-test", account.getAccountNumber());
		assertNotNull(account.getAddresses());
		assertFalse(addresses.isEmpty());
		assertEquals("TX", addresses.stream().findFirst().get().getState());
	}
}
