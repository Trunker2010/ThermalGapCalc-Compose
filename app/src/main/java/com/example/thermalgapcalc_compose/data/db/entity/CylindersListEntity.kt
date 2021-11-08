package com.example.thermalgapcalc_compose.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CylindersListEntity(
    @PrimaryKey
    val id: String,
    val listJson: String
)