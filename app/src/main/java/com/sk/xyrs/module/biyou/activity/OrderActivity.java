package com.sk.xyrs.module.biyou.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.baseclass.adapter.MyRecyclerViewHolder;
import com.sk.xyrs.R;
import com.sk.xyrs.adapter.MyAdapter;
import com.sk.xyrs.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/27.
 */

public class OrderActivity extends BaseActivity {
    @BindView(R.id.rv_order)
    RecyclerView rv_order;
    MyAdapter adapter;
    @Override
    protected int getContentView() {
        setAppRightTitle("排序");
        return R.layout.order_act;
    }

    @Override
    protected void initView() {
        adapter=new MyAdapter(mContext,R.layout.order_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, Object bean) {

            }
        };
        adapter.setOnLoadMoreListener(this);
        rv_order.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
