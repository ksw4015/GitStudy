package com.seokwoo.viewpager2test.adpater

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.seokwoo.viewpager2test.fragment.ErrorFragment
import com.seokwoo.viewpager2test.fragment.OneFragment
import com.seokwoo.viewpager2test.fragment.TwoFragment

class MyViewPager2Adpater(fa: FragmentActivity): FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment =
        when(position) {
            0 -> OneFragment()
            1 -> TwoFragment()
            else -> ErrorFragment()
        }

    override fun getItemCount(): Int = 2

}