package org.srh.util;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.srh.vipapp.service.impl.CustomerServiceImpl;
import org.srh.vipapp.service.CustomerService;

public class CustomerServiceImplTest {

	@Test
	public void testGetCustomerById() {
		String customerId = "";
		CustomerService customerService = new CustomerServiceImpl().getCustomerById(customerId);
		if(customerService != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}

		
	@Test
	public void testGetCustomersByUsername() {
		
	String customerUsername ="";
		CustomerService customerService = new CustomerServiceImpl().getCustomersByUsername(String customerUsername);
		if(!customerService.isEmpty())
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}



	@Test
	public void testGetCustomersByName() {
		String name ="";
		CustomerService customerService = new CustomerServiceImpl().getCustomersByName(String name);
		if(!customerService.isEmpty())
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}
		

}
