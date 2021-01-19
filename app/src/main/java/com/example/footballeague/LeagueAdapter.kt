package com.example.footballeague

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.jetbrains.anko.find

class LeagueAdapter(private val listLeague: List<League>) :
    RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {

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
    }

    override fun getItemCount(): Int {
        return listLeague.size
    }


    inner class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val leagueName: TextView = itemView.find(R.id.league_name)
        val leagueLogo: ImageView = itemView.find(R.id.league_image)
    }
}