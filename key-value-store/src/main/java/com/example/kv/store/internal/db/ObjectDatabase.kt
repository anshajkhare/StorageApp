package com.example.kv.store.internal.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kv.store.internal.data.Converter
import com.example.kv.store.internal.data.ObjectModel

@Database(entities = [ObjectModel::class], version = 1)
@TypeConverters(Converter::class)
abstract class ObjectDatabase: RoomDatabase() {
    abstract fun objectDao(): ObjectDao
}