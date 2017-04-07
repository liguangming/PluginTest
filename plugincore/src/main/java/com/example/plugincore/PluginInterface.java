package com.example.plugincore;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/4/7.
 * 插件化开发标准
 * 所有通过插件加载的activity必须都实现下列接口
 */

public interface PluginInterface {
     void attach(Activity proxyActivity);
     void onCreat(Bundle savedInstanceState);
     void onStart();
     void onResume();
     void onPause();
     void onStop();
     void onDestroy();
     void onSaveInatanceState(Bundle outState);
     boolean onTouchEvent(MotionEvent event);
     void onBackPressed();
}
