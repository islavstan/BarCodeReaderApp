package com.example.islav.barcodereaderapp;

import android.animation.ValueAnimator;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.islav.barcodereaderapp.adapter.DiscountViewPagerAdapter;
import com.example.islav.barcodereaderapp.adapter.ShopRecyclerAdapter;
import com.example.islav.barcodereaderapp.fragments.MyCardsFragment;
import com.github.clans.fab.FloatingActionButton;
import com.joanfuentes.hintcase.HintCase;
import com.joanfuentes.hintcase.Shape;
import com.joanfuentes.hintcase.ShapeAnimator;
import com.joanfuentes.hintcaseassets.contentholderanimators.FadeInContentHolderAnimator;
import com.joanfuentes.hintcaseassets.contentholderanimators.SlideOutFromRightContentHolderAnimator;
import com.joanfuentes.hintcaseassets.hintcontentholders.SimpleHintContentHolder;
import com.joanfuentes.hintcaseassets.shapeanimators.RevealCircleShapeAnimator;
import com.joanfuentes.hintcaseassets.shapes.CircularShape;


public class MainDiscountActivity extends AppCompatActivity {
    FloatingActionButton fab;
     ViewPager view_pager;
    DiscountViewPagerAdapter adapter;
    Toolbar toolbar;

    private static final float DEFAULT_MIN_RADIUS = 50;
    private static final float DEFAULT_MAX_RADIUS = 10000;

    private float minRadius = DEFAULT_MIN_RADIUS;
    private float maxRadius = DEFAULT_MAX_RADIUS;
    private float currentRadius = DEFAULT_MAX_RADIUS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discount_activity_main);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TabLayout tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab().setText("Мои"));
        tab_layout.addTab(tab_layout.newTab().setText("Общие"));
         view_pager = (ViewPager) findViewById(R.id.pager);
        view_pager.setOffscreenPageLimit(2);
          adapter = new DiscountViewPagerAdapter
                (getSupportFragmentManager(), tab_layout.getTabCount());
        view_pager.setAdapter(adapter);



     /*   SimpleHintContentHolder hintBlock = new SimpleHintContentHolder.Builder(this)
                .setContentTitle("Attention!")
                .setContentText("You can find here your notifications")
               *//* .setTitleStyle(R.style.title)
                .setContentStyle(R.style.content)*//*
                .build();
        new HintCase(findViewById(android.R.id.content))
                .setTarget(findViewById(R.id.save), new CircularShape(), HintCase.TARGET_IS_NOT_CLICKABLE)
                .setBackgroundColor(getResources().getColor(R.color.colorPrimary))
                .setShapeAnimators(new RevealCircleShapeAnimator(), ShapeAnimator.NO_ANIMATOR)
                .setHintBlock(hintBlock, new FadeInContentHolderAnimator(), new SlideOutFromRightContentHolderAnimator()).show();*/







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
               Intent intent=new Intent(MainDiscountActivity.this,ChoiceShopActivity.class);
                startActivityForResult(intent,1);
//-----------------------------------начало-----------------------------------------------------
               /* SimpleHintContentHolder  hintBlock = new SimpleHintContentHolder.Builder(view.getContext())
                        .setContentTitle("Внимание!")
                        .setContentText("Если список дисконтов пуст, нажмите обновить")
                .setTitleStyle(R.style.title)
                .setContentStyle(R.style.content)
                        .build();


                new HintCase(findViewById(android.R.id.content))
                        .setTarget(findViewById(R.id.save), new CircularShape() {
                            @Override
                            public void setMinimumValue() {
                                currentRadius = minRadius;
                            }

                            @Override
                            public void setShapeInfo(View targetView, ViewGroup parent, int offset, Context context) {
                                if (targetView != null) {
                                    minRadius = (Math.max(targetView.getMeasuredWidth(),targetView.getMeasuredHeight()) / 2) + offset;
                                    maxRadius = Math.max(parent.getHeight(), parent.getWidth());
                                    int[] targetViewLocationInWindow = new int[2];
                                    targetView.getLocationInWindow(targetViewLocationInWindow);
                                    setCenterX(targetViewLocationInWindow[0] + targetView.getWidth() / 2);
                                    setCenterY(targetViewLocationInWindow[1] + targetView.getHeight() / 2);
                                    setLeft((int) (getCenterX() - minRadius));
                                    setRight((int) (getCenterX() + minRadius));
                                    setTop((int) (getCenterY()  - minRadius));
                                    setBottom((int) (getCenterY() + minRadius));
                                    setWidth(minRadius * 2);
                                    setHeight(minRadius * 2);
                                } else {
                                    if (parent != null) {
                                        minRadius = 0;
                                        maxRadius = parent.getHeight();
                                        setCenterX(parent.getMeasuredWidth() / 2);
                                        setCenterY(parent.getMeasuredHeight() / 2);
                                        setLeft(0);
                                        setTop(0);
                                        setRight(0);
                                        setBottom(0);
                                    }
                                }
                                currentRadius = maxRadius;
                            }


                            @Override
                            public boolean isTouchEventInsideTheHint(MotionEvent event) {
                                float xDelta = Math.abs(event.getRawX() - getCenterX());
                                float yDelta = Math.abs(event.getRawY() - getCenterY());
                                double distanceFromFocus = Math.sqrt(Math.pow(xDelta, 2) + Math.pow(yDelta, 2));
                                return distanceFromFocus <= minRadius;
                            }

                            @Override
                            public void draw(Canvas canvas) {
                                canvas.drawCircle(getCenterX(), getCenterY()-45, 60, getShapePaint());
                            }
                        }, HintCase.TARGET_IS_NOT_CLICKABLE)
                        .setBackgroundColor(getResources().getColor(R.color.black))
                        .setShapeAnimators(new RevealCircleShapeAnimator(), ShapeAnimator.NO_ANIMATOR)
                        .setHintBlock(hintBlock, new FadeInContentHolderAnimator(), new SlideOutFromRightContentHolderAnimator()).show();*/
                //-----------------------------------конец-----------------------------------------------------
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

