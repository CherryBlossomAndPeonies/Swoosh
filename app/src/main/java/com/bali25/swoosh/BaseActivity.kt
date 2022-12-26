package com.bali25.swoosh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class BaseActivity : AppCompatActivity() {
    val TAG: String = "Lifecycle";

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "${javaClass.simpleName} on create")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "${javaClass.simpleName} on start")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "${javaClass.simpleName} on resume")
        super.onResume()
    }

    override fun onRestart() {
        Log.d(TAG, "${javaClass.simpleName} on restart")
        super.onRestart()
    }

    override fun onPause() {
        Log.d(TAG, "${javaClass.simpleName} on pause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d(TAG, "${javaClass.simpleName} on destroy")
        super.onDestroy()
    }
}