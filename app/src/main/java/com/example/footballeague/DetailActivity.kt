package com.example.footballeague

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var description: TextView
    private lateinit var logo: ImageView

    companion object {
        const val LEAGUE_DATA = "league_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        name = findViewById(R.id.league_name)
        description = findViewById(R.id.league_description)
        logo = findViewById(R.id.league_image)

        val league: League = intent.getParcelableExtra(LEAGUE_DATA) as League
        name.text = league.leagueName
        description.text = league.leagueDescription
        Glide.with(this)
            .load(league.leagueLogo)
            .into(logo)

    }
}
