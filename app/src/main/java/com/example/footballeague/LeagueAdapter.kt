package com.example.footballeague

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class LeagueAdapter(private val listLeague: List<League>) :
    RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.league_item, parent, false)
        return LeagueViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        val league = listLeague[position]

        holder.leagueName.text = league.leagueName

        Glide.with(holder.itemView.context)
            .load(league.leagueLogo)
            .into(holder.leagueLogo)

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(league) }
    }

    override fun getItemCount(): Int {
        return listLeague.size
    }


    inner class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val leagueName: TextView = itemView.findViewById(R.id.league_name)
        val leagueLogo: ImageView = itemView.findViewById(R.id.league_image)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: League)
    }
}