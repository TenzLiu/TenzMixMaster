package com.tenz.tenzdatabinding;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<User> mUserList = new ArrayList<>();
    private OnItemClick mOnItemClick;

    public RecycleViewAdapter(Context mContext, List<User> mUserList, OnItemClick onItemClick) {
        this.mContext = mContext;
        this.mUserList = mUserList;
        this.mOnItemClick = onItemClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_main, parent, false);
        return new MyViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = mUserList.get(position);
        holder.bind(user,mOnItemClick);
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding viewDataBinding;

        public MyViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
        }

        public void bind(Object object, OnItemClick onItemClick){
            viewDataBinding.setVariable(BR.user,object);
            viewDataBinding.setVariable(BR.onItemClick,onItemClick);
            viewDataBinding.executePendingBindings();
        }
    }

    public interface OnItemClick{
        void onItemClick(User user);
    }

}
