package com.ten.george.asynclistviewdome;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

/**
 * 类描述：${TODO}
 * 类名称：${type_name}
 *
 * @version: 1.0
 * @author: Administrator
 * @time: 2016/6/23 18:43
 */
public class GradViewActivity extends Activity {
    /**
     * 用于展示照片墙的GridView
     */
    private GridView mPhotoWall;

    /**
     * GridView的适配器
     */
    private PhotoWallAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grad_view_test);
        mPhotoWall = (GridView) findViewById(R.id.photo_wall);
        adapter = new PhotoWallAdapter(this, 0, Images.imageUrls, mPhotoWall);
        mPhotoWall.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 退出程序时结束所有的下载任务
        adapter.cancelAllTasks();
    }
}
