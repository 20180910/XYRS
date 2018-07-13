package com.sk.xyrs.module.home.fragment;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.androidtools.PhoneUtils;
import com.github.androidtools.SPUtils;
import com.github.androidtools.inter.MyOnClickListener;
import com.github.baseclass.adapter.MyLoadMoreAdapter;
import com.github.baseclass.adapter.MyRecyclerViewHolder;
import com.github.fastshape.MyTextView;
import com.github.mydialog.MySimpleDialog;
import com.github.progress.MyProgress;
import com.library.base.BaseObj;
import com.sk.xyrs.AppXml;
import com.sk.xyrs.R;
import com.sk.xyrs.base.BaseFragment;
import com.sk.xyrs.base.MyCallBack;
import com.sk.xyrs.base.SpaceItemDecoration;
import com.sk.xyrs.module.my.activity.SettingActivity;
import com.sk.xyrs.module.my.network.ApiRequest;
import com.sk.xyrs.module.my.network.response.LableObj;
import com.sk.xyrs.module.my.network.response.LoginObj;
import com.willy.ratingbar.BaseRatingBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    @BindView(R.id.tv_my_name)
    MyTextView tv_my_name;
    @BindView(R.id.tv_my_recharge)
    MyTextView tv_my_recharge;
    @BindView(R.id.tv_my_edit)
    MyTextView tv_my_edit;
    @BindView(R.id.tv_my_sign)
    TextView tv_my_sign;
    @BindView(R.id.tv_my_shuye_num)
    TextView tv_my_shuye_num;
    @BindView(R.id.tv_my_kabao)
    TextView tv_my_kabao;
    @BindView(R.id.tv_my_guanzhu)
    TextView tv_my_guanzhu;
    @BindView(R.id.tv_my_fensi)
    TextView tv_my_fensi;
    @BindView(R.id.tv_my_make_flag)
    MyTextView tv_my_make_flag;
    @BindView(R.id.brb_my_make_num)
    BaseRatingBar brb_my_make_num;
    @BindView(R.id.tv_my_make_current_exp)
    TextView tv_my_make_current_exp;
    @BindView(R.id.tv_my_make_max_exp)
    TextView tv_my_make_max_exp;
    @BindView(R.id.mp_make_exp)
    MyProgress mp_make_exp;
    @BindView(R.id.tv_my_read_flag)
    MyTextView tv_my_read_flag;
    @BindView(R.id.brb_my_read_num)
    BaseRatingBar brb_my_read_num;
    @BindView(R.id.tv_my_read_current_exp)
    TextView tv_my_read_current_exp;
    @BindView(R.id.tv_my_read_max_exp)
    TextView tv_my_read_max_exp;
    @BindView(R.id.mp_read_exp)
    MyProgress mp_read_exp;
    @BindView(R.id.tv_my_wdwz)
    MyTextView tv_my_wdwz;
    @BindView(R.id.tv_my_wdtz)
    MyTextView tv_my_wdtz;
    @BindView(R.id.tv_my_wdtj)
    MyTextView tv_my_wdtj;
    @BindView(R.id.tv_my_wdfs)
    MyTextView tv_my_wdfs;
    @BindView(R.id.tv_my_wdxx)
    MyTextView tv_my_wdxx;
    @BindView(R.id.tv_my_wdkb)
    MyTextView tv_my_wdkb;
    @BindView(R.id.tv_my_wdsc)
    MyTextView tv_my_wdsc;
    @BindView(R.id.tv_my_wdlljl)
    MyTextView tv_my_wdlljl;
    private MyLoadMoreAdapter flagAdapter;

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
//        app_title.setTypeface(ResourcesCompat.getFont(mContext,R.font.pingfang_bold));
        app_title.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text1));

        app_right_tv.setText("设置");
        app_right_tv.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text2));
    }

    @Override
    public void onResume() {
        super.onResume();
        setUserInfo(null);

    }

    @Override
    protected void onMyReStart() {
        super.onMyReStart();
        getUserInfo();
    }

    private void getUserInfo() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", getUserId());
        map.put("sign", getSign(map));
        ApiRequest.getUserInfo(map, new MyCallBack<LoginObj>(mContext) {
            @Override
            public void onSuccess(LoginObj obj, int errorCode, String msg) {
                setUserData(obj);
            }

            private void setUserData(LoginObj obj) {

                setUserInfo(obj);

                SPUtils.setPrefString(mContext, AppXml.userId, obj.getUser_id());
                SPUtils.setPrefString(mContext, AppXml.mobile, obj.getMobile());
                SPUtils.setPrefString(mContext, AppXml.bi_name, obj.getBi_name());
                SPUtils.setPrefString(mContext, AppXml.signature, obj.getSignature());
                SPUtils.setPrefString(mContext, AppXml.sex, obj.getSex());
                SPUtils.setPrefString(mContext, AppXml.birthday, obj.getBirthday());
                SPUtils.setPrefString(mContext, AppXml.province, obj.getProvince());
                SPUtils.setPrefString(mContext, AppXml.area, obj.getArea());
                SPUtils.setPrefString(mContext, AppXml.city, obj.getCity());

                SPUtils.setPrefInt(mContext, AppXml.rongshu_leaf, obj.getRongshu_leaf());
                SPUtils.setPrefInt(mContext, AppXml.card_bag, obj.getCard_bag());
                SPUtils.setPrefInt(mContext, AppXml.guanzhu, obj.getGuanzhu());
                SPUtils.setPrefInt(mContext, AppXml.fensi, obj.getFensi());
                SPUtils.setPrefInt(mContext, AppXml.create_value, obj.getCreate_value());

                SPUtils.setPrefString(mContext, AppXml.create_name, obj.getCreate_name());

                SPUtils.setPrefInt(mContext, AppXml.create_fenshu, obj.getCreate_fenshu());
                SPUtils.setPrefInt(mContext, AppXml.create_xing_num, obj.getCreate_xing_num());
                SPUtils.setPrefInt(mContext, AppXml.read_value, obj.getRead_value());

                SPUtils.setPrefString(mContext, AppXml.read_name, obj.getRead_name());

                SPUtils.setPrefInt(mContext, AppXml.read_fenshu, obj.getRead_fenshu());
                SPUtils.setPrefInt(mContext, AppXml.read_xing_num, obj.getRead_xing_num());
//                SPUtils.setPrefInt(mContext, AppXml.is_show_biaoqian, obj.getIs_show_biaoqian());
                SPUtils.setPrefInt(mContext, AppXml.is_show_nicheng, obj.getIs_show_nicheng());
            }
        });
    }

    private boolean isFirstInto = true;

    private void setUserInfo(LoginObj obj) {
        if (obj == null) {
            obj = new LoginObj();
            obj.setBi_name(SPUtils.getString(mContext, AppXml.bi_name, null));
            obj.setSignature(SPUtils.getString(mContext, AppXml.signature, null));
            obj.setRongshu_leaf(SPUtils.getInt(mContext, AppXml.rongshu_leaf, 0));
            obj.setCard_bag(SPUtils.getInt(mContext, AppXml.card_bag, 0));
            obj.setGuanzhu(SPUtils.getInt(mContext, AppXml.guanzhu, 0));
            obj.setFensi(SPUtils.getInt(mContext, AppXml.fensi, 0));
            obj.setCreate_name(SPUtils.getString(mContext, AppXml.create_name, null));
            obj.setCreate_xing_num(SPUtils.getInt(mContext, AppXml.create_xing_num, 0));
            obj.setCreate_value(SPUtils.getInt(mContext, AppXml.create_value, 0));
            obj.setCreate_fenshu(SPUtils.getInt(mContext, AppXml.create_fenshu, 0));
            obj.setRead_name(SPUtils.getString(mContext, AppXml.read_name, null));
            obj.setRead_xing_num(SPUtils.getInt(mContext, AppXml.read_xing_num, 0));
            obj.setRead_fenshu(SPUtils.getInt(mContext, AppXml.read_fenshu, 0));
            obj.setRead_value(SPUtils.getInt(mContext, AppXml.read_value, 0));

        }
        tv_my_name.setText(obj.getBi_name());
        tv_my_sign.setText(obj.getSignature());
        tv_my_shuye_num.setText(obj.getRongshu_leaf() + "");
        tv_my_kabao.setText(obj.getCard_bag() + "");
        tv_my_guanzhu.setText(obj.getGuanzhu() + "");
        tv_my_fensi.setText(obj.getFensi() + "");

        tv_my_make_flag.setText(obj.getCreate_name());
        brb_my_make_num.setRating(obj.getCreate_xing_num());

        tv_my_make_current_exp.setText(obj.getCreate_value() + "");
        tv_my_make_max_exp.setText("/" + obj.getCreate_fenshu());

        mp_make_exp.setMaxProgress(obj.getCreate_fenshu());
        mp_make_exp.setNowProgress(obj.getCreate_value(), isFirstInto);

        tv_my_read_flag.setText(obj.getRead_name());
        brb_my_read_num.setRating(obj.getRead_xing_num());

        tv_my_read_current_exp.setText(obj.getRead_value() + "");
        tv_my_read_max_exp.setText("/" + obj.getRead_fenshu());


        mp_read_exp.setMaxProgress(obj.getRead_fenshu());
        mp_read_exp.setNowProgress(obj.getRead_value(), isFirstInto);
        isFirstInto = false;

//        if (SPUtils.getInt(mContext, AppXml.is_show_biaoqian, 0) == 0) {
        if (SPUtils.getInt(mContext, AppXml.is_show_biaoqian, 0)== 1) {
            SPUtils.setPrefInt(mContext, AppXml.is_show_biaoqian, 0);
            Map<String,String>map=new HashMap<String,String>();
            map.put("rnd",getRnd());
            map.put("sign",getSign(map));
            ApiRequest.getFlag(map, new MyCallBack<List<LableObj>>(mContext) {
                @Override
                public void onSuccess(List<LableObj> list, int errorCode, String msg) {
                    if(notEmpty(list)){
//                        showSelectFlag(list);
                    }
                }
            });

        }

    }

    private void showSelectFlag(List<LableObj> list) {
        final MySimpleDialog dialog = new MySimpleDialog(mContext);

        View flagView = getLayoutInflater().inflate(R.layout.select_flag_popu, null);

        flagView.findViewById(R.id.tv_select_flag_skip).setOnClickListener(new MyOnClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                dialog.dismiss();
            }
        });
        RecyclerView rv_select_flag=flagView.findViewById(R.id.rv_select_flag);
        flagAdapter = new MyLoadMoreAdapter<LableObj>(mContext, R.layout.select_flag_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, final LableObj bean) {
               final MyTextView tv_select_flag_value = (MyTextView) holder.getTextView(R.id.tv_select_flag_value);
                tv_select_flag_value.setText(bean.getTitle());
                setViewSelect(bean, tv_select_flag_value);
                tv_select_flag_value.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bean.setSelect(!bean.isSelect());
                        setViewSelect(bean, tv_select_flag_value);
                    }
                });
            }
            private void setViewSelect(LableObj bean, MyTextView tv_select_flag_value) {
                if(bean.isSelect()){
                    tv_select_flag_value.getViewHelper().setSolidColor(ContextCompat.getColor(mContext, R.color.theme_text1)).complete();
                    tv_select_flag_value.setTextColor(ContextCompat.getColor(mContext,R.color.white));
                }else{
                    tv_select_flag_value.getViewHelper().setSolidColor(ContextCompat.getColor(mContext,R.color.white)).complete();
                    tv_select_flag_value.setTextColor(ContextCompat.getColor(mContext,R.color.theme_text1));
                }
            }
        };
        flagAdapter.setList(list);
        rv_select_flag.setLayoutManager(new GridLayoutManager(mContext,3));
        rv_select_flag.addItemDecoration(new SpaceItemDecoration(PhoneUtils.dip2px(mContext,10)));
        rv_select_flag.setAdapter(flagAdapter);

        flagView.findViewById(R.id.tv_select_flag_commit).setOnClickListener(new MyOnClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                List<String>list=new ArrayList<>();
                for (int i = 0; i <flagAdapter.getList().size() ; i++) {
                    LableObj lableObj = (LableObj) flagAdapter.getList().get(i);
                    if(lableObj.isSelect()){
                        list.add(lableObj.getId()+"");
                    }
                }
                if(list.size()>0){
                    setUserLable(list);
                }else{
                    showMsg("请选择标签");
                }
            }
            private void setUserLable(List<String>list) {
                showLoading();
                Map<String,String>map=new HashMap<String,String>();
                map.put("user_id",getUserId());
                map.put("sign",getSign(map));
                ApiRequest.setFlag(map, list,new MyCallBack<BaseObj>(mContext) {
                    @Override
                    public void onSuccess(BaseObj obj, int errorCode, String msg) {
//                        showMsg(msg);
                        dialog.dismiss();
                    }
                });
            }
        });

        dialog.setWidth(PhoneUtils.getScreenWidth(mContext)-PhoneUtils.dip2px(mContext,65));
        dialog.setHeight(PhoneUtils.getScreenHeight(mContext)-PhoneUtils.dip2px(mContext,120));
        dialog.setContentView(flagView);
        dialog.show();
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.app_right_tv, R.id.tv_my_recharge, R.id.tv_my_edit, R.id.tv_my_wdwz, R.id.tv_my_wdtz, R.id.tv_my_wdtj, R.id.tv_my_wdfs, R.id.tv_my_wdxx, R.id.tv_my_wdkb, R.id.tv_my_wdsc, R.id.tv_my_wdlljl})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.app_right_tv:
                STActivity(SettingActivity.class);
                break;
            case R.id.tv_my_recharge:
                break;
            case R.id.tv_my_edit:
                break;
            case R.id.tv_my_wdwz:
                break;
            case R.id.tv_my_wdtz:
                break;
            case R.id.tv_my_wdtj:
                break;
            case R.id.tv_my_wdfs:
                break;
            case R.id.tv_my_wdxx:
                break;
            case R.id.tv_my_wdkb:
                break;
            case R.id.tv_my_wdsc:
                break;
            case R.id.tv_my_wdlljl:
                break;
        }
    }
}