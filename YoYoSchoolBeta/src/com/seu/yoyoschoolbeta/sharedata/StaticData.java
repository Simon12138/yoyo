package com.seu.yoyoschoolbeta.sharedata;

import android.R.bool;

public class StaticData {
	//静态变量一律大写
	public static int UID = 1;//测试用户ID
	public static String NAME = "admin";//测试用户名
	public static String PASSWORD = "admin";//测试用户密码
	
	public static String IP = "192.168.12.161";
	public static String PORT = "8080";
	public static String SEEVER_BASE_URL = "http://" + IP + ":" + PORT + "/YoYoServer/";
}
