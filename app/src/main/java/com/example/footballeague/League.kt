package com.example.footballeague

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(
    var leagueName: String?,
    var leagueDescription: String?,
    var leagueLogo: Int?
) : Parcelable