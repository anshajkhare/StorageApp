package com.example.kv.store.internal

import android.content.Context
import com.example.kv.store.internal.repository.ObjectCacherRepository

class ObjectCacherImpl {
    val repository: ObjectCacherRepository = ObjectCacherRepository()
    lateinit var context: Context

    fun initialize(context: Context) {
        this.context = context
        repository.initialize(context)
    }

    suspend fun storeValue(key: String, value: Any) {
        repository.storeValue(key, value)
    }

    suspend fun fetchValue(key: String): Any? {
        return repository.fetchValue(key)
    }

    suspend fun deleteValue(key: String) {
        repository.deleteValue(key)
    }

    suspend fun storeInt(key: String, value: Int) {
        repository.storeInt(key, value)
    }

    suspend fun fetchInt(key: String): Int? {
        return repository.fetchInt(key)
    }

    suspend fun deleteInt(key: String) {
        repository.deleteInt(key)
    }

    suspend fun storeBoolean(key: String, value: Boolean) {
        repository.storeBoolean(key, value)
    }

    suspend fun fetchBoolean(key: String): Boolean? {
        return repository.fetchBoolean(key)
    }

    suspend fun deleteBoolean(key: String) {
        repository.deleteBoolean(key)
    }

    suspend fun storeString(key: String, value: String) {
        repository.storeString(key, value)
    }

    suspend fun fetchString(key: String): String? {
        return repository.fetchString(key)
    }

    suspend fun deleteString(key: String) {
        repository.deleteString(key)
    }
}