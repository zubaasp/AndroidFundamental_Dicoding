package com.zuba.subs2jadi.data

data class UserResponse(
    var items: ArrayList<User>,
    val incomplete_result: Boolean
)
