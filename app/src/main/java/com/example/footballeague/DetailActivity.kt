package com.example.footballeague

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private lateinit var name: String
    private lateinit var description: String
    private var logo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)

        val league = intent.getParcelableExtra<League>("league")

        scrollView {
            verticalLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)

                imageView {
                    setImageResource(league.leagueLogo!!)
                }.lparams {
                    height = dip(200)
                    width = dip(200)
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                textView {
                    text = league.leagueName.toString()
                    textSize = 16f
                }.lparams { margin = dip(16) }

                textView {
                    text = league.leagueDescription.toString()
                    textSize = 16f
                }.lparams { margin = dip(16) }
            }
        }

    }
}
