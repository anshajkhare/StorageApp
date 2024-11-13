# Key-Value Store Module

This repository contains an Android project with a sample app and a reusable module, `key-value-store`, which provides functionality to store, retrieve, and delete key-value pairs of different data types. The main interface for accessing this functionality is through the `ObjectCacher` class.
## Overview

The key-value-store module offers a simple way to cache objects by associating them with a string key, allowing you to store and retrieve various data types (e.g., `Int`, `Boolean`, String, and general `Any` types) persistently across app sessions.
## Setup

### 1. Installation
Clone the repository and add the key-value-store module to your Android project.
### 2. Initialization
Before using any of the caching functions, you need to initialize the `ObjectCacher`:
```
ObjectCacher.initialize(context)
```
### 3. Usage
Once initialized, you can use the various methods to store, fetch, and delete data by key.
### Methods
The following methods are available in `ObjectCacher`:
#### General Object Storage
- `storeValue(key: String, value: Any): Boolean` Stores a value of any type.
- `fetchValue(key: String): Any?` Fetches a previously stored value.
- `deleteValue(key: String)` Deletes a stored value.

#### Type-Specific Storage
The module also provides methods to store and retrieve values of specific types, including Int, Boolean, and String.
- `storeInt(key: String, value: Int): Boolean` Stores an integer value.
- `fetchInt(key: String): Int?` Fetches an integer value.
- `deleteInt(key: String): Boolean` Deletes a stored integer value.
- `storeBoolean(key: String, value: Boolean): Boolean` Stores a boolean value.
- `fetchBoolean(key: String): Boolean?` Fetches a boolean value.
- `deleteBoolean(key: String): Boolean` Deletes a stored boolean value.
- `storeString(key: String, value: String): Boolean` Stores a string value.
- `fetchString(key: String): String?` Fetches a string value.
- `deleteString(key: String): Boolean` Deletes a stored string value.

#### Example
```
// Initialize the ObjectCacher
ObjectCacher.initialize(context)

// Store values
ObjectCacher.storeString("username", "JohnDoe")
ObjectCacher.storeInt("userId", 12345)
ObjectCacher.storeBoolean("isLoggedIn", true)

// Fetch values
val username = ObjectCacher.fetchString("username")
val userId = ObjectCacher.fetchInt("userId")
val isLoggedIn = ObjectCacher.fetchBoolean("isLoggedIn")

// Delete values
ObjectCacher.deleteString("username")
ObjectCacher.deleteInt("userId")
ObjectCacher.deleteBoolean("isLoggedIn")
```

#### Notes

Ensure that `ObjectCacher` is initialized before calling any storage methods; otherwise, the methods will return default values (false, null, etc.).
The module is designed to handle different data types separately to ensure type safety.
