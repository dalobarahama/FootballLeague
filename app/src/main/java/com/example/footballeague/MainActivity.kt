package com.example.footballeague

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var leagueList: ArrayList<League> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)

        showRecyclerList()
    }

    private fun showRecyclerList() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val leagueAdapter = LeagueAdapter(leagueList)
        recyclerView.adapter = leagueAdapter

        val leagueName = resources.getStringArray(R.array.league_name)
        val leagueDescription = resources.getStringArray(R.array.league_description)
        val leagueLogo = resources.obtainTypedArray(R.array.league_logo)
        leagueList.clear()
        for (i in leagueName.indices) {
            leagueList.add(
                League(
                    leagueName[i],
                    leagueDescription[i],
                    leagueLogo.getResourceId(i, 0)
                )
            )
        }

        leagueLogo.recycle()
    }

}

