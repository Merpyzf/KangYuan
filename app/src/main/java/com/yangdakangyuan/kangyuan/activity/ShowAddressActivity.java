package com.yangdakangyuan.kangyuan.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.adapter.AddressListViewAdapter;
import com.yangdakangyuan.kangyuan.domain.AddressBean;
import com.yangdakangyuan.kangyuan.global.GlobalValue;

import java.util.ArrayList;

public class ShowAddressActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView mListView;
    private TextView tv_title;
    private ImageView iv_back;
    private ImageView iv_delete;
    private Button btn_add_address;


    private ArrayList<AddressBean> addressBeanList = GlobalValue.getAllAddress();
    private AddressListViewAdapter adapter;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_address);
        InitUI();

        adapter = new AddressListViewAdapter(this, addressBeanList);



        mListView.setAdapter(adapter);



    }

    private void InitUI() {

        mListView = (ListView) findViewById(R.id.listview_show_address);
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_back = (ImageView)findViewById(R.id.tv_menu);
        iv_delete = (ImageView)findViewById(R.id.tv_t_delete);
        btn_add_address = (Button) findViewById(R.id.btn_add_address);
        iv_delete.setVisibility(View.VISIBLE);
        iv_delete.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        btn_add_address.setOnClickListener(this);
        tv_title.setText("地址管理");



    }




    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tv_t_delete:

                //删除所有地址的操作


                showAlertDialog();



                break;

            case R.id.btn_add_address:

                //添加一个新地址

                startActivity(new Intent(ShowAddressActivity.this,EditAddressActivity.class));

                break;

            case R.id.tv_menu:

                //返回
                onBackPressed();

                break;




        }



    }

    private void showAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("提示");
        builder.setMessage("确定要删除所有的地址吗?");

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                addressBeanList.clear();
                adapter.notifyDataSetChanged();

            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialog.dismiss();


            }
        });

        dialog = builder.create();



        dialog.show();



    }
}
