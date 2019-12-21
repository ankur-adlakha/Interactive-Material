package com.bluexpresso.materialplayground

import androidx.fragment.app.Fragment
import com.bluexpresso.materialplayground.materialcomponents.BottomAppBarsFragment
import com.bluexpresso.materialplayground.materialcomponents.BottomNavigationFragment
import com.bluexpresso.materialplayground.materialcomponents.buttons.ButtonsFragment
import com.bluexpresso.materialplayground.materialcomponents.cards.CardsFragment
import com.bluexpresso.materialplayground.materialcomponents.chips.ChipsFragment
import com.bluexpresso.materialplayground.materialcomponents.textfields.TextFieldsFragment

enum class MaterialComponents(val title: String) {
    APP_BARS_BOTTOM("App bars: bottom"),
    BOTTOM_NAVIGATION("Bottom navigation"),
    BUTTONS("Buttons"),
    CARDS("Cards"),
    CHIPS("Chips"),
    TEXT_FIELDS("Text fields");

    companion object {
        fun getNavigationForItem(componentTitle: String): Fragment {
            when (componentTitle) {
                APP_BARS_BOTTOM.title -> return BottomAppBarsFragment.newInstance()
                BOTTOM_NAVIGATION.title -> return BottomNavigationFragment.newInstance()
                BUTTONS.title -> return ButtonsFragment.newInstance()
                CARDS.title -> return CardsFragment.newInstance()
                CHIPS.title -> return ChipsFragment.newInstance()
                TEXT_FIELDS.title -> return TextFieldsFragment.newInstance()
            }
            return BottomAppBarsFragment.newInstance()
        }
    }
}