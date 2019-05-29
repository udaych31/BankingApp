package com.hcl.bank.app.dto;

import java.util.List;

public class TransactionHistoryResponse {
	private List<TransactionHistoryDto> list;

	public List<TransactionHistoryDto> getList() {
		return list;
	}

	public void setList(List<TransactionHistoryDto> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return ""+list.size();
	}
	

}
