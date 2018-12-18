package org.srh.config;
import org.srh.util.AppLog;
import org.srh.vipapp.activity.ProductActivity;


/**
 * Crash and Burn App
 * 
 * Date: 28 Nov 2018
 * @author Vivek
 */
public class AppMain {


	public static void main(String[] args) {
		try {
			AppLog.print("Exeucte you code here");
		}
		catch(Exception ex) {
			AppLog.log(AppMain.class, ex);
		}
		finally {
			System.exit(0);
		}
	}


}
