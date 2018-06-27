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

public class GuanLiChengYuanActivity extends BaseActivity {
    @BindView(R.id.rv_guanli_chengyuan)
    RecyclerView rv_guanli_chengyuan;
    MyAdapter adapter;
    @Override
    protected int getContentView() {
        setAppTitle("管理成员");
        return R.layout.guanli_chengyuan_act;
    }

    @Override
    protected void initView() {
        adapter=new MyAdapter(mContext,R.layout.guanli_chengyuan_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, Object bean) {

            }
        };
        adapter.setOnLoadMoreListener(this);
        rv_guanli_chengyuan.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}