package com.example.myvolley;

import com.android.volley.VolleyError;
import com.example.myvolley.untils.ImageLoad_Uils;
import com.example.myvolley.untils.URL_Uils;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;

public class MainActivity extends Activity implements MyResponListener {

	ImageView imagetest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imagetest = (ImageView) findViewById(R.id.imagetest);
		ImageLoad_Uils
				.setImage(
						imagetest,
						"http://img2.imgtn.bdimg.com/it/u=3432564608,1309332850&fm=21&gp=0.jpg",
						true, ScaleType.FIT_CENTER, R.drawable.ic_launcher,
						MainActivity.this);

		// 网络请求

		 // 创建请求参数
		 ResponVoData responVoData = new ResponVoData();
		 // 设置请求参数
		 responVoData.setCount_id("000001");
		 responVoData.setCount_name("张三");
		 responVoData.setSage("18");
		 responVoData.setData("book");
		
		 GetDataFromNet dataFromNet = new GetDataFromNet(this, this,
		 MyMessage.class);
		 // 开启网络请求
		 Log.i("MainActivity", "startUrl>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		 dataFromNet.startUrl(URL_Uils.url_getString(this, responVoData,
		 Constants.WEATHERUPDATA));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onResponse(ResponVo responVo) {
		// TODO Auto-generated method stub

		// 判断返回的数据是否是自己定义的类型
		// 可以在MyResponListener中修改返回类型
		if (responVo instanceof MyMessage) {
			// 在此处理返回的正确数据

		}

	}

	@Override
	public void onErrorResponse(VolleyError error, ResponVo responVo) {

		Toast.makeText(getBaseContext(), "加载数据失败，请稍后再试！", 1).show();
	}

}
