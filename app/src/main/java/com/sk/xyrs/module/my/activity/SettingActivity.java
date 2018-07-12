package com.sk.xyrs.module.my.activity;

import android.content.DialogInterface;
import android.view.View;

import com.github.baseclass.view.MyDialog;
import com.github.rxbus.RxBus;
import com.sk.xyrs.R;
import com.sk.xyrs.base.BaseActivity;
import com.sk.xyrs.event.LoginSuccessEvent;

import butterknife.OnClick;

/**
 * Created by Administrator on 2018/6/25.
 */

public class SettingActivity extends BaseActivity {

    @Override
    protected int getContentView() {
        setAppTitle("设置");
        hiddenBackIcon();
        return R.layout.setting_act;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.ll_setting_top})
    protected void onViewClick(View v) {
        switch (v.getId()){
            case R.id.ll_setting_top:
                MyDialog.Builder mDialog=new MyDialog.Builder(mContext);
                mDialog.setMessage("是否确认退出登录?");
                mDialog.setNegativeButton(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                mDialog.setPositiveButton(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        clearUserId();
                        RxBus.getInstance().post(new LoginSuccessEvent(LoginSuccessEvent.status_0));

                        finish();
                    }
                });
                mDialog.create().show();
            break;
        }
    }
}
