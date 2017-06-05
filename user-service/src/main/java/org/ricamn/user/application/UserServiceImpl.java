package org.ricamn.user.application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.ricamn.user.domain.User;
import org.ricamn.user.domain.UserJpaRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserJpaRepository repository;

	@Autowired
	public UserServiceImpl(UserJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public User getByUserName(String userName) {
		return Optional.ofNullable(repository.findByUserName(userName)).map((l) -> l.isEmpty() ? null : l.get(0))
				.orElseThrow(() -> new UserNotFoundException("User not found."));
	}

}
