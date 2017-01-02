package com.example.islav.barcodereaderapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.content.ContentValues.TAG;



public class SimpleScannerActivity extends Activity implements ZXingScannerView.ResultHandler {
    public static int CODE =555;
    private ZXingScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
     // Toast.makeText(this,rawResult.getText(),Toast.LENGTH_SHORT).show(); // Prints scan results
      //  Log.v("Stas", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)
        Toast.makeText(this,rawResult.getText(),Toast.LENGTH_SHORT).show();
       //finish();
        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
      //  mScannerView.stopCamera();
        Intent intent = new Intent();
        intent.putExtra("code",rawResult.getText());
        setResult(CODE,intent);
        finish();
    }
}