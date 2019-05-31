package com.hcl.bank.app.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hcl.bank.app.service.BankingService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BankingController.class,secure = false)
public class BankingControllerTest {
	
	@MockBean
	private BankingService bankService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getAccountNumbersTest() throws Exception {
		
		List<Long> list=new ArrayList<>();
		list.add(2L);
		list.add(3L);
		list.add(4L);
		
		Mockito.when(bankService.fetchAllAccountNumbers(1L)).thenReturn(list);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bank/findallaccounts?accountNumber=1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String expected="[2,3,4]";
		assertEquals(expected, response.getContentAsString());
		
		
	}
	

}
