package com.example.kv.store.internal.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kv.store.internal.data.ObjectModel

@Dao
interface ObjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: ObjectModel)

    @Query("SELECT * FROM ObjectModel WHERE `key` LIKE (:key)")
    suspend fun getData(key: String): ObjectModel?

    @Query("DELETE FROM ObjectModel WHERE `key` = :key")
    suspend fun delete(key: String): Int
}