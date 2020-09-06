package com.seokwoo.archsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.seokwoo.archsample.R
import com.seokwoo.archsample.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(): PagedListAdapter<Post, RecyclerView.ViewHolder>(POST_COMPARATOR) {

    inner class PostViewHolder(v: View): RecyclerView.ViewHolder(v) {
        fun bindItem(item: Post) {
            itemView.tv_title.text = item.title
            itemView.tv_body.text = item.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent,false)
        return PostViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val postItem = getItem(position)   // PageListAdapter method
        if(postItem != null)
            (holder as PostViewHolder).bindItem(postItem)
    }

    companion object {
        private val POST_COMPARATOR = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean =
                oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean =
                oldItem == newItem
        }
    }

}