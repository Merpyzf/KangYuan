package com.yangdakangyuan.kangyuan.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yangdakangyuan.kangyuan.R;

public class IndentCalendarActivity extends AppCompatActivity {

    private ImageView iv_back;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent_calendar);

        iv_back = (ImageView) findViewById(R.id.tv_menu);
        tv_title = (TextView)findViewById(R.id.tv_title);
//HAUHA
        tv_title.setText("订单日历");

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                onBackPressed();

            }
        });

    }
}
