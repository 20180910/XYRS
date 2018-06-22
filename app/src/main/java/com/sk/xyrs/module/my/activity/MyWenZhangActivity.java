package com.sk.xyrs.module.my.activity;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.sk.xyrs.R;
import com.sk.xyrs.adapter.FragmentAdapter;
import com.sk.xyrs.base.BaseActivity;
import com.sk.xyrs.module.my.fragment.MyWenZhangFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/21.
 */

public class MyWenZhangActivity extends BaseActivity {
    @BindView(R.id.vp_wenzhang)
    ViewPager vp_wenzhang;
    FragmentAdapter adapter;
    @Override
    protected int getContentView() {
        setAppTitle("我的文章");
        return R.layout.my_wen_zhang_act;
    }

    @Override
    protected void initView() {
        adapter=new FragmentAdapter(getSupportFragmentManager());
        List<String> list=new ArrayList<>();
        list.add("全部");
        list.add("已发布");
        list.add("审核中");
        list.add("草稿");
        List<MyWenZhangFragment>fragmentList=new ArrayList<>();
        fragmentList.add(MyWenZhangFragment.newInstance());
        fragmentList.add(MyWenZhangFragment.newInstance());
        fragmentList.add(MyWenZhangFragment.newInstance());
        fragmentList.add(MyWenZhangFragment.newInstance());

        adapter.setList(fragmentList);
        adapter.setTitleList(list);

        vp_wenzhang.setAdapter(adapter);
        vp_wenzhang.setOffscreenPageLimit(fragmentList.size()-1);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
