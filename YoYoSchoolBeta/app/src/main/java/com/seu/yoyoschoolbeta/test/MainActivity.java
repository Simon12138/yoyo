package com.seu.yoyoschoolbeta.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.seu.yoyoschoolbeta.R;
import com.seu.yoyoschoolbeta.core.FreeGoodsActivity;


/**
 * Created by wufan on 2015/8/6.
 */
public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Button button= (Button) findViewById(R.id.demo_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, FreeGoodsActivity.class);
                startActivity(intent);
            }
        });
    }
}
