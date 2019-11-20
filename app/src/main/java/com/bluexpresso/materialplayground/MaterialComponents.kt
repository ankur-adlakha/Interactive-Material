package com.bluexpresso.materialplayground

import androidx.fragment.app.Fragment
import com.bluexpresso.materialplayground.materialcomponents.BottomAppBarsFragment
import com.bluexpresso.materialplayground.materialcomponents.BottomNavigationFragment
import com.bluexpresso.materialplayground.materialcomponents.buttons.ButtonsFragment

enum class MaterialComponents(val title: String) {
    APP_BARS_BOTTOM("App bars: bottom"),
    BOTTOM_NAVIGATION("Bottom Navigation"),
    BUTTONS("Buttons");

    companion object {
        fun getNavigationForItem(componentTitle: String): Fragment {
            when (componentTitle) {
                APP_BARS_BOTTOM.title -> return BottomAppBarsFragment.newInstance()
                BOTTOM_NAVIGATION.title -> return BottomNavigationFragment.newInstance()
                BUTTONS.title -> return ButtonsFragment.newInstance()
            }
            return BottomAppBarsFragment.newInstance()
        }
    }
}