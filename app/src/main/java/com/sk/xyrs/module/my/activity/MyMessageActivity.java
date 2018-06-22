package com.sk.xyrs.module.my.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.baseclass.adapter.MyRecyclerViewHolder;
import com.sk.xyrs.R;
import com.sk.xyrs.adapter.MyAdapter;
import com.sk.xyrs.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/22.
 */

public class MyMessageActivity extends BaseActivity {
    @BindView(R.id.rv_my_message)
    RecyclerView rv_my_message;

    MyAdapter adapter;
    @Override
    protected int getContentView() {
        setAppTitle("消息");
        return R.layout.my_message_act;
    }

    @Override
    protected void initView() {
        adapter=new MyAdapter(mContext,R.layout.my_message_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, Object bean) {

            }
        };
        adapter.setOnLoadMoreListener(this);
        rv_my_message.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
