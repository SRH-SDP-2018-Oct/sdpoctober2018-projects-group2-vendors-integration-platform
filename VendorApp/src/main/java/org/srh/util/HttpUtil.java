package org.srh.util;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.srh.constants.ErrorCode;
import org.srh.constants.KeyConstant;


/**
 * Utility class. Contains method to ease the HTTP communication process.
 * Date: 01 Dec 2018
 * @author Vivek
 */
public final class HttpUtil {

	public static final int HTTP_RESPONSE_ERROR_CODE = 422;
	public static final String KEY_DATA = KeyConstant.DATA.val();
	public static final String KEY_ERROR = KeyConstant.ERROR.val();
	public static final String KEY_ERROR_CODE = KeyConstant.ERROR_CODE.val();
	public static final String KEY_ERROR_MESSAGE = KeyConstant.ERROR_MESSAGE.val();
	public static final String KEY_ERROR_DESC = KeyConstant.ERROR_DESC.val();


	/**
	 * Returns the success response in form of JSONObject.
	 * @param obj {@link Object}
	 * @return jsonObject {@link JSONObject}
	 */
	public static JSONObject successResponse(Object obj) {
		JSONObject jsonObject;
		if(obj!=null)
			jsonObject = new JSONObject(Common.hidePojoData(obj));
		else
			jsonObject = new JSONObject();
		return new JSONObject().put(KEY_DATA, jsonObject);
	}


	/**
	 * Returns the success response in form of JSONObject.
	 * @param list {@link List<?>}
	 * @return jsonObject {@link JSONObject}
	 */
	public static JSONObject successResponseArray(List<?> list) {
		JSONArray jsonArray = new JSONArray();
		if(list!=null && !list.isEmpty()) {
			for(Object obj : list) {
				jsonArray.put(new JSONObject(Common.hidePojoData(obj)));
			}
		}
		return new JSONObject().put(KEY_DATA, jsonArray);
	}


	/**
	 * Returns the error response in form of JSONObject.
	 * The HTTP Status Code is {@link HttpUtil#HTTP_RESPONSE_ERROR_CODE} in this case.
	 * @param resp {@link HttpServletResponse}
	 * @param name
	 * @param desc
	 * @return
	 */
	public static JSONObject errorResponse(HttpServletResponse resp, ErrorCode error, String desc) {
		resp.setStatus(HTTP_RESPONSE_ERROR_CODE);
		// 
		JSONObject jsonError = new JSONObject();
		jsonError.put(KEY_ERROR_CODE, error.getCode());
		jsonError.put(KEY_ERROR_MESSAGE, error.getMessage());
		jsonError.put(KEY_ERROR_DESC, desc);
		// 
		return new JSONObject().put(KEY_ERROR, jsonError);
	}


}
