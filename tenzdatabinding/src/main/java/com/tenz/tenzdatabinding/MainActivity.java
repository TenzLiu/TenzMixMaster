package com.tenz.tenzdatabinding;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.tenz.tenzdatabinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding dataBinding;

    private User mUser;
    private List<User> mUserList = new ArrayList<>();

    public class OnClickListener{
        public void addAge(View view, User user){
            mUser.setAge(mUser.getAge()+1);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mUser = new User();
        mUser.setName("Tenz");
        mUser.setAge(18);

        dataBinding.setUser(mUser);
        dataBinding.setOnClickListener(new OnClickListener());

        for(int i=0; i<5; i++){
            User user = new User();
            user.setName("tenz" + i);
            user.setAge(18 + i);
            mUserList.add(user);
        }
        dataBinding.rvMain.setLayoutManager(new LinearLayoutManager(this));
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(this, mUserList, new RecycleViewAdapter.OnItemClick() {
            @Override
            public void onItemClick(User user) {
                user.setAge(user.getAge()+1);
            }
        });
        dataBinding.rvMain.setAdapter(recycleViewAdapter);


    }

}
