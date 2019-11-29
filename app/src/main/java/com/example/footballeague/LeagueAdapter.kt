package com.example.footballeague

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class LeagueAdapter(
    private val context: Context,
    private val items: List<League>,
    private val listener: (League) -> Unit
) :
    RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {

    class LeagueUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                verticalLayout {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = R.id.imageViewId
                    }.lparams {
                        height = dip(70)
                        width = dip(70)
                    }

                    textView {
                        id = R.id.textViewId
                        textSize = 16f
                    }.lparams { margin = dip(16) }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder(
            LeagueUI().createView(
                AnkoContext.Companion.create(
                    parent.context,
                    parent
                )
            )
        )
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val leagueName: TextView = itemView.find(R.id.textViewId)
        private val leagueLogo: ImageView = itemView.find(R.id.imageViewId)

        fun bindItem(items: League) {
            Glide.with(itemView.context)
                .load(items.leagueLogo)
                .into(leagueLogo)

            leagueName.text = items.leagueName

            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}