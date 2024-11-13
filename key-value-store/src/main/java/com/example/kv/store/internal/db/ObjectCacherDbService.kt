package com.example.kv.store.internal.db

import android.content.Context
import androidx.room.Room
import com.example.kv.store.internal.data.Converter
import com.example.kv.store.internal.data.ObjectModel

class ObjectCacherDbService {
    lateinit var db: ObjectDatabase
    lateinit var objectDao: ObjectDao

    fun initialize(context: Context) {
        db = Room.databaseBuilder(
            context,
            ObjectDatabase::class.java, "objects"
        ).build()

        objectDao = db.objectDao()
    }

    suspend fun storeValue(key: String, value: Any): Boolean {
        return try {
            val serializedValue = Converter.fromAnyToString(value)
            objectDao.insert(ObjectModel(key, serializedValue ?: ""))
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun fetchValue(key: String): Any? {
        val serializedValue = objectDao.getData(key)?.value
        return serializedValue?.let { Converter.fromStringToAny(it) }
    }

    suspend fun deleteValue(key: String): Boolean {
        var deleted = objectDao.delete(key)
        return deleted > 0
    }
}