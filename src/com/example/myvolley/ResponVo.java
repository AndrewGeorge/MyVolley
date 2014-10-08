package com.example.myvolley;

import java.io.Serializable;

/****************************
 * 类名:ResponVo 类描述：网络访问响应基类可以将网络访问的固定字段封装在此,多次使用
 * @version 1.0.0
 * @author dafuShao
 * @time  2014-9-29 12:08:35
 *****************************/
@SuppressWarnings("serial")
public class ResponVo  implements Serializable{
	
	
	//网络请求常用字段，更具具体的项目中使用的具体设置
String count_id;
String count_name;
String data;
public String getCount_id() {
	return count_id;
}
public void setCount_id(String count_id) {
	this.count_id = count_id;
}
public String getCount_name() {
	return count_name;
}
public void setCount_name(String count_name) {
	this.count_name = count_name;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
	

}
