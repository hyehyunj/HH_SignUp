package com.android.hh_signup

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UserClass(
    var id:String,
    var pwd:String,
    var name:String,
    var gender:String,
    var age:String
    ) : Parcelable
