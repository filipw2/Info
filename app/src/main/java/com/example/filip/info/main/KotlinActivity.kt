package com.example.filip.info.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.filip.info.R
import com.example.filip.info.ScanBarcodeActivity
import com.example.filip.info.display.CoinListActivity
import com.example.filip.info.display.DisplayInfoActivity
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.vision.barcode.Barcode

/**
 * Created by Filip on 2017-07-14.
 */

class KotlinActivity : Activity() {
    val EXTRA_MESSAGE = "com.example.filip.info.MESSAGE"
    internal lateinit var barcodeResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        barcodeResult = findViewById<TextView>(R.id.scan_result)
        var button: Button = findViewById(R.id.button_coin)
        button.setOnClickListener {
            startActivityHandler(CoinListActivity::class.java)
        }

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

                    val message = barcode.displayValue

                    startActivityHandler(DisplayInfoActivity::class.java, message)


                    //barcodeResult.setText("Barcode: "+barcode.displayValue);
                } else {
                    barcodeResult.text = "No barcode found"
                }
            }
        } else {
        }
    }

    fun startActivityHandler(cl: Class<*>, message: String = "") {
        var intent = Intent(this, cl)

        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }
}