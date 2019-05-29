package com.hcl.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bank.app.entity.AccountSummary;

@Repository
public interface AccountSummaryRepository extends JpaRepository<AccountSummary, Long> {

}
