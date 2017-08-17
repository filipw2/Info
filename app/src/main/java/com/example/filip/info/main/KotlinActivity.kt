package com.example.filip.info.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.filip.info.R
import com.example.filip.info.ScanBarcodeActivity
import com.example.filip.info.view.CoinListActivity
import com.example.filip.info.view.DisplayInfoActivity
import com.example.filip.info.view.DualActivity
import com.example.filip.info.view.swipe.SwipeActivity
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.vision.barcode.Barcode

/**
 * Created by Filip on 2017-07-14.
 */

class KotlinActivity : AppCompatActivity() {
    var TAG = "KotlinActivity"
    val EXTRA_MESSAGE = "com.example.filip.info.MESSAGE"
    internal lateinit var barcodeResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        setContentView(R.layout.activity_main)
        val myToolbar = findViewById(R.id.toolbar) as Toolbar

        setSupportActionBar(myToolbar)
        barcodeResult = findViewById(R.id.scan_result) as TextView
        var button: Button = findViewById(R.id.button_coin) as Button
        button.setOnClickListener {
            startActivityHandler(CoinListActivity::class.java)
        }

    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
    }
    fun scanBarcode(v: View) {
        var intent = Intent(applicationContext, ScanBarcodeActivity::class.java)
        startActivityForResult(intent, 0)

    }

    fun swipe(v: View) {
        Log.i(TAG, "in swipe")
        startActivityHandler(SwipeActivity::class.java)
    }

    fun startDual(v: View) {
        Log.i(TAG, "in startDual")
        startActivityHandler(DualActivity::class.java)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.i(TAG, "onActivityResult")

        if (requestCode == 0) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    val barcode = data.getParcelableExtra<Barcode>("barcode")

                    val message = barcode.displayValue

                    Log.i(TAG, "onActivityResult startActivity with message $message")
                    startActivityHandler(DisplayInfoActivity::class.java, message)

                } else {
                    recreate()
                }
            } else {
                recreate()
            }
        } else {
            recreate()
        }
    }

    fun startActivityHandler(cl: Class<*>, message: String = "") {
        var intent = Intent(applicationContext, cl)
        Log.i(TAG, "in startActivityHandler")
        if (message != "") intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
        Log.i(TAG, "startActivityHandler end")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_info, menu)
        return true
    }


}