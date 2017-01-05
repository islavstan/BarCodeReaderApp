package com.example.islav.barcodereaderapp.adapter;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.islav.barcodereaderapp.DetailInfoActivity;
import com.example.islav.barcodereaderapp.R;
import com.example.islav.barcodereaderapp.model.Discount;
import com.example.islav.barcodereaderapp.model.Shop;

import java.util.List;



public class ShopRecyclerAdapter extends RecyclerView.Adapter<ShopRecyclerAdapter.CustomViewHolder> {
    private List<Shop> discountList;
    public Handler hRefresh;


    public ShopRecyclerAdapter(List<Shop>discountList){
        this.discountList=discountList;
        hRefresh = new Handler() {
            public void handleMessage(android.os.Message msg) {
                notifyDataSetChanged();
            }
        };
    }
    public void setNewData (List<Shop> newList)
    {
        discountList = newList;//.remove(0);
        hRefresh.sendEmptyMessage(1);
    }

    @Override
    public ShopRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shop_item, parent, false);

        return new ShopRecyclerAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ShopRecyclerAdapter.CustomViewHolder holder, int position) {
        final Shop discount = discountList.get(position);
        holder.name.setText(discount.getName());
        holder.image.setImageResource(discount.getImage());

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Intent intent=new Intent(holder.name.getContext(), DetailInfoActivity.class);
                intent.putExtra("name",discount.getName());
                intent.putExtra("percent",discount.getDiscount_percent());
                intent.putExtra("code",discount.getCode());
                intent.putExtra("access",discount.getPublicAccess());
                holder.name.getContext().startActivity(intent);*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return discountList.size();
    }







    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        RelativeLayout card_view;
        ImageView image;
        public CustomViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            card_view=(RelativeLayout)itemView.findViewById(R.id.card_view);
            image = (ImageView)itemView.findViewById(R.id.image);


        }
    }
}
