package com.sk.xyrs.module.my.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.baseclass.adapter.MyRecyclerViewHolder;
import com.sk.xyrs.R;
import com.sk.xyrs.adapter.MyAdapter;
import com.sk.xyrs.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/25.
 */

public class BlackListActivity extends BaseActivity {
    @BindView(R.id.rv_black_list)
    RecyclerView rv_black_list;

    MyAdapter adapter;
    @Override
    protected int getContentView() {
        setAppTitle("黑名单管理");
        return R.layout.black_list_act;
    }

    @Override
    protected void initView() {
        adapter=new MyAdapter(mContext,R.layout.black_list_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, Object bean) {

            }
        };
        adapter.setOnLoadMoreListener(this);

        rv_black_list.setAdapter(adapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
