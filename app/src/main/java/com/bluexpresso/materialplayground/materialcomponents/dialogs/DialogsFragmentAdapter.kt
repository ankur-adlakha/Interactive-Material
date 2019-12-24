package com.bluexpresso.materialplayground.materialcomponents.dialogs

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bluexpresso.materialplayground.R

class DialogsFragmentAdapter(var fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int) =
        when (position) {
            0 -> DialogTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.alert_dialog
                )
            )
            1 -> DialogTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.simple_dialog
                )
            )
            2 -> DialogTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.confirmation_dialog
                )
            )
            else -> DialogTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.alert_dialog
                )
            )
        }
}