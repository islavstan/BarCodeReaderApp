package com.example.islav.barcodereaderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class CreateCardActivity extends AppCompatActivity  {
EditText edit_barcode;
EditText edit_discount;
EditText edit_name;
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);
        edit_barcode=(EditText)findViewById(R.id.edit_barcode);
        edit_discount=(EditText)findViewById(R.id.edit_discount);
        edit_name=(EditText)findViewById(R.id.edit_name);
        edit_barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent =new Intent(CreateCardActivity.this,SimpleScannerActivity.class);
                startActivityForResult(intent,1);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == SimpleScannerActivity.CODE) {
            String code = data.getStringExtra("code");
            edit_barcode.setText(code);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_for_create_card, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.save:



                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
