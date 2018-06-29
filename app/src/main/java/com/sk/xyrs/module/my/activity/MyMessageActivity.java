package com.sk.xyrs.module.my.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.sk.xyrs.R;
import com.sk.xyrs.adapter.FragmentAdapter;
import com.sk.xyrs.base.BaseActivity;
import com.sk.xyrs.module.my.fragment.MyMessageFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/22.
 */

public class MyMessageActivity extends BaseActivity {
    @BindView(R.id.tab_my_message)
    TabLayout tab_my_message;
    FragmentAdapter fragmentAdapter;
    @BindView(R.id.vp_my_message)
    ViewPager vp_my_message;
    @Override
    protected int getContentView() {
        setAppTitle("消息");
        return R.layout.my_message_act;
    }

    @Override
    protected void initView() {
        fragmentAdapter=new FragmentAdapter(getSupportFragmentManager());
        List<String>titleList=new ArrayList<>();
        titleList.add("系统消息");
        titleList.add("@我");
        titleList.add("私信");

        List<Fragment> list=new ArrayList<>();
        list.add(MyMessageFragment.newInstance());
        list.add(MyMessageFragment.newInstance());
        list.add(MyMessageFragment.newInstance());

        fragmentAdapter.setList(list);
        fragmentAdapter.setTitleList(titleList);

        vp_my_message.setAdapter(fragmentAdapter);
        vp_my_message.setOffscreenPageLimit(list.size()-1);

    }
    @Override
    protected void initData() {

    }
    @Override
    protected void onViewClick(View v) {

    }
}
