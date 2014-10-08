package com.example.myvolley;

import com.android.volley.VolleyError;

public interface MyResponListener {
	
	//更具具体的需要可以自己修改服务器返回的数据
	public void onResponse(ResponVo responVo);
	
	public void onErrorResponse(VolleyError error,ResponVo responVo);
	

}
