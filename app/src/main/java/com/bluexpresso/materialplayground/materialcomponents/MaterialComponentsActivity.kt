package com.bluexpresso.materialplayground.materialcomponents

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bluexpresso.materialplayground.MaterialComponents
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.ActivityMaterialComponentsBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MaterialComponentsActivity : AppCompatActivity() {
    companion object {
        const val ARG_COMPONENT_TITLE = "component_title"
        fun startActivity(context: Context, componentTitle: String) {
            context.startActivity(Intent(context, MaterialComponentsActivity::class.java).apply {
                putExtra(ARG_COMPONENT_TITLE, componentTitle)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView(this,
            R.layout.activity_material_components)
                as ActivityMaterialComponentsBinding
        if (savedInstanceState == null && intent.extras != null) {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(
                R.id.fragment_container, MaterialComponents.getNavigationForItem(
                    intent.extras!!.getString(
                        ARG_COMPONENT_TITLE,
                        MaterialComponents.APP_BARS_BOTTOM.title
                    )
                )
            ).commit()
        }
        initAds(binding.adView)
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