package org.srh.vipapp.hbm.dao;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;
import org.srh.vipapp.hbm.dao.impl.UserMasterDaoImpl;

public class UserMasterDaoTest {

	@Test
	public void testFindById() {
		JSONObject jsonObject = null;
		Object obj = new UserMasterDaoImpl().findById(1);
		jsonObject = new JSONObject(obj);
		String userName = jsonObject.getString("userId");
		if(userName.equalsIgnoreCase("1"))
		{
			assertTrue(true);
		}
	}

	@Test
	public void testGetAllUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByUsername() {
		JSONObject jsonObject = null;
		Object obj = new UserMasterDaoImpl().findByUsername("John");
		jsonObject = new JSONObject(obj);
		String userName = jsonObject.getString("username");
		if(userName.equalsIgnoreCase("John"))
		{
			assertTrue(true);
		}
	}

}
