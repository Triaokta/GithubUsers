package com.tria.github.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tria.github.R
import com.tria.github.data.local.entity.UserEntity


class ItemAdapter(private var list: List<UserEntity>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.github_user_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivAvatar: ImageView = itemView.findViewById(R.id.ivAvatar)
        val tvUName: TextView = itemView.findViewById(R.id.tvUName)
        val ivFav: ImageView = itemView.findViewById(R.id.ivFav)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = list[position]
        holder.tvUName.text = user.login
        Glide.with(holder.itemView.context)
            .load(user.avatarUrl)
            .into(holder.ivAvatar)

        holder.ivFav.visibility = View.VISIBLE

        val isFavorite = user.isFavorite

        if (isFavorite) {
            holder.ivFav.setImageResource(R.drawable.fav)
        } else {
            holder.ivFav.setImageResource(R.drawable.fav_bd)
        }

        holder.itemView.setOnClickListener {
            Log.d("GithubUserItemAdapter", "onBindViewHolder: ${list[position].login}")
            onItemClickCallback.onItemClicked(list[position].login.toString())
        }

        holder.ivFav.setOnClickListener {
            Log.d("GithubUserItemAdapter", "onFavoriteClicked")
            onItemClickCallback.onFavoriteClicked(list[position])
        }

    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: String)
        fun onFavoriteClicked(user: UserEntity)
    }

    override fun getItemCount(): Int = list.size

}