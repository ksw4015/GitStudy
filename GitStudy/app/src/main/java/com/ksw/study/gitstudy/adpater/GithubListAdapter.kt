package com.ksw.study.gitstudy.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ksw.study.gitstudy.R
import com.ksw.study.gitstudy.model.GithubRepo
import kotlinx.android.synthetic.main.item_github.view.*

class GithubListAdapter(val mContext: Context): RecyclerView.Adapter<GithubListAdapter.GithubHolder>() {

    private var mList = emptyList<GithubRepo>()

    inner class GithubHolder(v: View): RecyclerView.ViewHolder(v) {
        fun bindItem(item: GithubRepo) {
            // itemView
            itemView.gitRepoName.text = item.name
            itemView.gitRepoCreated.text = item.created
            itemView.gitRepoDesc.text = item.desc

            itemView.setOnClickListener {

            }
        }
    }

    override fun getItemCount(): Int = mList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_github, parent, false)
        return GithubHolder(v)
    }

    override fun onBindViewHolder(holder: GithubHolder, position: Int) {
        holder.bindItem(mList[position])
    }

    private fun setRepo(list: List<GithubRepo>) {
        mList = list
    }

}