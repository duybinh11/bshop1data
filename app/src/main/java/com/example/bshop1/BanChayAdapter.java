package com.example.bshop1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Model.Item;

public class BanChayAdapter extends RecyclerView.Adapter<BanChayAdapter.BanChayHolder>{
    List<Item> itemList;
    public BanChayAdapter( List<Item> itemList){
        this.itemList = itemList;
    }
    @NonNull
    @Override
    public BanChayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewbanchay,parent,false);
        return new BanChayHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BanChayHolder holder, int position) {
        Item item = itemList.get(position);
        holder.img.setImageResource(item.getImg());
        holder.tv.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class BanChayHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv;
        public BanChayHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img1);
            tv = itemView.findViewById(R.id.tv1);
        }
    }
}
