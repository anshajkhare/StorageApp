package com.example.kv.store.internal.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converter {
    private val gson = Gson()

    @TypeConverter
    fun fromAnyToString(value: Any?): String? {
        return value?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun fromStringToAny(value: String?): Any? {
        val type = object : TypeToken<Any>() {}.type
        return value?.let { gson.fromJson(it, type) }
    }
}
