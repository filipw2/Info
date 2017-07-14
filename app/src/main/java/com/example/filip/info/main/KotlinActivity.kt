package com.example.filip.info.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.filip.info.R
import com.example.filip.info.ScanBarcodeActivity
import com.example.filip.info.display.DisplayInfoActivity
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.vision.barcode.Barcode

/**
 * Created by Grzegorz on 2017-07-14.
 */

class KotlinActivity : Activity() {
    val EXTRA_MESSAGE = "com.example.filip.info.MESSAGE"
    internal lateinit var barcodeResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        barcodeResult = findViewById<TextView>(R.id.scan_result)

    }

    fun scanBarcode(v: View) {
        val intent = Intent(this, ScanBarcodeActivity::class.java)
        startActivityForResult(intent, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 0) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    val barcode = data.getParcelableExtra<Barcode>("barcode")
                    val intent = Intent(this, DisplayInfoActivity::class.java)
                    val message = barcode.displayValue
                    intent.putExtra(EXTRA_MESSAGE, message)
                    startActivity(intent)

                    //barcodeResult.setText("Barcode: "+barcode.displayValue);
                } else {
                    barcodeResult.setText("No barcode found")
                }
            }
        } else {
        }
    }
}