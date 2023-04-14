package com.example.bshop1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Model.ItemCart;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder>{
    List<ItemCart> itemCartList;
    public CartAdapter(List<ItemCart> itemCartList){
        this.itemCartList =itemCartList;
    }
    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewgiohang,parent,false);
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        ItemCart itemCart = itemCartList.get(position);
        holder.img.setImageResource(itemCart.getImg());
        holder.tvName.setText(itemCart.getName());
        holder.tvCost.setText(String.valueOf(itemCart.getCost()));
        holder.tvSL.setText(String.valueOf(itemCart.getSl()));
        holder.tvMoney.setText(String.valueOf(itemCart.getSl()*itemCart.getCost()));
    }

    @Override
    public int getItemCount() {
        return itemCartList.size();
    }

    public class CartHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tvName,tvCost,tvSL,tvMoney;
        public CartHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvName = itemView.findViewById(R.id.tvName);
            tvCost = itemView.findViewById(R.id.tvCost);
            tvSL = itemView.findViewById(R.id.tvSL);
            tvMoney = itemView.findViewById(R.id.tvMoney);
        }
    }
}
