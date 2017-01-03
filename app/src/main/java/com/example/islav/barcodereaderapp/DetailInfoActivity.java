package com.example.islav.barcodereaderapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.islav.barcodereaderapp.barcode.Code128;

public class DetailInfoActivity extends AppCompatActivity {
TextView shop_name,percentTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);
        Intent intent = getIntent();
        shop_name=(TextView)findViewById(R.id.shop_name) ;
        percentTV=(TextView)findViewById(R.id.percent) ;
        String name = intent.getStringExtra("name");
        String code = intent.getStringExtra("code");
        String percent = intent.getStringExtra("percent");
        shop_name.setText(name);
        percentTV.setText("Скидка: "+percent+" %");


        drawBarcode(code);
    }


    private void drawBarcode(String cod) {
        String barcode = cod;
        Code128 code = new Code128(this);
        code.setData(barcode);
        Bitmap bitmap = code.getBitmap(900, 450);
        ImageView ivBarcode = (ImageView)findViewById(R.id.code128_barcode);
        ivBarcode.setImageBitmap(bitmap);
    }
}
