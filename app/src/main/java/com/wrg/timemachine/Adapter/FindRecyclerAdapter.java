package com.wrg.timemachine.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.wrg.timemachine.Entity.ThemeEntity;
import com.wrg.timemachine.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 翁 on 2017/3/1.
 */

public class FindRecyclerAdapter extends RecyclerView.Adapter<FindRecyclerAdapter.MyViewHolder> {

    private Context context;
    private List<ThemeEntity.OthersBean> datas;

    private ItemClickListener mListener;


    public void setmListener(ItemClickListener mListener) {
        this.mListener = mListener;
    }

    public FindRecyclerAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();

    }

    public void setDatas(List<ThemeEntity.OthersBean> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_find_grid, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(datas.get(position).getName());
        Glide.with(context)
                .load(datas.get(position).getThumbnail())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_num);
            img = (ImageView) view.findViewById(R.id.zhihu_img);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(view,getPosition(),datas);
            }
        }
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position, List<ThemeEntity.OthersBean> datas);

    }

}
