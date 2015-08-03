package com.seu.yoyoschoolbeta.service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.seu.yoyoschoolbeta.service.impl.UserServiceImpl;

public class UserService implements UserServiceImpl {
	private Context context = null;
	private RequestQueue mQue = null;
	private boolean loginResult = false;//检测登陆状态

	public UserService(Context context) {
		this.context = context;
		mQue = Volley.newRequestQueue(this.context);
	}
	
	public boolean isLoginResult() {
		return loginResult;
	}

	public void setLoginResult(boolean loginResult) {
		this.loginResult = loginResult;
	}

	@Override
	public void userLogin(String name, String password, String url) {
		
		Map<String, String> appendHeader = new HashMap<String, String>();
		appendHeader.put("name", name);
		appendHeader.put("password", password);
		
		JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(url,
				new JSONObject(appendHeader),
				new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						System.out.println(response.toString());
						// 登陆请求发送成功，解析返回结果
						try {
							String flag = response.getString("flag");
							if(flag.equals("success")){
								loginResult = true;
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						// 网络问题登陆失败
						Toast.makeText(context, "连接服务器失败，请检查您的网络环境",
								Toast.LENGTH_SHORT).show();
						loginResult = false;
					}
				});
		mQue.add(mJsonObjectRequest);
	}

}
