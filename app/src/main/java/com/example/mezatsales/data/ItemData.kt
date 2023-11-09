package com.example.mezatsales.data

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemData(
    var Address : String? = null,
    var price : String? = null,
    var category : String? = null,
    var name : String? = null,
    var description : String? = null,
    var imageUri : String? = null
):Parcelable
