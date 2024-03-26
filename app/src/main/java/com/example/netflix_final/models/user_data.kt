package com.example.netflix_final.models

import com.example.netflix_final.R

data class UserModel(val name: String, val profile: Int)

val userList: MutableList<UserModel> = mutableListOf(
    UserModel("Sophal", R.drawable.sophal),
    UserModel("Kimheak", R.drawable.kimheak),
    UserModel("Nidate", R.drawable.nidate),
    UserModel("Sarah", R.drawable.sarah),
    UserModel("Kids", R.drawable.kids),
)

var loggedInUser: UserModel = userList[1]