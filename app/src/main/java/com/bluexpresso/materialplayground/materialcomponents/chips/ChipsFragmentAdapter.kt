package com.bluexpresso.materialplayground.materialcomponents.chips

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.materialcomponents.buttons.ButtonTypesFragment

class ChipsFragmentAdapter(var fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int) =
        when (position) {
            0 -> ChipTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.entry_chip
                )
            )
            1 -> ChipTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.filter_chip
                )
            )
            else -> ChipTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.entry_chip
                )
            )
        }
}