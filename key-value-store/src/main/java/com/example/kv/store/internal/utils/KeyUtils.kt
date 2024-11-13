package com.example.kv.store.internal.utils

object KeyUtils {
    fun getIntKey(key: String) = "${key}_int"
    fun getBooleanKey(key: String) = "${key}_bool"
    fun getStringKey(key: String) = "${key}_string"
}