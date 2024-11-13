package com.example.kv.store.internal.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ObjectModel(
    @PrimaryKey val key: String,
    @ColumnInfo(name = "value") val value: String
)
