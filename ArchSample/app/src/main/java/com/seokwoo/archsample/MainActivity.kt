package com.seokwoo.archsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seokwoo.archsample.adapter.PostAdapter
import com.seokwoo.archsample.api.JsonPostClient
import com.seokwoo.archsample.model.Post
import com.seokwoo.archsample.ui.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PostViewModel
    private val viewModelFactory by lazy {
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)
    }
    private val adapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, viewModelFactory).get(PostViewModel::class.java)
        viewModel.load(JsonPostClient.getPostService())

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        viewModel.getPosts().observe(this, Observer<PagedList<Post>> {
            adapter.submitList(it)
        })

    }
}