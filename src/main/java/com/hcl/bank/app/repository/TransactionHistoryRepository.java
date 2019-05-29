package com.hcl.bank.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.bank.app.entity.TransactionHistory;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {

	@Query(value="select * from Transaction_History order by create_dt desc limit 10", nativeQuery=true)
	List<TransactionHistory> findAll();
	//List<TransactionHistory> findTop1ByCreateDtOrderByCreateDtAsc();
	List<TransactionHistory> findTop10ByOrderByCreateDtDesc();
	@Query("SELECT s FROM TransactionHistory s ORDER BY s.createDt DESC")
	List<TransactionHistory> findall(Pageable pageable);
	
}
