package org.ricamn.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.lang.String;
import org.ricamn.user.domain.User;
import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
	List<User> findByUserName(String userName);
}
