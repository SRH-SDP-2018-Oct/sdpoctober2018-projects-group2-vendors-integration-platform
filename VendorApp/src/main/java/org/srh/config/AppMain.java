package org.srh.config;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.util.AppLog;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.impl.ApiStructureDaoImpl;
import org.srh.vipapp.hbm.dto.ApiStructure;
import org.srh.vipapp.hbm.dto.UserMaster;
import org.srh.vipapp.hbm.hql.ApiStructureQuery;

import com.google.common.hash.Hashing;


/**
 * Crash and Burn App
 * 
 * Date: 28 Nov 2018
 * @author Vivek
 */
public class AppMain {



	public static void main(String[] args) {
		// testCustomerFunctinalities();
		try {

			try ( Session session = RootHB.getSessionFactory().openSession(); ) {
				session.find(UserMaster.class, 1);
			}
			
			/*List list = new ApiStructureDaoImpl().getVendorsApiStructure(1);
			AppLog.print(list);
			*/
		}
		catch(Exception ex) {
			AppLog.log(AppMain.class, ex);
		}
		finally {
			System.exit(0);
		}
	}


}
