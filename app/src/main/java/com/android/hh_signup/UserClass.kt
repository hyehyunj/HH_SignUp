package com.android.hh_signup

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UserClass(
    var id:String,
    val pwd:String,
    val name:String,
    val gender:String,
    val age:String
    ) : Parcelable
