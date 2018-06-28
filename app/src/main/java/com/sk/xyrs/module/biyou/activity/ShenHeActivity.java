package com.sk.xyrs.module.biyou.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.sk.xyrs.R;
import com.sk.xyrs.adapter.FragmentAdapter;
import com.sk.xyrs.base.BaseActivity;
import com.sk.xyrs.module.biyou.fragment.ShenHeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/28.
 */

public class ShenHeActivity extends BaseActivity {
    @BindView(R.id.tab_shenhe)
    TabLayout tab_shenhe;

    @BindView(R.id.vp_shenhe)
    ViewPager vp_shenhe;
    FragmentAdapter fragmentAdapter;

    @Override
    protected int getContentView() {
        setAppTitle("审核");
        return R.layout.shen_he_act;
    }

    @Override
    protected void initView() {
        fragmentAdapter=new FragmentAdapter(getSupportFragmentManager());
        List<Fragment> list=new ArrayList<>();
        list.add(ShenHeFragment.newInstance());
        list.add(ShenHeFragment.newInstance());
        list.add(ShenHeFragment.newInstance());
        List<String>titleList=new ArrayList<>();
        titleList.add("待审核");
        titleList.add("已通过");
        titleList.add("未通过");

        fragmentAdapter.setList(list);
        fragmentAdapter.setTitleList(titleList);
        vp_shenhe.setAdapter(fragmentAdapter);
        vp_shenhe.setOffscreenPageLimit(list.size()-1);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
