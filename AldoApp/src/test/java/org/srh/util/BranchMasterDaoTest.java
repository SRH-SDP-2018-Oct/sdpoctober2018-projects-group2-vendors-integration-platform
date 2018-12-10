package org.srh.util;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.srh.aldoapp.hbm.dao.impl.BranchMasterDaoImpl;
import org.srh.aldoapp.hbm.dto.BranchMaster;

public class BranchMasterDaoTest {

	@Test
	public void testgetBranchesInCity(String city) {

		List<BranchMaster> branchMaster = new BranchMasterDaoImpl().getBranchesInCity(city);
		if (branchMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}
}
