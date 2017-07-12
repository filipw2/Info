package com.example.filip.info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.filip.info.display.DisplayInfoActivity;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.support.v7.media.MediaControlIntent.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.filip.info.MESSAGE";
    TextView barcodeResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        barcodeResult = (TextView) findViewById(R.id.scan_result);
    }

    public void scanBarcode(View v){
        Intent intent = new Intent(this, ScanBarcodeActivity.class);
        startActivityForResult(intent,0);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==0){
            if(resultCode== CommonStatusCodes.SUCCESS){
                if(data != null){
                    Barcode barcode = data.getParcelableExtra("barcode");
                    Intent intent = new Intent(this, DisplayInfoActivity.class);
                    String message = barcode.displayValue;
                    intent.putExtra(EXTRA_MESSAGE, message);
                    startActivity(intent);

                    //barcodeResult.setText("Barcode: "+barcode.displayValue);
                }else{
                    barcodeResult.setText("No barcode found");
                }
            }
        }else{}
    }
}
