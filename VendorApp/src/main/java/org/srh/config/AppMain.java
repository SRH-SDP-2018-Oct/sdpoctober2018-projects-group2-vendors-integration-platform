package org.srh.config;

import java.nio.charset.StandardCharsets;

import org.srh.util.AppLog;

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
		String sha256 = Hashing.sha256().hashString("Hello@135", StandardCharsets.UTF_8).toString();
		AppLog.print(sha256);
		System.exit(0);
	}


}
