package com.example.lsh.webviewtbs;

import android.app.Application;

public class APPAplication extends Application {
	private static APPAplication instance;
	APIWebviewTBS	mAPIWebviewTBS;
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		//个人封装，针对升级----开始
		mAPIWebviewTBS=APIWebviewTBS.getAPIWebview();
		mAPIWebviewTBS.initTbs(getApplicationContext());
		//个人封装，针对升级----结束
	}

	public static Application getInstance() {
		return instance;
	}
}
