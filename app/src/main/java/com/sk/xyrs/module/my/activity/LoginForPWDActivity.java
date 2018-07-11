package com.sk.xyrs.module.my.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.androidtools.SPUtils;
import com.github.rxbus.RxBus;
import com.sk.xyrs.AppXml;
import com.sk.xyrs.IntentParam;
import com.sk.xyrs.R;
import com.sk.xyrs.base.BaseActivity;
import com.sk.xyrs.base.MyCallBack;
import com.sk.xyrs.event.LoginSuccessEvent;
import com.sk.xyrs.module.my.network.ApiRequest;
import com.sk.xyrs.module.my.network.response.LoginObj;
import com.sk.xyrs.view.MyEditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/6/20.
 */

public class LoginForPWDActivity extends BaseActivity {
    @BindView(R.id.et_pwdlogin_phone)
    MyEditText et_pwdlogin_phone;
    @BindView(R.id.et_pwdlogin_pwd)
    MyEditText et_pwdlogin_pwd;
    @BindView(R.id.tv_pwdlogin_forget)
    TextView tv_pwdlogin_forget;
    @BindView(R.id.tv_pwdlogin_xieyi)
    TextView tv_pwdlogin_xieyi;
    @BindView(R.id.tv_pwdlogin_login)
    ImageView tv_pwdlogin_login;
    @BindView(R.id.tv_pwdlogin_question)
    TextView tv_pwdlogin_question;

    @Override
    protected int getContentView() {
        return R.layout.login_pwd_act;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_pwdlogin_forget, R.id.tv_pwdlogin_xieyi, R.id.tv_pwdlogin_login, R.id.tv_pwdlogin_question})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.tv_pwdlogin_forget:
                STActivity(FindPWDActivity.class);
                break;
            case R.id.tv_pwdlogin_xieyi:
                Intent intent=new Intent();
                intent.putExtra(IntentParam.xieYiType,"1");
                STActivity(intent,XieYiActivity.class);
                break;
            case R.id.tv_pwdlogin_login:
                String phone = getSStr(et_pwdlogin_phone);
                String pwd = getSStr(et_pwdlogin_pwd);
                if(TextUtils.isEmpty(phone)){
                    showMsg("请输入手机号");
                   return;
                }else if(TextUtils.isEmpty(pwd)){
                    showMsg("请输入密码");
                    return;
                }
                pwdLogin(phone,pwd);
                break;
            case R.id.tv_pwdlogin_question:
                STActivity(LoginQuestionActivity.class);
                break;
        }
    }

    private void pwdLogin(String phone, String pwd) {
        showLoading();
        Map<String,String> map=new HashMap<String,String>();
        map.put("mobile",phone);
        map.put("pwd",pwd);
        map.put("registrationid", SPUtils.getString(mContext, AppXml.registrationId,"1"));
        map.put("sign",getSign(map));
        ApiRequest.loginForPwd(map, new MyCallBack<LoginObj>(mContext) {
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

                RxBus.getInstance().post(new LoginSuccessEvent(LoginSuccessEvent.status_1));
                setResult(RESULT_OK);
                finish();
            }
        });

    }
}
