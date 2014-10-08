package com.example.myvolley.untils;

import com.example.myvolley.Json_U;
import com.example.myvolley.ResponVo;

import android.content.Context;
import android.util.Log;

public class URL_Uils {
	/**
	 * URL拼接工具
	 * 
	 * @param context
	 *            上下文环境
	 * @param responVo
	 *            请求参数
	 * @param orgin
	 *            接口名称
	 * @return 拼接好的URL
	 */
	public static String url_getString(Context context,
			final ResponVo responVo, final String orginUrl) {
		// 在此可以进行加密等处理操作
		// will do

		Log.i("GetDataFromNet", "url_getString>>>>>>>>>>>>>>>>>>>");
		String dataStr = Json_U.objToJsonStr(responVo);

		Log.i("GetDataFromNet", "url_getString>>>>>>>>>>>>>>>>>>>" + orginUrl
				+ "&requestString=" + dataStr);
		return orginUrl + "&requestString=" + dataStr;

	}

}
