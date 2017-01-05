package com.example.islav.barcodereaderapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islav.barcodereaderapp.adapter.DiscountRecyclerAdapter;
import com.example.islav.barcodereaderapp.adapter.ShopRecyclerAdapter;
import com.example.islav.barcodereaderapp.db.DBHelper;
import com.example.islav.barcodereaderapp.model.Discount;
import com.example.islav.barcodereaderapp.model.Shop;

import java.util.ArrayList;
import java.util.List;

public class ChoiceShopActivity extends AppCompatActivity {
    private List<Shop> discountList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ShopRecyclerAdapter adapter;
    //DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_shop);
            recyclerView = (RecyclerView) findViewById(R.id.recycler_view_shop);

            adapter = new ShopRecyclerAdapter(discountList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);
            prepareData();
            Log.d("Stas","adapter created");


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
        /*if (dbHelper != null) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor c;
            c = db.rawQuery("SELECT * FROM myCode", null);
            for (int i = 0; i < c.getCount(); i++) {
                if (c.moveToNext()) {
                    String name = c.getString(c.getColumnIndex("name"));
                    String percent = c.getString(c.getColumnIndex("percent"));
                    String code = c.getString(c.getColumnIndex("barcode"));
                    int publicAcces =c.getInt(c.getColumnIndex("public"));
                    discountList.add(new Discount(name, percent, code,publicAcces));

                }
            }
            db.close();
        }*/

        Shop shop =new Shop("Adidas",R.drawable.adidas);
        discountList.add(shop);
        shop =new Shop("Solo",R.drawable.solo);
        discountList.add(shop);
        shop =new Shop("Colin’s",R.drawable.colins);
        discountList.add(shop);
        shop =new Shop("Comfy",R.drawable.comfy);
        discountList.add(shop);
        shop =new Shop("Дафi",R.drawable.dafi);
        discountList.add(shop);
        shop =new Shop("Эльдорадо",R.drawable.eldorado);
        discountList.add(shop);
        shop =new Shop("ЕпiЦентр",R.drawable.epicentr);
        discountList.add(shop);
        shop =new Shop("Eva",R.drawable.eva);
        discountList.add(shop);
        shop =new Shop("INTERTOP",R.drawable.intertop);
        discountList.add(shop);
        shop =new Shop("Л'Этуаль",R.drawable.letual);
        discountList.add(shop);
        shop =new Shop("ЛЮКСОПТИКА",R.drawable.luksoptica);
        discountList.add(shop);
        shop =new Shop("METRO",R.drawable.metro);
        discountList.add(shop);
        shop =new Shop("МОРЕ ПИВА",R.drawable.morepiva);
        discountList.add(shop);
        shop =new Shop("Nike",R.drawable.nike);
        discountList.add(shop);
        shop =new Shop("НОВА ЛIНIЯ",R.drawable.novalinia);
        discountList.add(shop);
        shop =new Shop("proStor",R.drawable.prostor);
        discountList.add(shop);
        shop =new Shop("puma",R.drawable.puma);
        discountList.add(shop);
        shop =new Shop("Reebok",R.drawable.reebok);
        discountList.add(shop);
        shop =new Shop("спортмастер",R.drawable.sportmaster);
        discountList.add(shop);
        shop =new Shop("VARUS",R.drawable.varus);
        discountList.add(shop);
        shop =new Shop("WOG",R.drawable.wog);
        discountList.add(shop);
        shop =new Shop("Караван",R.drawable.karavan);
        discountList.add(shop);
    }
}



