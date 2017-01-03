package com.example.islav.barcodereaderapp.adapter;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.islav.barcodereaderapp.DetailInfoActivity;
import com.example.islav.barcodereaderapp.R;
import com.example.islav.barcodereaderapp.model.Discount;

import java.util.ArrayList;
import java.util.List;



public class DiscountRecyclerAdapter extends RecyclerView.Adapter<DiscountRecyclerAdapter.CustomViewHolder> {
    private List<Discount> discountList;
    public Handler hRefresh;


public DiscountRecyclerAdapter(List<Discount>discountList){
    this.discountList=discountList;
    hRefresh = new Handler() {
        public void handleMessage(android.os.Message msg) {
            notifyDataSetChanged();
        }
    };
}
    public void setNewData (List<Discount> newList)
    {
        discountList = newList;//.remove(0);
        hRefresh.sendEmptyMessage(1);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        final Discount discount = discountList.get(position);
        holder.name.setText(discount.getName());
        holder.disc.setText("скидка: "+discount.getDiscount_percent()+" %");
        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.name.getContext(), DetailInfoActivity.class);
                intent.putExtra("name",discount.getName());
                intent.putExtra("percent",discount.getDiscount_percent());
                intent.putExtra("code",discount.getCode());
                holder.name.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return discountList.size();
    }







    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView name,disc;
        CardView card_view;
        public CustomViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.shop_name);
            disc = (TextView) itemView.findViewById(R.id.discount);
            card_view=(CardView)itemView.findViewById(R.id.card_view);

        }
    }
}
