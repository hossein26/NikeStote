package com.hossein.nikestore.feature.main

import android.os.Bundle
import com.hossein.nikestore.R
import com.hossein.nikestore.common.NikeActivity

class MainActivity : NikeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}