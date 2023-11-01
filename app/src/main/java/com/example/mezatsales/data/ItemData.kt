package com.example.mezatsales.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemData(
    val Address : String?,
    val price : String?,
    val category : String?,
    var name : String?,
    val description : String?
):Parcelable{
    constructor() : this(null,null,null,null,null)
}
