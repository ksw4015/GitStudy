package com.seokwoo.archsample.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.seokwoo.archsample.api.PostService
import com.seokwoo.archsample.datasource.PostDataSourceFactory
import com.seokwoo.archsample.model.Post

class PostViewModel: ViewModel() {

    private lateinit var postDataSourceFactory: PostDataSourceFactory
    private lateinit var postData: LiveData<PagedList<Post>>

    fun load(postService: PostService) {
        postDataSourceFactory = PostDataSourceFactory(postService)
        postData = LivePagedListBuilder(postDataSourceFactory, 10).build()   // size per page
    }

    fun getPosts(): LiveData<PagedList<Post>> = postData

}