package com.bluexpresso.materialplayground.materialcomponents.textfields

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bluexpresso.materialplayground.R

class TextFieldsFragmentAdapter(var fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int) =
        when (position) {
            0 -> TextFieldTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.textinput_filled
                )
            )
            1 -> TextFieldTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.textinput_outlined
                )
            )
            else -> TextFieldTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.textinput_filled
                )
            )
        }
}