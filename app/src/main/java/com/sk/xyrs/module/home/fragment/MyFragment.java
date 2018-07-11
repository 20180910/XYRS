package com.sk.xyrs.module.home.fragment;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.TextView;

import com.github.androidtools.SPUtils;
import com.sk.xyrs.AppXml;
import com.sk.xyrs.R;
import com.sk.xyrs.base.BaseFragment;
import com.sk.xyrs.base.MyCallBack;
import com.sk.xyrs.module.my.network.ApiRequest;
import com.sk.xyrs.module.my.network.response.LoginObj;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/6/20.
 */

public class MyFragment extends BaseFragment {
    @BindView(R.id.app_title)
    TextView app_title;
    @BindView(R.id.app_right_tv)
    TextView app_right_tv;

    @Override
    protected int getContentView() {
        return R.layout.my_frag;
    }

    public static MyFragment newInstance() {

        Bundle args = new Bundle();

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView() {
        app_title.setText("我的");
        app_title.setTypeface(ResourcesCompat.getFont(mContext,R.font.pingfang_bold));
        app_title.setTextColor(ContextCompat.getColor(mContext,R.color.theme_text1));

        app_right_tv.setText("设置");
        app_right_tv.setTextColor(ContextCompat.getColor(mContext,R.color.theme_text2));
    }

    @Override
    public void onResume() {
        super.onResume();
        setUserInfo();
    }
    @Override
    protected void onMyReStart() {
        super.onMyReStart();
        getUserInfo();
    }
    private void getUserInfo() {
        Map<String,String> map=new HashMap<String,String>();
        map.put("user_id",getUserId());
        map.put("sign",getSign(map));
        ApiRequest.getUserInfo(map, new MyCallBack<LoginObj>(mContext) {
            @Override
            public void onSuccess(LoginObj obj, int errorCode, String msg) {
                setUserData(obj);
            }
            private void setUserData(LoginObj obj) {
                SPUtils.setPrefString(mContext, AppXml.userId,obj.getUser_id());
                SPUtils.setPrefString(mContext, AppXml.mobile,obj.getMobile());
                SPUtils.setPrefString(mContext, AppXml.bi_name,obj.getBi_name());
                SPUtils.setPrefString(mContext, AppXml.signature,obj.getSignature());
                SPUtils.setPrefString(mContext, AppXml.sex,obj.getSex());
                SPUtils.setPrefString(mContext, AppXml.birthday,obj.getBirthday());
                SPUtils.setPrefString(mContext, AppXml.province,obj.getProvince());
                SPUtils.setPrefString(mContext, AppXml.area,obj.getArea());
                SPUtils.setPrefString(mContext, AppXml.city,obj.getCity());

                SPUtils.setPrefInt(mContext, AppXml.rongshu_leaf,obj.getRongshu_leaf());
                SPUtils.setPrefInt(mContext, AppXml.card_bag,obj.getCard_bag());
                SPUtils.setPrefInt(mContext, AppXml.guanzhu,obj.getGuanzhu());
                SPUtils.setPrefInt(mContext, AppXml.fensi,obj.getFensi());
                SPUtils.setPrefInt(mContext, AppXml.create_value,obj.getCreate_value());

                SPUtils.setPrefString(mContext, AppXml.create_name,obj.getCreate_name());

                SPUtils.setPrefInt(mContext, AppXml.create_fenshu,obj.getCreate_fenshu());
                SPUtils.setPrefInt(mContext, AppXml.create_xing_num,obj.getCreate_xing_num());
                SPUtils.setPrefInt(mContext, AppXml.read_value,obj.getRead_value());

                SPUtils.setPrefString(mContext, AppXml.read_name,obj.getRead_name());

                SPUtils.setPrefInt(mContext, AppXml.read_fenshu,obj.getRead_fenshu());
                SPUtils.setPrefInt(mContext, AppXml.read_xing_num,obj.getRead_xing_num());
                SPUtils.setPrefInt(mContext, AppXml.is_show_biaoqian,obj.getIs_show_biaoqian());
                SPUtils.setPrefInt(mContext, AppXml.is_show_nicheng,obj.getIs_show_nicheng());
                setUserInfo();
            }
        });
    }

    private void setUserInfo() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.app_right_tv})
    protected void onViewClick(View v) {
        switch (v.getId()){
            case R.id.app_right_tv:
            break;
        }
    }
}