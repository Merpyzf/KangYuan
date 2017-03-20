package com.yangdakangyuan.kangyuan.fragment;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.activity.GoodDetailActivity;
import com.yangdakangyuan.kangyuan.adapter.ClassListAdapter;
import com.yangdakangyuan.kangyuan.adapter.MyGridAdapter;
import com.yangdakangyuan.kangyuan.domain.ClassBean;
import com.yangdakangyuan.kangyuan.domain.HotGoodBean;
import com.yangdakangyuan.kangyuan.global.GlobalValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */

public class ClassifyGoodsFragment extends Fragment
{
    //初始化控件
    private Activity mActivity;
    private GridView gridView;
    private EditText edit_search;
    private ImageView image_search;
    private ListView listView;
    private List<ClassBean> data;
    private ClassListAdapter listAdapter;
    private List<HotGoodBean> goodsData;
    private MyGridAdapter gridAdapter;

    private TextView tv_title;
    private ImageView iv_menu;




    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return initView();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private View initView()
    {
        View view = View.inflate(mActivity, R.layout.fragment_classify_goods, null);

        gridView = (GridView) view.findViewById(R.id.classify_grid);
        edit_search = (EditText) view.findViewById(R.id.classify_edit_search);
        image_search = (ImageView) view.findViewById(R.id.classify_image_search);
        listView = (ListView) view.findViewById(R.id.classify_list);

        tv_title = (TextView) view.findViewById(R.id.tv_title);

        iv_menu = (ImageView) view.findViewById(R.id.tv_delete);

        iv_menu.setVisibility(View.INVISIBLE);

        tv_title.setText("商品分类");
        return view;
    }

    private void initData()
    {
        //初始化分类数据
        data = new ArrayList<ClassBean>();
        data.add(new ClassBean("新鲜牛奶", R.drawable.ic_action_milk));
        data.add(new ClassBean("优倍"));
        data.add(new ClassBean("致优"));
        data.add(new ClassBean("新鲜酸奶", R.drawable.ic_action_yogurt));
        data.add(new ClassBean("赏味"));
        data.add(new ClassBean("畅优"));

        listAdapter = new ClassListAdapter(mActivity, data);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(data.get(position).getImage() == 0)
                {
                    switch (position)
                    {
                        case 1:
                            Log.i("main", "dajfoifa");
                            goodsData = GlobalValue.getHotGoods();
                            gridAdapter = new MyGridAdapter(mActivity, goodsData);
                            gridView.setAdapter(gridAdapter);
                            break;

                        case 2:
                            goodsData = GlobalValue.getClassify1Goods();
                            gridAdapter = new MyGridAdapter(mActivity, goodsData);
                            gridView.setAdapter(gridAdapter);
//                    gridAdapter.notifyDataSetChanged();
                            break;

                        case 4:
                            goodsData = GlobalValue.getHotGoods();
                            gridAdapter = new MyGridAdapter(mActivity, goodsData);
                            gridView.setAdapter(gridAdapter);
                            break;

                        case 5:
                            goodsData = GlobalValue.getClassify1Goods();
                            gridAdapter = new MyGridAdapter(mActivity, goodsData);
                            gridView.setAdapter(gridAdapter);
                            break;
                    }
                }
            }
        });

        goodsData = GlobalValue.getHotGoods();
        gridAdapter = new MyGridAdapter(mActivity, goodsData);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                HotGoodBean bean = (HotGoodBean) parent.getItemAtPosition(position);

                View imageView = parent.getChildAt(position);

                int childCount = parent.getChildCount();

                Intent intent = new Intent(mActivity,GoodDetailActivity.class);

                intent.putExtra("hotGood",goodsData.get(position));

                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(mActivity,imageView,"share").toBundle());
            }
        });

    }

}
