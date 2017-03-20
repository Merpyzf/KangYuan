package com.yangdakangyuan.kangyuan.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yangdakangyuan.kangyuan.R;

public class EditAddressActivity extends AppCompatActivity {

    private ImageView iv_back;
    private TextView tv_title;
    private ImageView iv_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_address);
        InitUI();

    }

    private void InitUI() {

        iv_back = (ImageView) findViewById(R.id.tv_menu);
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_save = (ImageView)findViewById(R.id.tv_t_delete);

        tv_title.setText("添加地址");
        iv_save.setVisibility(View.VISIBLE);
        iv_save.setImageResource(R.drawable.ic_save);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();

            }
        });

        iv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(EditAddressActivity.this,"保存成功",Toast.LENGTH_SHORT).show();

            }
        });


    }
}
