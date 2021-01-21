package com.example.footballeague

import android.os.Parcel
import android.os.Parcelable

data class League(
    var leagueName: String?,
    var leagueDescription: String?,
    var leagueLogo: Int?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(leagueName)
        dest?.writeString(leagueDescription)
        dest?.writeValue(leagueLogo)
    }

    companion object CREATOR : Parcelable.Creator<League> {
        override fun createFromParcel(parcel: Parcel): League {
            return League(parcel)
        }

        override fun newArray(size: Int): Array<League?> {
            return arrayOfNulls(size)
        }
    }
}