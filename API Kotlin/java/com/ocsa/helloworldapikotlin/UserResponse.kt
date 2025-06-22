package com.ocsa.helloworldapikotlin

import com.google.gson.annotations.SerializedName

data class UserResponse(

    @SerializedName("users")
    val users: List<User>
)
