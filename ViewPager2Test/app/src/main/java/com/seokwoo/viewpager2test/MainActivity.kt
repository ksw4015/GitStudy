package com.seokwoo.viewpager2test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.seokwoo.viewpager2test.adpater.MyViewPager2Adpater
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2.adapter = MyViewPager2Adpater(this)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager2.offscreenPageLimit = 2

        TabLayoutMediator(tabLayout, viewPager2, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            when(position) {
                0 -> tab.text = "ONE"
                1 -> tab.text = "TWO"
            }
        }).attach()
    }
}