package com.tenz.tenzmixmaster.view;


import com.jaeger.library.StatusBarUtil;
import com.tenz.baselib.base.BaseActivity;
import com.tenz.tenzmixmaster.R;
import com.tenz.tenzmixmaster.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initStatusBar() {
        super.initStatusBar();
        StatusBarUtil.setColorForDrawerLayout(this,mDataBinding.drawerLayoutMain,
                getResources().getColor(R.color.colorApp),0);
    }

}
