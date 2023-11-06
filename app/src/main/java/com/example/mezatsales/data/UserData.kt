package com.example.mezatsales.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserData(
    var userName: String? = "",
    var salesItem : List<ItemData?>? = emptyList()
): Parcelable {

}