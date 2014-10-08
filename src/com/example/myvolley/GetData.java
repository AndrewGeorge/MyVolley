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

import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;

/****************************************
 * @ClassNane :GetData 
 * @ClassDescription:the details of data from interent
 * @version :1.0.0
 * @author :dafuShao
 * @time :2014-9-29 16:00:22
 *****************************************/
public class GetData {
	
	/** 上次网络请求结束时间 */
	private long endTime = SystemClock.elapsedRealtime();
	/** 服务器返回时间 */
	private long startTime;

	/**** 上下文环境 ****/
	private Context context;
	/**** 网络请求队列 ****/
	private RequestQueue queue;

	/****************/
	public static class MgetData {
		/*** 网络请求对象 ***/
		private final static GetData GETDATA = new GetData();
	}

	public static GetData getDataInsterence(Context context) {

		Log.i("GetData", "getDataInsterence>>>>>>>>>>>>>>>>>>>>");
		MgetData.GETDATA.context = context;

		if (MgetData.GETDATA.queue == null) {

			MgetData.GETDATA.queue = Volley.newRequestQueue(context
					.getApplicationContext());

		}
		return MgetData.GETDATA;
	}

	/****
	 * String 字符类的请求， 也可以直接继承Volley的Request来实现自定义的其他的下载很方便。
	 * 
	 * @author dafushao
	 * 
	 */

	private static class stringRequ extends StringRequest {

		private Map<String, String> mParams;

		public stringRequ(int method, String url, Listener<String> listener,
				ErrorListener errorListener, Map<String, String> params) {
			this(method, url, listener, errorListener);
			Log.i("stringRequ", "stringRequ>>>>>>>>>>>>>>>>>>>>");
			mParams = params;
			
		}

		public stringRequ(String url, Listener<String> listener,
				ErrorListener errorListener) {
			super(url, listener, errorListener);
		}

		public stringRequ(int method, String url, Listener<String> listener,
				ErrorListener errorListener) {
			super(method, url, listener, errorListener);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected Map<String, String> getParams() throws AuthFailureError {
			// TODO Auto-generated method stub
			return mParams;
		}

		@Override
		public com.android.volley.Request.Priority getPriority() {
			// TODO Auto-generated method stub
			return Priority.IMMEDIATE;
		}

	}


	public  void obtaionDataformServer(Listener<String> linListener,
			ErrorListener errorListener, final String url,
			Map<String, String> postdata) {
	
		if (url == null || url.length() == 0) {
			errorListener.onErrorResponse(null);
			return;
		}
		stringRequ stringRequest = new stringRequ(Method.DEPRECATED_GET_OR_POST,
				url, linListener, errorListener, postdata);

		stringRequest.setTag(context);
		
		Log.i("stringRequ", "queue.add(stringRequest)>>>>>>>>>>>>>>>>>>>>");
		queue.add(stringRequest);
		

	}
	
	/**
	 * 
	 * 方法描述：取消当前所有网络请求
	 * 
	 * @author: dafuShao
	 * @time: 2014-2-21 上午10:30
	 */
	public void cancelAllRequest(Context context) {
		
		if (context != null) {
			queue.cancelAll(context); // .getApplicationContext()
		} else {
			queue.cancelAll(context);
		}
		
//		if (MInstance.DATATRANSFER.mImageCache != null) {
//			MInstance.DATATRANSFER.mImageCache.clearCache();
//		}
		
	}

	/***
	 * 获取当前网络请求等待请求数
	 * 
	 * @return 当前网络等待请求数
	 */
//	public int getWaitingQueueNumber() {
//		return 
//	}

	/***
	 * 获取上次请求和下次联网请求的时间
	 * 
	 * @return
	 */
	public long getRealTime() {
		final long elapsedTime = SystemClock.elapsedRealtime() - endTime;
		return elapsedTime + startTime;
	}

	/**
	 * 更新当前请求时间
	 */
	public void updateEndTime() {
		
		endTime = SystemClock.elapsedRealtime();
	}

	
	
	
	
}
