package com.bluexpresso.materialplayground

import androidx.fragment.app.Fragment
import com.bluexpresso.materialplayground.materialcomponents.BottomAppBarsFragment

enum class MaterialComponents(val title: String) {
    APP_BARS_BOTTOM("App bars: bottom");

    companion object {
        fun getNavigationForItem(componentTitle: String): Fragment {
            when (componentTitle) {
                APP_BARS_BOTTOM.title -> return BottomAppBarsFragment.newInstance()
            }
            return BottomAppBarsFragment.newInstance()
        }
    }
}