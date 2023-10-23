package com.example.mezatsales.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserData(
    val userName: String? = null,
    val salesItem : List<ItemData> = emptyList()
): Parcelable {

}