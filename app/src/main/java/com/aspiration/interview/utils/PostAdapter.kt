package com.aspiration.interview.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aspiration.interview.R
import com.aspiration.interview.domain.PostEntity

class PostAdapter(private val data: List<PostEntity> ):
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.count()

    /*
    class ViewHolder(parent: ViewGroup) :
         RecyclerView.ViewHolder(LayoutInflater.from(parent.context)
             .inflate(com.marcrobito.amtest.R.layout.movie_view_holder, parent, false)) {

     */

    inner class ViewHolder(itemView: ViewGroup):
        RecyclerView.ViewHolder(LayoutInflater.from(itemView.context)
            .inflate(R.layout.item_post, itemView, false)){

        fun bind(item: PostEntity)  {
            val titleTextView: TextView = itemView.findViewById(R.id.title)
            val bodyTextView: TextView = itemView.findViewById(R.id.body)
            with(item){
                titleTextView.text = title
                bodyTextView.text = body
            }
        }

    }
}