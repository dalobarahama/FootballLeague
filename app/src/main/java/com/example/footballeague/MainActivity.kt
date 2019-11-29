package com.example.footballeague

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    var items: ArrayList<League> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        verticalLayout {
            recyclerView {
                lparams(width = matchParent, height = matchParent)
                layoutManager = LinearLayoutManager(context)
                adapter = LeagueAdapter(context, items) {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("league", it)

                    startActivity(intent)

                    toast("Anda memilih ${it.leagueName}")

                }
            }
        }

        val leagueName = resources.getStringArray(R.array.league_name)
        val leagueLogo = resources.obtainTypedArray(R.array.league_logo)
        val leagueDescription = resources.getStringArray(R.array.league_description)

        items.clear()
        for (i in leagueName.indices) {
            items.add(
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

