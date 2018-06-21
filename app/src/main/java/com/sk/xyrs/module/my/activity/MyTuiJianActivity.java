package com.sk.xyrs.module.my.activity;

import android.view.View;

import com.github.baseclass.adapter.MyRecyclerViewHolder;
import com.library.base.view.MyRecyclerView;
import com.sk.xyrs.R;
import com.sk.xyrs.adapter.MyAdapter;
import com.sk.xyrs.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/21.
 */

public class MyTuiJianActivity extends BaseActivity {
    @BindView(R.id.rv_my_connection)
    MyRecyclerView rv_my_connection;

    MyAdapter adapter;

    @Override
    protected int getContentView() {
        setAppRightTitle("我的推荐");
        return R.layout.my_tuijian_act;
    }

    @Override
    protected void initView() {
        adapter=new MyAdapter(mContext,R.layout.my_tuijian_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, Object bean) {

            }
        };
        adapter.setOnLoadMoreListener(this);
        rv_my_connection.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
