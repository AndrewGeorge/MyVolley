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

		// ��������

		 // �����������
		 ResponVoData responVoData = new ResponVoData();
		 // �����������
		 responVoData.setCount_id("000001");
		 responVoData.setCount_name("����");
		 responVoData.setSage("18");
		 responVoData.setData("book");
		
		 GetDataFromNet dataFromNet = new GetDataFromNet(this, this,
		 MyMessage.class);
		 // ������������
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

		// �жϷ��ص������Ƿ����Լ����������
		// ������MyResponListener���޸ķ�������
		if (responVo instanceof MyMessage) {
			// �ڴ˴����ص���ȷ����

		}

	}

	@Override
	public void onErrorResponse(VolleyError error, ResponVo responVo) {

		Toast.makeText(getBaseContext(), "��������ʧ�ܣ����Ժ����ԣ�", 1).show();
	}

}
