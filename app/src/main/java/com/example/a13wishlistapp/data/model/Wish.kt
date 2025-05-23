package com.example.a13wishlistapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//data class Wish(
//    val id: Long = 0L,
//    val title: String,
//    val description: String
//)

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "wish-title")
    val title: String,

    @ColumnInfo(name = "wish-desc")
    val description: String
)
