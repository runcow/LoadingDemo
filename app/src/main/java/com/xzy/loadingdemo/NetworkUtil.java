package com.xzy.loadingdemo;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

/**
 *
 * 统一无网络提示
 * @author xzy
 * @date 2017/12/6
 */

public class NetworkUtil {

    /**
     * 展示统一无网络页面
     * @param activity
     */
    public static void showNetworklessView(final BaseActivity activity){
        activity.hideLoading();
        FrameLayout root = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        View noNetView = LayoutInflater.from(activity).inflate(R.layout.lyt_no_network, null);
        //覆盖上层view的点击事件
        noNetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //重试按钮的点击事件
        noNetView.findViewById(R.id.tv_retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable(activity)){
                    Intent intent = new Intent(activity,activity.getClass());
                    intent.putExtras(activity.getIntent());
                    activity.startActivity(intent);
                    activity.overridePendingTransition(0,0);
                    activity.finish();
                } else {
                    Toast.makeText(activity,"当前网络不可用,请检查网络设置",Toast.LENGTH_SHORT).show();
                }
            }
        });
        root.removeView(noNetView);
        root.addView(noNetView);
        Toast.makeText(activity,"当前网络不可用,请检查网络设置",Toast.LENGTH_SHORT).show();
    }

    /**
     * 检测当的网络（WLAN、3G/2G）状态
     * @param context Context
     * @return true 表示网络可用
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected())
            {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED)
                {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }

}
