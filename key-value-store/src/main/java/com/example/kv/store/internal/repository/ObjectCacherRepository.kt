package com.example.kv.store.internal.repository

import android.content.Context
import com.example.kv.store.internal.db.ObjectCacherDbService
import com.example.kv.store.internal.utils.KeyUtils
import java.util.concurrent.ConcurrentHashMap

class ObjectCacherRepository(private val dbService: ObjectCacherDbService = ObjectCacherDbService()) {
    private val cache: MutableMap<String, Any> = ConcurrentHashMap()
    private val cacheInt: MutableMap<String, Int> = ConcurrentHashMap()
    private val cacheBool: MutableMap<String, Boolean> = ConcurrentHashMap()
    private val cacheString: MutableMap<String, String> = ConcurrentHashMap()

    fun initialize(context: Context) {
        dbService.initialize(context)
    }

    suspend fun storeValue(key: String, value: Any): Boolean {
        cache[key] = value
        return dbService.storeValue(key, value)
    }

    suspend fun fetchValue(key: String): Any? {
        return cache[key] ?: dbService.fetchValue(key)?.also { cache[key] = it }
    }

    suspend fun deleteValue(key: String): Boolean {
        cache.remove(key)
        return dbService.deleteValue(key)
    }

    suspend fun storeInt(key: String, value: Int): Boolean {
        cacheInt[key] = value
        return dbService.storeValue(KeyUtils.getIntKey(key), value)
    }

    suspend fun fetchInt(key: String): Int? {
        return cacheInt[key]
            ?: (dbService.fetchValue(KeyUtils.getIntKey(key)) as Int?)?.also { cacheInt[key] = it }
    }

    suspend fun deleteInt(key: String): Boolean {
        cacheInt.remove(key)
        return dbService.deleteValue(KeyUtils.getIntKey(key))
    }

    suspend fun storeBoolean(key: String, value: Boolean): Boolean {
        cacheBool[key] = value
        return dbService.storeValue(KeyUtils.getBooleanKey(key), value)
    }

    suspend fun fetchBoolean(key: String): Boolean? {
        return cacheBool[key]
            ?: (dbService.fetchValue(KeyUtils.getBooleanKey(key)) as Boolean?)?.also {
                cacheBool[key] = it
            }
    }

    suspend fun deleteBoolean(key: String): Boolean {
        cacheBool.remove(key)
        return dbService.deleteValue(KeyUtils.getBooleanKey(key))
    }

    suspend fun storeString(key: String, value: String): Boolean {
        cacheString[key] = value
        return dbService.storeValue(KeyUtils.getStringKey(key), value)
    }

    suspend fun fetchString(key: String): String? {
        return cacheString[key]
            ?: (dbService.fetchValue(KeyUtils.getStringKey(key)) as String?)?.also {
                cacheString[key] = it
            }
    }

    suspend fun deleteString(key: String): Boolean {
        cacheString.remove(key)
        return dbService.deleteValue(KeyUtils.getStringKey(key))
    }
}