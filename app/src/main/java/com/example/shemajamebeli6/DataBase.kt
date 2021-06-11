package com.example.shemajamebeli6

import androidx.room.Room
import com.example.shemajamebeli6.App.Companion.context

object DataBase {
    val db = Room.databaseBuilder(
        context!!,
        AppDatabase::class.java, "database-name"
    ).build()
}