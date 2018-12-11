/**
 * 
 */
package org.srh.vipapp.hbm.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.srh.vipapp.hbm.dao.impl.ApiStructureConstantsDaoImpl;
import org.srh.vipapp.hbm.dto.ApiStructureConstants;

/**
 * @author Maitreyee
 *
 */

public class ApiStructureConstantsDaoTest {

	/**
	 * Test method for {@link org.srh.vipapp.hbm.dao.ApiStructureConstantsDao#getAllApiStructConstants()}.
	 */
	@Test
	public void testGetAllApiStructConstants() {
		List<ApiStructureConstants> apiStructureConstants = new ApiStructureConstantsDaoImpl().getAllApiStructConstants();
		if(!apiStructureConstants.isEmpty())
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}

	}

}
