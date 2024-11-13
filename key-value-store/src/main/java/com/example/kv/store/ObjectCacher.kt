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

    suspend fun storeValue(key: String, value: Any) {
        if (isInitialized) impl.storeValue(key, value)
    }

    suspend fun fetchValue(key: String): Any? {
        return if (isInitialized) impl.fetchValue(key)
        else null
    }

    suspend fun deleteValue(key: String) {
        if (isInitialized) impl.deleteValue(key)
    }

    suspend fun storeInt(key: String, value: Int) {
        if (isInitialized) impl.storeInt(key, value)
    }

    suspend fun fetchInt(key: String): Int? {
        return if (isInitialized) impl.fetchInt(key)
        else null
    }

    suspend fun deleteInt(key: String) {
        if (isInitialized) impl.deleteInt(key)
    }

    suspend fun storeBoolean(key: String, value: Boolean) {
        if (isInitialized) impl.storeBoolean(key, value)
    }

    suspend fun fetchBoolean(key: String): Boolean? {
        return if (isInitialized) impl.fetchBoolean(key)
        else null
    }

    suspend fun deleteBoolean(key: String) {
        if (isInitialized) impl.deleteBoolean(key)
    }

    suspend fun storeString(key: String, value: String) {
        if (isInitialized) impl.storeString(key, value)
    }

    suspend fun fetchString(key: String): String? {
        return if (isInitialized) impl.fetchString(key)
        else null
    }

    suspend fun deleteString(key: String) {
        if (isInitialized) impl.deleteString(key)
    }
}