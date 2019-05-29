package com.hcl.bank.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.bank.app.entity.AccountSummary;

@Repository
public interface AccountSummaryRepository extends JpaRepository<AccountSummary, Long> {
	
	public AccountSummary findByAccountNumber(Long accountNumber);
	
	@Query(value="select a.accountNumber from AccountSummary a where a.accountNumber <> :accountNumber")
	public List<Long> findAllAccountNumbers(@Param("accountNumber") Long accountNumber);

}
