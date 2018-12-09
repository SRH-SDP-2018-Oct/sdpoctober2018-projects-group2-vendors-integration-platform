package org.srh.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.srh.nettiapp.hbm.dao.impl.BranchTimingsDaoImpl;
import org.srh.nettiapp.hbm.dto.BranchTimings;

public class BranchTimingsDaoImplTest {

	@Test
	public void testFindByBranchId() {
		int branchId = 1;
		BranchTimings branchTimings = new BranchTimingsDaoImpl().findByBranchId(branchId);
		if(branchTimings != null)
		{
			assertEquals(branchId,branchTimings.getBranchId());
		}
	}
	@Test
	public void testFindByInvalidId() {
		int branchId = 1;
		BranchTimings branchTimings = new BranchTimingsDaoImpl().findByBranchId(branchId);
		if(branchTimings == null)
		{
			assertEquals(null,branchTimings);
		}
	}
	@Test
	public void testFindTimingForTheDay() {
		int dayInWeek = 1;
		BranchTimings branchTimings = new BranchTimingsDaoImpl().findByBranchId(dayInWeek);
		if(branchTimings != null)
		{
			assertEquals(dayInWeek,branchTimings.getDayInWeek());
		}
	}
	
	public void testFindByInvalidDay() {
		int dayInWeek = 1;
		BranchTimings branchTimings = new BranchTimingsDaoImpl().findByBranchId(dayInWeek);
		if(branchTimings == null)
		{
			assertEquals(null,branchTimings);
		}
	}
}
