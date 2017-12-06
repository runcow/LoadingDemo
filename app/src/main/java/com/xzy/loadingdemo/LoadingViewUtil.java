package com.xzy.loadingdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/**
 * activity加载圈
 *
 * @author xzy
 * @date 2017/12/06
 */

public class LoadingViewUtil {


    /**
     * 显示加载圈
     * @param activity
     * @param isCover 是否需要遮罩 防止点击
     */
    public static void showLoading(BaseActivity activity , boolean isCover){
        if (isLoading(activity)){
            return;
        }
        FrameLayout root = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        if (root != null){
            View loadingView = LayoutInflater.from(activity).inflate(R.layout.lyt_loading, null);
            if (isCover) {
                //遮罩层设置点击事件，拦截底层视图的点击事件
                loadingView.findViewById(R.id.cover).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
            loadingView.findViewById(R.id.cover).setVisibility(isCover ? View.VISIBLE : View.GONE);
            root.removeView(loadingView);
            root.addView(loadingView);
        }
    }

    /**
     * 隐藏加载圈
     * @param activity
     */
    public static void hideLoading(BaseActivity activity){
        FrameLayout root = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        if (root != null){
            View loadingView = root.findViewById(R.id.cover_root);
            if (loadingView != null) {
                root.removeView(loadingView);
            }
        }
    }

    /**
     * 加载圈是否正在显示
     * @param activity
     * @return
     */
    public static boolean isLoading(BaseActivity activity) {
        FrameLayout root = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        if (root != null){
            View loadingView = root.findViewById(R.id.cover_root);
            return loadingView != null && root.indexOfChild(loadingView) != -1;
        }
        return false;
    }

}
