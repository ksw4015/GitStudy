package com.seokwoo.viewpager2test.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.seokwoo.viewpager2test.R

class OneFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("ViewPager2Test", "OneFragment:: onCreateView()")
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onResume() {
        super.onResume()
        Log.d("ViewPager2Test", "OneFragment:: onResume()")
    }

}