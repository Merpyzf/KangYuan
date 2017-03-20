package com.yangdakangyuan.kangyuan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yangdakangyuan.kangyuan.R;

/**
 * Created by Administrator on 2017/3/17.
 */

public class RegisterActivity extends Activity
{
    private TextView title;
    private ImageView iv_back;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_register);

        iv_back = (ImageView) findViewById(R.id.tv_menu);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });


        title = (TextView) findViewById(R.id.tv_title);
        title.setText("注册");
    }
}
