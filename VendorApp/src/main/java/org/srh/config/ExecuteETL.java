package org.srh.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.srh.util.AppLog;
import org.srh.util.NumberUtil;
import org.srh.vipapp.activity.ProductActivity;


/**
 * Crash and Burn App
 * 
 * Date: 28 Nov 2018
 * @author Vivek
 */
public class ExecuteETL {

	public static final int ATTEMPT_MIN = 1;
	public static final int ATTEMPT_MAX = 3;



	public static void main(String[] args) {
		try {
			// Fetch Vendor Name
			String vendor = takeInputFromUser(0);
			// Execute Process
			if(vendor!=null)
				new ProductActivity().registerProducts(vendor);
		}
		catch(Exception ex) {
			AppLog.log(AppMain.class, ex);
		}
		finally {
			System.exit(0);
		}
	}


	private static String takeInputFromUser(int count) throws IOException, InterruptedException {
		String vendor = null;

		// Notify User of the attempts exceeded
		if(count>=ATTEMPT_MAX) {
			AppLog.print("Number of attempts exceeded!");
			return vendor;
		}

		// Display Options
		printSelection();

		// Take Input from User
		Integer selection = fetchInput();

		// Valid Input
		if(selection!=null && selection.intValue()>0 && selection.intValue()<3) {
			// Print Selected Vendor
			vendor = getSelectedVendorName(selection);
			// Display Process Initiation Message
			printSelectionSuccess(vendor);
		}
		// Invalid Input, Repeat
		else {
			// Notify User if not the first attempt
			AppLog.print(">> Number of attempts remaining: "+(ATTEMPT_MAX-ATTEMPT_MIN-count));
			return takeInputFromUser(++count);
		}
		return vendor;
	}



	private static void printSelection() {
		// Display the options
		AppLog.print(">> Please select the vendor from the following selection:");
		AppLog.print("    1. Netti");
		AppLog.print("    2. Aldo");
	}



	private static Integer fetchInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		return NumberUtil.getInteger(str);
	}



	private static String getSelectedVendorName(int selection) {
		String vendor = null;
		if(selection==1)
			vendor = "Netti";
		else if(selection==2)
			vendor = "Aldo";
		return vendor;
	}



	private static void printSelectionSuccess(String vendor) throws InterruptedException {
		int waitTime = 2000;
		AppLog.print(">> You have selected: "+vendor);
		Thread.sleep(waitTime*2);
		AppLog.print(">> Buckle up your seat belts as we perform the Extraction, Transformation and Loading process.");
		Thread.sleep(waitTime*4);
		AppLog.print(">> Process Started...");
		Thread.sleep(waitTime);
	}



}
