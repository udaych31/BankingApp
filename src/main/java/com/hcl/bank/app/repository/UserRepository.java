package com.hcl.bank.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bank.app.entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

	Optional<UserInfo> findByUserNameAndPassword(String name,String password);
	Optional<UserInfo> findByUserNameAndRole(String userName,String role);
	
}
