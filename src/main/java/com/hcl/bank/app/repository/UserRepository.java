package com.hcl.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bank.app.entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

}
