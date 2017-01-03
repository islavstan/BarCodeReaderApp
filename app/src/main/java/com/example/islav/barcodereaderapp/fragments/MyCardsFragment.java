package com.example.islav.barcodereaderapp.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islav.barcodereaderapp.R;
import com.example.islav.barcodereaderapp.adapter.DiscountRecyclerAdapter;
import com.example.islav.barcodereaderapp.db.DBHelper;
import com.example.islav.barcodereaderapp.model.Discount;

import java.util.ArrayList;
import java.util.List;


public class MyCardsFragment extends Fragment {
    private List<Discount> discountList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DiscountRecyclerAdapter adapter;
    DBHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.my_cards_fragment, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        dbHelper = new DBHelper(getActivity());
        adapter = new DiscountRecyclerAdapter(discountList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareData();
        Log.d("Stas","adapter created");
        return v;

    }

    public void update(String textSearch)
    {
        if(discountList != null) {
            discountList.clear();
            prepareData();
            if(adapter != null )
                adapter.setNewData(discountList);
            Log.d("Stas","adapter update "+adapter);
        }
    }

    private void prepareData() {
        if (dbHelper != null) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor c;
            c = db.rawQuery("SELECT * FROM myCode", null);
            for (int i = 0; i < c.getCount(); i++) {
                if (c.moveToNext()) {
                    String name = c.getString(c.getColumnIndex("name"));
                    String percent = c.getString(c.getColumnIndex("percent"));
                    String code = c.getString(c.getColumnIndex("barcode"));
                    discountList.add(new Discount(name, percent, code));

                }
            }
            db.close();
        }
    }
}
