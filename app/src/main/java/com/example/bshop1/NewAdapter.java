package com.example.bshop1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Model.Item;

public class NewAdapter extends  RecyclerView.Adapter<NewAdapter.NewHolder>{

    List<Item> itemList;
    public NewAdapter(List<Item> itemList){
        this.itemList = itemList;
    }
    @NonNull
    @Override
    public NewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewnew,parent,false);
        return new NewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.img.setImageResource(item.getImg());
        holder.tvName.setText(item.getName());
        holder.tvCost.setText("10");
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class NewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvName,tvCost,tvSl;
        public NewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvName = itemView.findViewById(R.id.tvName);
            tvCost = itemView.findViewById(R.id.tvCost);
            tvSl = itemView.findViewById(R.id.tvSL);
        }
    }
}
