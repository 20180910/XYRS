package com.sk.xyrs.module.found.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.baseclass.adapter.MyRecyclerViewHolder;
import com.sk.xyrs.R;
import com.sk.xyrs.adapter.MyAdapter;
import com.sk.xyrs.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/26.
 */

public class FoundActivity extends BaseActivity {
    @BindView(R.id.rv_quanzhan_tuijian)
    RecyclerView rv_quanzhan_tuijian;
    MyAdapter adapter;
    @Override
    protected int getContentView() {
        return R.layout.found_frag;
    }

    @Override
    protected void initView() {
        adapter=new MyAdapter(mContext,R.layout.found_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, Object bean) {

            }
        };
        adapter.setOnLoadMoreListener(this);
        rv_quanzhan_tuijian.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
