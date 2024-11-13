package com.example.kv.store.internal

import android.content.Context
import com.example.kv.store.internal.repository.ObjectCacherRepository

class ObjectCacherImpl(private val repository: ObjectCacherRepository = ObjectCacherRepository()) {
    private lateinit var context: Context

    fun initialize(context: Context) {
        this.context = context
        repository.initialize(context)
    }

    suspend fun storeValue(key: String, value: Any): Boolean {
        return repository.storeValue(key, value)
    }

    suspend fun fetchValue(key: String): Any? {
        return repository.fetchValue(key)
    }

    suspend fun deleteValue(key: String): Boolean {
        return repository.deleteValue(key)
    }

    suspend fun storeInt(key: String, value: Int): Boolean {
        return repository.storeInt(key, value)
    }

    suspend fun fetchInt(key: String): Int? {
        return repository.fetchInt(key)
    }

    suspend fun deleteInt(key: String): Boolean {
        return repository.deleteInt(key)
    }

    suspend fun storeBoolean(key: String, value: Boolean): Boolean {
        return repository.storeBoolean(key, value)
    }

    suspend fun fetchBoolean(key: String): Boolean? {
        return repository.fetchBoolean(key)
    }

    suspend fun deleteBoolean(key: String): Boolean {
        return repository.deleteBoolean(key)
    }

    suspend fun storeString(key: String, value: String): Boolean {
        return repository.storeString(key, value)
    }

    suspend fun fetchString(key: String): String? {
        return repository.fetchString(key)
    }

    suspend fun deleteString(key: String): Boolean {
        return repository.deleteString(key)
    }
}