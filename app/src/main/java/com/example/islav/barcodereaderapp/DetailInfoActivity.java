package com.example.islav.barcodereaderapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.islav.barcodereaderapp.barcode.Code128;

public class DetailInfoActivity extends AppCompatActivity {
TextView shop_name,percentTV;
    Toolbar toolbar;
    int access;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        shop_name=(TextView)findViewById(R.id.shop_name) ;
        percentTV=(TextView)findViewById(R.id.percent) ;
        String name = intent.getStringExtra("name");
        String code = intent.getStringExtra("code");
        access =intent.getIntExtra("access",0);
        String percent = intent.getStringExtra("percent");
        shop_name.setText(name);
        percentTV.setText("Скидка: "+percent+" %");
        setTitle(name);

        drawBarcode(code);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_for_detail_card, menu);
        MenuItem item = menu.findItem(R.id.action_check);
        if(access==1)
        item.setChecked(true);
        else  item.setChecked(false);
        return super.onCreateOptionsMenu(menu);
    }



    private void drawBarcode(String cod) {
        String barcode = cod;
        Code128 code = new Code128(this);
        code.setData(barcode);
        Bitmap bitmap = code.getBitmap(900, 450);
        ImageView ivBarcode = (ImageView)findViewById(R.id.code128_barcode);
        ivBarcode.setImageBitmap(bitmap);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_check) {
            item.setChecked(!item.isChecked());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
