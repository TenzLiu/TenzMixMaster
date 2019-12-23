package com.tenz.baselib.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.jaeger.library.StatusBarUtil;
import com.tenz.baselib.R;

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    protected T mDataBinding;
    protected Activity mActivity;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        initStatusBar();
        mActivity = this;
        mContext = this;
        initView();
        initData();
    }

    /**
     * 设置状态栏
     */
    protected void initStatusBar() {
        StatusBarUtil.setColor(this,getResources().getColor(R.color.colorApp),0);
    }

    /**
     * 初始化控件
     */
    protected void initView() {

    }

    /**
     * 初始化数据
     */
    protected void initData(){

    }

    /**
     * 布局UI
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * activity跳转
     * @param clss
     */
    protected void startActivity(Class clss){
        Intent intent = new Intent(mContext,clss);
        startActivity(intent);
    }

    /**
     * activity跳转,带参数表
     * @param clss
     */
    protected void startActivity(Class clss, Bundle bundle){
        Intent intent = new Intent(mContext,clss);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
