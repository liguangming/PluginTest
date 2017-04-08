 package com.example.administrator.plugintest;

 import android.content.Intent;
 import android.os.Bundle;
 import android.os.Environment;
 import android.support.v7.app.AppCompatActivity;
 import android.view.View;

 import com.example.plugincore.PluginManage;
 import com.example.plugincore.ProxyActivity;

 import java.io.File;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PluginManage.getInstance(this);
    }
    public void jump(View view){

        Intent intent=new Intent(this, ProxyActivity.class);
        //跳到插件
        intent.putExtra("className",PluginManage.getInstance().getPackageInfo().activities[0].name);
        startActivity(intent);
    }
    public void load(View view){
        File file=new File(Environment.getExternalStorageDirectory(),"plugin.apk");
        PluginManage.getInstance().loadPath(file.getAbsolutePath());
    }
}
