package com.example.plugincore;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 代理activity
 * 资源
 * 有生命周期
 * Created by Administrator on 2017/4/7.
 */

public class ProxyActivity extends Activity {
    //替换插件apk里面的Activity的全类名
    String className;
    private PluginInterface pluginInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        className=intent.getStringExtra("className");
        lauchActivity();


    }
    /**
     * 通过反射加载外置卡apk的activity
     * */
    private void lauchActivity() {
        try {
            //通过dexClassLoader加载外置卡的class
            Class<?> loadClass=PluginManage.getInstance().getDexClassLoader().loadClass(className);
            Constructor constructor=loadClass.getConstructor(new Class[]{});
            //反射得到activity实例
            Object instance=constructor.newInstance(new Object[]{});
            //理由标准接口 将插件APK里的class强转成接口

            pluginInterface=(PluginInterface)instance;
            pluginInterface.attach(this);
            Bundle bundle=new Bundle();
            //写一些传值的方法
            pluginInterface.onCreat(bundle);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        pluginInterface.onStart();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        pluginInterface.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        pluginInterface.onStop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        pluginInterface.onBackPressed();
    }

    /**
     * 必须重写getResource
     * 当前拿到的所有图片的xml
     *
     * @return
     */
    @Override
    public Resources getResources() {
        return PluginManage.getInstance().getResources();
    }
}
