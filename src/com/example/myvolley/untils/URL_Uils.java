package com.example.myvolley.untils;

import com.example.myvolley.Json_U;
import com.example.myvolley.ResponVo;

import android.content.Context;
import android.util.Log;

public class URL_Uils {
	/**
	 * URLƴ�ӹ���
	 * 
	 * @param context
	 *            �����Ļ���
	 * @param responVo
	 *            �������
	 * @param orgin
	 *            �ӿ�����
	 * @return ƴ�Ӻõ�URL
	 */
	public static String url_getString(Context context,
			final ResponVo responVo, final String orginUrl) {
		// �ڴ˿��Խ��м��ܵȴ������
		// will do

		Log.i("GetDataFromNet", "url_getString>>>>>>>>>>>>>>>>>>>");
		String dataStr = Json_U.objToJsonStr(responVo);

		Log.i("GetDataFromNet", "url_getString>>>>>>>>>>>>>>>>>>>" + orginUrl
				+ "&requestString=" + dataStr);
		return orginUrl + "&requestString=" + dataStr;

	}

}
