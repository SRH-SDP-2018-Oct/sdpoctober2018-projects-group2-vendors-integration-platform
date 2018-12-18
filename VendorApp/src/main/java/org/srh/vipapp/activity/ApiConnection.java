package org.srh.vipapp.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.srh.config.AppMain;
import org.srh.util.AppLog;
import org.srh.util.StringUtil;

public class ApiConnection {

	StringBuffer buffer = new StringBuffer();

	/**
	 * 
	 * @param strURL
	 * @return
	 */
	public ApiConnection(String strURL) {

		// Establish Connection
		HttpURLConnection httpCon = getConnection(strURL);
		if(httpCon==null) {
			return;
		}

		try(OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream())) {
			buffer.append(getResponseLines(httpCon, strURL));
		}
		catch(Exception ex) {
			String msg = StringUtil.append("An error occurred while getting response URL: ", strURL);
			AppLog.log(ApiConnection.class, ex, msg);
		}
		finally {
			httpCon.disconnect();
		}
	}



	/**
	 * Establishes HTTP URL Connection with the given URL.
	 * @param strURL {@link String}
	 * @return httpURLConnection {@link HttpURLConnection}
	 */
	private HttpURLConnection getConnection(String strURL) {
		HttpURLConnection httpCon = null;
		try {
			URL url = new URL(strURL);
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setRequestMethod("POST");
			httpCon.addRequestProperty("Content-Type", "application/json;charset=UTF-8");
			httpCon.setDoOutput(true);
			httpCon.connect();
			AppLog.print(ApiConnection.class, "Connection established successfully with URL: "+strURL);
		}
		catch(Exception ex) {
			String msg = StringUtil.append("An error occurred while connecting URL: ", strURL);
			AppLog.log(ApiConnection.class, ex, msg);
		}
		return httpCon;
	}



	/**
	 * Reads the data after performing the HTTP URL Connection.
	 * @param httpCon {@link HttpURLConnection}
	 * @param strURL {@link String}
	 * @return responseData {@link String}
	 * @throws IOException
	 */
	private String getResponseLines(HttpURLConnection httpCon, String strURL) throws IOException {
		String line;
		int responseCode = httpCon.getResponseCode();

		AppLog.print(ApiConnection.class, "Response code is [" + responseCode + "] for URL: "+strURL);

		StringBuilder sb = new StringBuilder();
		
		// Success
		if (responseCode == 200) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()))) {
				while ((line = br.readLine()) != null)
					sb.append(line);
			}
			catch(Exception ex) {
				String msg = StringUtil.append("An error occurred while reading success response data of URL: ", strURL);
				AppLog.log(ApiConnection.class, ex, msg);
			}
		}
		
		// Error
		else {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getErrorStream()))) {
				while ((line = br.readLine()) != null)
					sb.append(line);
			}
			catch(Exception ex) {
				String msg = StringUtil.append("An error occurred while reading error response data of URL: ", strURL);
				AppLog.log(ApiConnection.class, ex, msg);
			}
		}

		return sb.toString();
	}



	@Override
	public String toString() {
		return buffer.toString();
	}


	public static void main(String[] args) {
		try {
			String strURL = "http://localhost:8080/aldoapp/products/all";
			ApiConnection apiConnection = new ApiConnection(strURL);
			AppLog.print(apiConnection);
		}
		catch(Exception ex) {
			AppLog.log(AppMain.class, ex);
		}
		finally {
			System.exit(0);
		}
	}


}
