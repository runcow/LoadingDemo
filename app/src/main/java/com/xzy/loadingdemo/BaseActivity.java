package com.xzy.loadingdemo;

import android.support.v7.app.AppCompatActivity;

/**
 *
 * @author xzy
 * @date 2017/12/6
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        //断网以后打开app进行测试
        if (!NetworkUtil.isNetworkAvailable(this)){
            NetworkUtil.showNetworklessView(this);
        }
    }

    protected void showLoading(boolean isCover){
        LoadingViewUtil.showLoading(this,isCover);
    }

    protected void hideLoading(){
        LoadingViewUtil.hideLoading(this);
    }

    protected void isLoading(){
        LoadingViewUtil.isLoading(this);
    }

}
