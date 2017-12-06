package com.xzy.loadingdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author xzy
 * @date 2017/12/06
 */
public class MainActivity extends BaseActivity {

    private Button btn_show_loading;
    private Button btn_hide_loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_show_loading = findViewById(R.id.btn_show_loading);
        btn_hide_loading = findViewById(R.id.btn_hide_loading);
        btn_show_loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoading(false);
            }
        });
        btn_hide_loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideLoading();
            }
        });
    }
}
