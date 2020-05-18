package com.ksw.study.gitstudy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ksw.study.gitstudy.adpater.GithubListAdapter
import com.ksw.study.gitstudy.api.GithubClient
import com.ksw.study.gitstudy.model.GithubRepo
import com.ksw.study.gitstudy.model.GithubUser
import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivity: AppCompatActivity() {

    private val LOG_TAG = "ListActivity::GitStudy"
    private val mUser: GithubUser by lazy {
        intent.getParcelableExtra<GithubUser>(ITEM_USER)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

//        val user = intent.getParcelableExtra<GithubUser>(ITEM_USER)

        setGithubUserInfo(mUser)
        Glide
            .with(this)
            .load(mUser.avatar)
            .circleCrop()
            .into(userAvatar)

        getRepo()
    }

    private fun setGithubUserInfo(user: GithubUser) {
        val sb = StringBuilder()
        sb.append("${user.name} / ")
        sb.append("${user.location} / ")
        sb.append("${user.company} / ")
        sb.append("${user.email} / ")
        sb.append("${user.bio}")
        tvGitUser.text = sb.toString()
    }

    private fun getRepo() {
        val api = GithubClient.getGithubApi()
        Log.d(LOG_TAG, "UserName : ${mUser.id}")
        api.getRepos(mUser.id).enqueue(object: Callback<List<GithubRepo>> {
            override fun onFailure(call: Call<List<GithubRepo>>, t: Throwable) {

            }
            override fun onResponse(call: Call<List<GithubRepo>>, response: Response<List<GithubRepo>>) {
                val body = response.body()
                Log.d(LOG_TAG, body.toString())

                if(body != null)
                    setRepoListview(body)
            }
        })
    }

    private fun setRepoListview(repos: List<GithubRepo>) {
        val adapter = GithubListAdapter(this)

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        adapter.setRepo(repos)
    }

}