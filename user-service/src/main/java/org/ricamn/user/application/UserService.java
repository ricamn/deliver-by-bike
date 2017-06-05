package org.ricamn.user.application;

import org.springframework.stereotype.Service;

import org.ricamn.user.domain.User;

@Service
public interface UserService {

	User getByUserName(String userName);
}
