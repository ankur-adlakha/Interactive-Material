package com.bluexpresso.materialplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bluexpresso.materialplayground.databinding.ActivityMainBinding
import com.bluexpresso.materialplayground.materialcomponents.MaterialComponentsActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
                as ActivityMainBinding
        initMaterialComponents(binding)
        initAds(binding.adView)
    }

    private fun initMaterialComponents(binding: ActivityMainBinding) {
        val adapter = MaterialComponentsAdapter()
        binding.viewMaterialComponents.adapter = adapter
        adapter.setOnItemClickListener {
            MaterialComponentsActivity.startActivity(this@MainActivity, it)
        }
    }

    private fun initAds(adView: AdView) {
        MobileAds.initialize(this) {
        }
        adView.loadAd(
            AdRequest.Builder()
                .build()
        )
    }
}
