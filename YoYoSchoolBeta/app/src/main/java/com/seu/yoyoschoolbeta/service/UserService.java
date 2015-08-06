package com.seu.yoyoschoolbeta.service;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.seu.yoyoschoolbeta.service.impl.UserServiceImpl;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserService implements UserServiceImpl {
	private Context context = null;
	private RequestQueue mQue = null;
	private boolean loginResult = false;//检查登陆结果

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
						// ��½�����ͳɹ����������ؽ��
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
						// ���������½ʧ��
						Toast.makeText(context, "���ӷ�����ʧ�ܣ�����������绷��",
								Toast.LENGTH_SHORT).show();
						loginResult = false;
					}
				});
		mQue.add(mJsonObjectRequest);
	}

}
