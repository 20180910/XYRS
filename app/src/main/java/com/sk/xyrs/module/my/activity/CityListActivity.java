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

public class CityListActivity extends BaseActivity {
    @BindView(R.id.rv_city_list)
    RecyclerView rv_city_list;
    MyAdapter adapter;
    @Override
    protected int getContentView() {
        return R.layout.city_list_act;
    }

    @Override
    protected void initView() {
        setAppTitle("城市");
        adapter=new MyAdapter(mContext,R.layout.city_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, Object bean) {

            }
        };
        adapter.setOnLoadMoreListener(this);
        rv_city_list.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
