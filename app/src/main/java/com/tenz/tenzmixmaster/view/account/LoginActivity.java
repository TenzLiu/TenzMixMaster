package com.tenz.tenzmixmaster.view.account;

import android.view.View;

import androidx.lifecycle.ViewModelProviders;

import com.tenz.baselib.base.BaseActivity;
import com.tenz.tenzmixmaster.R;
import com.tenz.tenzmixmaster.databinding.ActivityLoginBinding;
import com.tenz.tenzmixmaster.viewmodel.LoginViewModel;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements View.OnClickListener {

    private LoginViewModel mLoginViewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
        mLoginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        mDataBinding.btnLogin.setOnClickListener(this);
        mDataBinding.tvToRegister.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                //login

                break;
            case R.id.tv_to_register:
                //toRegister
                startActivity(RegisterActivity.class);
                break;
        }
    }
}
