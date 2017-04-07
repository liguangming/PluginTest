package com.example.plugincore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * 所有的能加载的插件Activity必须实现PluginInterface
 * Created by Administrator on 2017/4/7.
 */

public class BasePluginActivy extends Activity implements PluginInterface {
    protected Activity that;

    @Override
    public void attach(Activity proxyActivity) {
        that=proxyActivity;

    }

    @Override
    public void onCreat(Bundle savedInstanceState) {

    }

    @Override
    public void setContentView(View view) {
        that.setContentView(view);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        that.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        that.setContentView(view, params);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        that.addContentView(view, params);
    }

    @Override
    public View findViewById(@IdRes int id) {
        return that.findViewById(id);
    }

    @Override
    public Intent getIntent() {
        return that.getIntent();
    }

    @Override
    public ClassLoader getClassLoader() {
        return that.getClassLoader();
    }

    @Override
    public Resources getResources() {
        return that.getResources();
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return that.getLayoutInflater();
    }

    @Override
    public MenuInflater getMenuInflater() {
        return that.getMenuInflater();
    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return that.getSharedPreferences(name, mode);
    }

    @Override
    public Context getApplicationContext() {
        return that.getApplicationContext();
    }

    @Override
    public Window getWindow() {
        return that.getWindow();
    }

    @Override
    public WindowManager getWindowManager() {
        return that.getWindowManager();
    }

    @Override
    public Object getSystemService(String name){
        return that.getSystemService(name);
    }

    @Override
    public void finish() {
        that.finish();
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
    }

    @Override
    protected void onNewIntent(Intent intent) {
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void onSaveInatanceState(Bundle outState) {

    }
}
