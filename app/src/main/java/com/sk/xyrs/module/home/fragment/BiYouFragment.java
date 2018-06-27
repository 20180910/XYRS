package com.sk.xyrs.module.home.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.sk.xyrs.R;
import com.sk.xyrs.adapter.FragmentAdapter;
import com.sk.xyrs.base.BaseFragment;
import com.sk.xyrs.module.biyou.fragment.BiYouTieZiFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/20.
 */

public class BiYouFragment extends BaseFragment {
    @BindView(R.id.app_title)
    TextView app_title;

    @BindView(R.id.app_right_tv)
    TextView app_right_tv;

    @BindView(R.id.vp_biyouhui)
    ViewPager vp_biyouhui;

    FragmentAdapter fragmentAdapter;

    @Override
    protected int getContentView() {
        return R.layout.bi_you_frag;
    }

    public static BiYouFragment newInstance() {

        Bundle args = new Bundle();

        BiYouFragment fragment = new BiYouFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView() {
        app_title.setText("笔友会");
        app_right_tv.setText("创建/加入");
        app_title.setTextColor(ContextCompat.getColor(mContext,R.color.theme_text1));
        app_right_tv.setTextColor(ContextCompat.getColor(mContext,R.color.theme_text2));


        fragmentAdapter=new FragmentAdapter(getChildFragmentManager());
        List<String>titleList=new ArrayList<>();
        titleList.add("东风破");
        titleList.add("华山派");
        titleList.add("全真教");
        titleList.add("武当派");


        List<Fragment> list=new ArrayList<>();
        list.add(BiYouTieZiFragment.newInstance());
        list.add(BiYouTieZiFragment.newInstance());
        list.add(BiYouTieZiFragment.newInstance());
        list.add(BiYouTieZiFragment.newInstance());
        fragmentAdapter.setList(list);
        fragmentAdapter.setTitleList(titleList);

        vp_biyouhui.setAdapter(fragmentAdapter);
        vp_biyouhui.setOffscreenPageLimit(list.size()-1);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
