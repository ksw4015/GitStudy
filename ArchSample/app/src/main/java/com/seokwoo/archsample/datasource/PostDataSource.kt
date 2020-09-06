package com.seokwoo.archsample.datasource

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.seokwoo.archsample.api.PostService
import com.seokwoo.archsample.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

/**
 * Network data source
 */
class PostDataSource(private val postService: PostService): PageKeyedDataSource<Int, Post>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Post>) {
        val request = postService.getTopPost()
        try {
            request.enqueue(object : Callback<List<Post>> {  // execute: sync, enqueue: async
                override fun onFailure(call: Call<List<Post>>, t: Throwable) {

                }
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    callback.onResult(response.body()!!, null, 1)
                }
            })
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Post>) {
        val request = postService.getPost(params.key)   // nextPageKey
        try {
            request.enqueue(object : Callback<List<Post>> {
                override fun onFailure(call: Call<List<Post>>, t: Throwable) {

                }
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    callback.onResult(response.body()!!,params.key + 1)
                }
            })
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Post>) {
        TODO("Not yet implemented")
    }

}

class PostDataSourceFactory(private val postService: PostService): DataSource.Factory<Int, Post>() {
    override fun create(): DataSource<Int, Post> {
        return PostDataSource(postService)
    }
}