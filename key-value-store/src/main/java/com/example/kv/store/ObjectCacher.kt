package com.example.kv.store

import android.content.Context
import com.example.kv.store.internal.ObjectCacherImpl

object ObjectCacher {
    val impl: ObjectCacherImpl = ObjectCacherImpl()
    var isInitialized = false

    fun initialize(context: Context) {
        if (isInitialized) return
        isInitialized = true
        impl.initialize(context)
    }

    suspend fun storeValue(key: String, value: Any): Boolean {
        return if (isInitialized) impl.storeValue(key, value)
        else false
    }

    suspend fun fetchValue(key: String): Any? {
        return if (isInitialized) impl.fetchValue(key)
        else null
    }

    suspend fun deleteValue(key: String) {
        if (isInitialized) impl.deleteValue(key)
    }

    suspend fun storeInt(key: String, value: Int): Boolean {
        return if (isInitialized) impl.storeInt(key, value)
        else false
    }

    suspend fun fetchInt(key: String): Int? {
        return if (isInitialized) impl.fetchInt(key)
        else null
    }

    suspend fun deleteInt(key: String): Boolean {
        return if (isInitialized) impl.deleteInt(key)
        else false
    }

    suspend fun storeBoolean(key: String, value: Boolean): Boolean {
        return if (isInitialized) impl.storeBoolean(key, value)
        else false
    }

    suspend fun fetchBoolean(key: String): Boolean? {
        return if (isInitialized) impl.fetchBoolean(key)
        else null
    }

    suspend fun deleteBoolean(key: String): Boolean {
        return if (isInitialized) impl.deleteBoolean(key)
        else false
    }

    suspend fun storeString(key: String, value: String): Boolean {
        return if (isInitialized) impl.storeString(key, value)
        else false
    }

    suspend fun fetchString(key: String): String? {
        return if (isInitialized) impl.fetchString(key)
        else null
    }

    suspend fun deleteString(key: String): Boolean {
        return if (isInitialized) impl.deleteString(key)
        else false
    }
}