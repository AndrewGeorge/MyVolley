package com.example.myvolley;

import com.android.volley.VolleyError;

public interface MyResponListener {
	
	//���߾������Ҫ�����Լ��޸ķ��������ص�����
	public void onResponse(ResponVo responVo);
	
	public void onErrorResponse(VolleyError error,ResponVo responVo);
	

}
