package com.example.myvolley;

import android.util.Log;

import com.alibaba.fastjson.JSON;

public class Json_U {

	/**
	 * 
	 * @param respon
	 *            需要转换的字符串
	 * @param r_class
	 *            转换成的objiect
	 * @return 返回转换成的object
	 */
	public static <T> T parseJsonToObject(String respon, Class<T> r_class) {

		try {
			Log.i("Json_U", "parseJsonToObject>>>>>>>>>>>>>>>>>>" + respon);
			return JSON.parseObject(respon, r_class);

		} catch (Exception e) {
			// TODO: handle exception
			String arrayData = "\"data\":[]";
			String objectData = "\"data\":{}";
			e.printStackTrace();
			if (respon.contains(arrayData)) {
				String tempJsonStr = respon.replace(arrayData, objectData);
				try {
					return JSON.parseObject(tempJsonStr, r_class);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		return null;
		

	}

	/**
	 * 将object转换为Str
	 * 
	 * @param obj
	 * @return json字符串
	 */
	public static String objToJsonStr(Object obj) {

		Log.i("Json_U", "objToJsonStr>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		String temp = null;
		try {
			temp = JSON.toJSONString(obj);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Log.i("Json_U", "objToJsonStr>>>>>>>>>>>" + temp);

		return temp;
	}

}
