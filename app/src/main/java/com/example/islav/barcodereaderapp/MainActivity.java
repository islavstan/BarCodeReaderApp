package com.example.islav.barcodereaderapp;

import android.app.SearchManager;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.islav.barcodereaderapp.adapter.ViewPagerAdapter;
import com.example.islav.barcodereaderapp.fragments.MyCardsFragment;
import com.example.islav.barcodereaderapp.fragments.PublicCardsFragment;
import com.github.clans.fab.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
     ViewPager view_pager;
    ViewPagerAdapter adapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TabLayout tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab().setText("Мои"));
        tab_layout.addTab(tab_layout.newTab().setText("Общие"));
         view_pager = (ViewPager) findViewById(R.id.pager);
        view_pager.setOffscreenPageLimit(2);
          adapter = new ViewPagerAdapter
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
        });

        fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CreateCardActivity.class);
                startActivityForResult(intent,1);
            }
        });



    }

    private void refreshTab(int position, String textSearch) {
        switch (position) {
            case 0:
                MyCardsFragment mf = (MyCardsFragment) adapter.getItem(position);
                mf.update(textSearch);
                break;
            case 1:
              //  PublicCardsFragment pf = (PublicCardsFragment) adapter.getItem(position);
              //  pf.update(textSearch);
                break;

        }
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == CreateCardActivity.REFRESH_ADAPTER) {
            refreshTab(0,"");
            adapter.notifyDataSetChanged();


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_for_search_card, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
              /*  if(type == 1)
                    usersFromDialog(newText);
                else
                    usersForDialog(newText);
                return false;*/
                return false;
            }
        });
        return true;
    }
}

