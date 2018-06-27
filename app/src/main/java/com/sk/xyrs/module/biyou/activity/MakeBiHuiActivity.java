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

public class MakeBiHuiActivity extends BaseActivity {
    @BindView(R.id.rv_makebihui_tuijian)
    RecyclerView rv_makebihui_tuijian;
    MyAdapter adapter;
    @Override
    protected int getContentView() {
        setAppTitle("加入/创建笔会");
        return R.layout.make_bihui_act;
    }

    @Override
    protected void initView() {
        adapter=new MyAdapter(mContext,R.layout.make_bihui_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, Object bean) {

            }
        };
        adapter.setOnLoadMoreListener(this);
        rv_makebihui_tuijian.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
