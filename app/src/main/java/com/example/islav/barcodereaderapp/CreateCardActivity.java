package com.example.islav.barcodereaderapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.islav.barcodereaderapp.db.DBHelper;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class CreateCardActivity extends AppCompatActivity  {
EditText edit_barcode;
EditText edit_discount;
EditText edit_name;
    private ZXingScannerView mScannerView;
    DBHelper dbHelper;
    Toolbar toolbar;
    CheckBox checkBox;
    public static final int REFRESH_ADAPTER=88;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edit_barcode=(EditText)findViewById(R.id.edit_barcode);
        edit_discount=(EditText)findViewById(R.id.edit_discount);
        edit_name=(EditText)findViewById(R.id.edit_name);
        checkBox=(CheckBox)findViewById(R.id.checkbox) ;
        dbHelper=new DBHelper(this);
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
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put("name",edit_name.getText().toString());
                cv.put("percent",edit_discount.getText().toString());
                cv.put("barcode",edit_barcode.getText().toString());
                db.insert("myCode", null, cv);
                db.close();
                setResult(REFRESH_ADAPTER);
             finish();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
