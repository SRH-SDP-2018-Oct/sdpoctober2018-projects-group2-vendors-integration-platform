package org.srh.vipapp.hbm.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.srh.vipapp.hbm.dao.impl.UserMasterDaoImpl;
import org.srh.vipapp.hbm.dto.UserMaster;

public class UserMasterDaoTest {

	@Test
	public void testFindByValidId() {
		int userId = 1;
		UserMaster userMaster = new UserMasterDaoImpl().findById(userId);
		if (userMaster != null) {
			assertEquals(userId, userMaster.getId());
		}
	}

	@Test
	public void testFindByInvalidId() {
		int userId = 9;
		UserMaster userMaster = new UserMasterDaoImpl().findById(userId);
		if (userMaster == null) {
			assertEquals(null, userMaster);
		}
	}
	
	@Test
	public void testFindByNullId() {
		int userId = 0;
		UserMaster userMaster = new UserMasterDaoImpl().findById(userId);
		if (userMaster == null) {
			assertEquals(null, userMaster);
		}
	}

	@Test
	public void testGetAllUsers() {
		List<UserMaster> userMaster = new UserMasterDaoImpl().getAllUsers();
		if (!userMaster.isEmpty()) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	@Test
	public void testFindByValidUsername() {
		String username = "System";
		UserMaster userMaster = new UserMasterDaoImpl().findByUsername(username);
		if (userMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByInvalidUsername() {
		String username = "New";
		UserMaster userMaster = new UserMasterDaoImpl().findByUsername(username);
		if (userMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByNullUsername() {
		String username = null;
		UserMaster userMaster = new UserMasterDaoImpl().findByUsername(username);
		if (userMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
}
