package com.example.myvolley;
/****************************************************
 * @ClassName:ResponVoData
 * @ClassDescription:ues this way to set parameter
 * @version :1.0.0 
 * @ author :dafuShao 
 * @ time :2014-9-30 10:57:14
 *****************************************************/
//该类可以添加不固定的额外的请求数据的额外字段
@SuppressWarnings("serial")
public class ResponVoData extends ResponVo {
	
	 private String sage;

	public String getSage() {
		return sage;
	}

	public void setSage(String sage) {
		this.sage = sage;
	}
	 
	 
}
