package com.example.tablayout.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OnBoardData (
   val image: Int,
   val title: String,
   val desc: String
) :Parcelable

