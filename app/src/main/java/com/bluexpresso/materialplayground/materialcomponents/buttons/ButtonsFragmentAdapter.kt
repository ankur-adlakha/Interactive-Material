package com.bluexpresso.materialplayground.materialcomponents.buttons

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bluexpresso.materialplayground.R

class ButtonsFragmentAdapter(var fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int) =
        when (position) {
            0 -> ButtonTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.outlined_button
                )
            )
            1 -> ButtonTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.unelevated_button
                )
            )
            2 -> ButtonTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.text_button
                )
            )
            else -> ButtonTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.outlined_button
                )
            )
        }
}