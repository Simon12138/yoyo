package com.seu.yoyoschoolbeta.sharedata;

import android.R.bool;

public class StaticData {
	//该java文件用于获取全局静态变量，变量名尽量大写，每个变量都要有注释
	public static int UID = 1;//测试用户ID
	public static String NAME = "admin";//测试用户名
	public static String PASSWORD = "admin";//测试用户密码
	
	public static String IP = "192.168.12.161";
	public static String PORT = "8080";
	public static String SEEVER_BASE_URL = "http://" + IP + ":" + PORT + "/YoYoServer/";
}
