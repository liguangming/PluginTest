package com.example.pluginapk;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.plugincore.BasePluginActivy;

public class MainActivity extends BasePluginActivy {

    @Override
    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(that,"弹出了一个吐司",Toast.LENGTH_LONG).show();
            }
        });

    }
}
