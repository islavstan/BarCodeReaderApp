package com.example.islav.barcodereaderapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islav.barcodereaderapp.R;
import com.example.islav.barcodereaderapp.adapter.DiscountRecyclerAdapter;
import com.example.islav.barcodereaderapp.model.Discount;

import java.util.ArrayList;
import java.util.List;


public class MyCardsFragment extends Fragment {
    private List<Discount> discountList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DiscountRecyclerAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.my_cards_fragment, container, false);
        recyclerView =(RecyclerView)v.findViewById(R.id.my_recycler_view);
        adapter=new DiscountRecyclerAdapter(discountList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareData();
        return v;

    }

    private void prepareData() {
       Discount discount =new Discount("Ева","10");
        discountList .add(discount);
        discount = new Discount("Караван","5");
        discountList.add(discount);
        discount = new Discount("Караван","5");
        discountList.add(discount);
        discount = new Discount("Караван","5");
        discountList.add(discount);
    }
}
