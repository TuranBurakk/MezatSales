package com.example.mezatsales.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemData(
    val time : String?,
    val price : String?,
    val category : String?,
    val name : String?,
    val description : String?
):Parcelable{
    constructor() : this(null,null,null,null,null)
}
