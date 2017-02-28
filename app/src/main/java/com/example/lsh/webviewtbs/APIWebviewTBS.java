package com.example.lsh.webviewtbs;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.WindowManager;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;

/**
 * Created by lsh on 2017/2/27.
 */

public class APIWebviewTBS {  //二次封装tbs类，升级直接更换该类的方法\

    private static APIWebviewTBS mAPIWebviewTBS;

    public static APIWebviewTBS getAPIWebview() {
        if (mAPIWebviewTBS == null) {
            synchronized (APIWebviewTBS.class) {
                if (mAPIWebviewTBS == null) {
                    mAPIWebviewTBS = new APIWebviewTBS();
                }
            }
        }
        return mAPIWebviewTBS;
    }

    public void initTbs(Context context) {//第一步：application的方法
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        //TbsDownloader.needDownload(getApplicationContext(), false);
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                Log.e("app", " onViewInitFinished is " + arg0);
            }
            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        QbSdk.setTbsListener(new TbsListener() {
            @Override
            public void onDownloadFinish(int i) {
                Log.d("app","onDownloadFinish");
            }

            @Override
            public void onInstallFinish(int i) {
                Log.d("app","onInstallFinish");
            }

            @Override
            public void onDownloadProgress(int i) {
                Log.d("app","onDownloadProgress:"+i);
            }
        });
//        QbSdk.initX5Environment(getApplicationContext(),  cb);
        QbSdk.initX5Environment(context,cb);  //二次封装更换
    }
    public void initTBSActivity(Activity ac){   //二次封装
        if (ac!=null){
            ac.getWindow().setFormat(PixelFormat.TRANSLUCENT);
            ac.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        }

    }
}
