/*
 * Copyright © 1999-2014 ShaoShi, Inc. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.myvolley;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

/****************************************************
 * @ClassName:GetDataFromNet
 * @ClassDescription:ues this class's Object we can get data from interent
 * @version :1.0.0 @ author :dafuShao @ time :2014-9-29 15:22:46
 *****************************************************/
public class GetDataFromNet implements Listener<String>, ErrorListener {

	Context context;
	private MyResponListener listener;
	ResponVo responVo;
	Class<?> r_class;
	private GetData getdData;

	//
	// /***
	// *
	// * @param context
	// * 上下文环境
	// * @param MyResponListener
	// * 网络访问类所实现的监听器
	// * @param responVo
	// * 访问所需字段类
	// * @param r_class
	// * 接受返回数据类
	// */
	// public GetDataFromNet(Context context, MyResponListener listener,
	// ResponVo responVo, Class<?> r_class) {
	//
	// this.context = context;
	// // this.listener = listener;
	// this.responVo = responVo;
	// this.r_class = r_class;
	// getdData = GetData.getDataInsterence(context);
	//
	// }

	/***
	 * 
	 * @param context
	 *            上下文环境
	 * @param MyResponListener
	 *            网络访问类所实现的监听器
	 * @param r_class
	 *            接受返回数据类
	 */
	public GetDataFromNet(Context context, MyResponListener listener,
			Class<?> r_class) {

		this.context = context;
		this.listener = listener;
		this.r_class = r_class;
		getdData = GetData.getDataInsterence(context);
		Log.i("GetDataFromNet", "GetDataFromNet>>>>>>>>>>>>>>>>>>>>");
	}

	@Override
	public void onErrorResponse(VolleyError error) {

		getdData.updateEndTime();
		ResponVo responVo = makeNoneRespone(r_class);
		Log.i("GetDataFromNet", "onErrorResponse>>>>>>>>>>>>>>>>>>>>");
		listener.onErrorResponse(error, responVo);

	}

	@Override
	public void onResponse(String response) {

		Log.i("GetDataFromNet", "getdData.getRealTime>>>>>>>>>>>>>>>>>>>>"
				+ getdData.getRealTime());
		// 请求时间的处理
		getdData.updateEndTime();
		ResponVo responVo = null;

		if (!TextUtils.isEmpty(response)) {
			String tempRespone = response;
			Log.i("GetDataFromNet", "tempRespone>>>>>>>>>>>>>>>>>>>>"
					+ tempRespone);
			responVo = (ResponVo) Json_U
					.parseJsonToObject(tempRespone, r_class);

		} else {

			responVo = makeNoneRespone(r_class);
		}

		listener.onResponse(responVo);
		Log.i("GetDataFromNet",
				"listener.onResponse(responVo)>>>>>>>>>>>>>>>>>>>>");

	}

	/*
	 * 
	 * 对服务器访问失败和返回空消息的处理
	 */
	private ResponVo makeNoneRespone(Class<?> r_class2) {
		ResponVo responseVo = null;
		try {
			Log.i("GetDataFromNet", "lmakeNoneRespone>>>>>>>>>>>>>>>>>>>>");
			responseVo = (ResponVo) r_class2.newInstance();
			responseVo.setData("数据获取失败!");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return responseVo;
	}

	/***
	 * 调用访问
	 * 
	 * @param url
	 */
	public void startUrl(String url) {

		Log.i("GetDataFromNet", "startUrl>>>>>>>>>>>>>>>>>>>>" + url);
		getdData.obtaionDataformServer(this, this, url, null);

	}

}
