package com.example.islav.barcodereaderapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.islav.barcodereaderapp.R;
import com.example.islav.barcodereaderapp.model.Discount;

import java.util.List;



public class DiscountRecyclerAdapter extends RecyclerView.Adapter<DiscountRecyclerAdapter.CustomViewHolder> {
    private List<Discount> discountList;


public DiscountRecyclerAdapter(List<Discount>discountList){
    this.discountList=discountList;
}


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Discount discount = discountList.get(position);
        holder.name.setText(discount.getName());
        holder.disc.setText("скидка: "+discount.getDiscount_percent()+" %");

    }

    @Override
    public int getItemCount() {
        return discountList.size();
    }







    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView name,disc;
        public CustomViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.shop_name);
            disc = (TextView) itemView.findViewById(R.id.discount);

        }
    }
}
