package com.example.islav.barcodereaderapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.islav.barcodereaderapp.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab().setText("Мои"));
        tab_layout.addTab(tab_layout.newTab().setText("Общие"));



        final ViewPager view_pager = (ViewPager) findViewById(R.id.pager);
        view_pager.setOffscreenPageLimit(2);
        final ViewPagerAdapter adapter = new ViewPagerAdapter
                (getSupportFragmentManager(), tab_layout.getTabCount());

        view_pager.setAdapter(adapter);



        view_pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));
        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view_pager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });}

}
