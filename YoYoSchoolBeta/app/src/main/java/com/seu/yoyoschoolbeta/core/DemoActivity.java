package com.seu.yoyoschoolbeta.core;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.seu.yoyoschoolbeta.R;
import com.seu.yoyoschoolbeta.sharedata.StaticData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DemoActivity extends Activity {

	private EditText nameEdt = null;
	private EditText pwdEdt = null;
	private Button loginBtn = null;

	private String url = StaticData.SEEVER_BASE_URL + "login.json";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);

		bindView();

		loginBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				userLogin(nameEdt.getText().toString(), pwdEdt.getText().toString(), url);
			}
		});

	}

	private void bindView() {
		nameEdt = (EditText) findViewById(R.id.demo_name);
		pwdEdt = (EditText) findViewById(R.id.demo_password);
		loginBtn = (Button) findViewById(R.id.demo_login);
	}

	private void userLogin(String name, String password, String url) {
		RequestQueue mQue = Volley.newRequestQueue(this);
		Map<String, String> appendHeader = new HashMap<String, String>();
		appendHeader.put("name", name);
		appendHeader.put("password", password);

		JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(url,
				new JSONObject(appendHeader),
				new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						System.out.println(response.toString());
						//连接服务器成功返回
						try {
							String flag = response.getString("flag");
							Toast.makeText(DemoActivity.this, flag, 1000).show();
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Toast.makeText(DemoActivity.this, "网络连接失败，检查网络",
								Toast.LENGTH_SHORT).show();
					}
				});
		mQue.add(mJsonObjectRequest);
	}
}
