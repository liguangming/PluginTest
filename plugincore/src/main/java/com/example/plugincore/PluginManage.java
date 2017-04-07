package com.example.plugincore;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * Created by Administrator on 2017/4/7.
 */

public class PluginManage {

    //加载外置卡中的apk的class文件
    private DexClassLoader dexClassLoader;

    private Context context;

    private Resources resources;
    //包含activity的全类名
    private PackageInfo packageInfo;

    private static PluginManage instance;

    private PluginManage(Context context) {
        this.context = context;
    }


    public static PluginManage getInstance(Context context) {
        if (instance == null) {
            instance = new PluginManage(context);
        }
        return instance;
    }

    public static PluginManage getInstance() {
        if (instance == null) {
            throw new RuntimeException("必须实例化第一个参数的构造方法");
        }
        return instance;
    }

    /**
     * 加载apk的路径
     */
    public void loadPath(String path) {
        File dexOutFile = context.getDir("dex", Context.MODE_PRIVATE);
        //实例化一个DexClassload
        dexClassLoader = new DexClassLoader(path, dexOutFile.getAbsolutePath(), null, context.getClassLoader());
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            //反射给assertManage设置路径
            Method addAssetPath = AssetManager.class.getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, path);
            //实例化resource
            Resources superResource = context.getResources();
            resources = new Resources(assetManager, superResource.getDisplayMetrics(), superResource.getConfiguration());

            PackageManager packageManager = context.getPackageManager();
            packageInfo = packageManager.getPackageArchiveInfo(path, PackageManager.GET_ACTIVITIES);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public DexClassLoader getDexClassLoader() {
        return dexClassLoader;
    }

    public Resources getResources() {
        return resources;
    }

    public PackageInfo getPackageInfo() {
        return packageInfo;
    }
}
