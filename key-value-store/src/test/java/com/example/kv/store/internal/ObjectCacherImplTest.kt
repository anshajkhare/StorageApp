package com.example.kv.store.internal

import com.example.kv.store.internal.repository.ObjectCacherRepository
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class ObjectCacherImplTest {
    @Mock
    private lateinit var repository: ObjectCacherRepository
    private lateinit var cacherImpl: ObjectCacherImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        cacherImpl = ObjectCacherImpl(repository)
    }

    @Test
    fun `storeValue calls repository and returns true on success`() {
        runBlocking {
            val key = "key"
            val value = Any()

            `when`(repository.storeValue(key, value)).thenReturn(true)

            val result = cacherImpl.storeValue(key, value)

            assertTrue(result)
            verify(repository).storeValue(key, value)
        }
    }

    @Test
    fun `fetchValue fetches value from repository`() {
        runBlocking {
            val key = "key"
            val value = Any()

            `when`(repository.fetchValue(key)).thenReturn(value)

            val fetchedValue = cacherImpl.fetchValue(key)

            assertEquals(value, fetchedValue)
            verify(repository).fetchValue(key)
        }
    }

    @Test
    fun `deleteValue calls repository returns true on success`() {
        runBlocking {
            val key = "key"

            `when`(repository.deleteValue(key)).thenReturn(true)

            val result = cacherImpl.deleteValue(key)

            assertTrue(result)
            verify(repository).deleteValue(key)
        }
    }

    @Test
    fun `storeInt calls repository and returns true on success`() {
        runBlocking {
            val key = "key"
            val value = 123

            `when`(repository.storeInt(key, value)).thenReturn(true)

            val result = cacherImpl.storeInt(key, value)

            assertTrue(result)
            verify(repository).storeInt(key, value)
        }
    }

    @Test
    fun `fetchInt fetches value from repository`() {
        runBlocking {
            val key = "key"
            val value = 456

            `when`(repository.fetchInt(key)).thenReturn(value)

            val fetchedValue = cacherImpl.fetchInt(key)

            assertEquals(value, fetchedValue)
            verify(repository).fetchInt(key)
        }
    }

    @Test
    fun `deleteInt calls repository returns true on success`() {
        runBlocking {
            val key = "key"

            `when`(repository.deleteInt(key)).thenReturn(true)

            val result = cacherImpl.deleteInt(key)

            assertTrue(result)
            verify(repository).deleteInt(key)
        }
    }

    @Test
    fun `storeBoolean calls repository and returns true on success`() {
        runBlocking {
            val key = "key"
            val value = true

            `when`(repository.storeBoolean(key, value)).thenReturn(true)

            val result = cacherImpl.storeBoolean(key, value)
            assertTrue(result)
            verify(repository).storeBoolean(key, value)
        }
    }

    @Test
    fun `fetchBoolean fetches value from repository`() {
        runBlocking {
            val key = "key"
            val value = true

            `when`(repository.fetchBoolean(key)).thenReturn(value)

            val fetchedValue = cacherImpl.fetchBoolean(key)

            assertEquals(value, fetchedValue)
            verify(repository).fetchBoolean(key)
        }
    }

    @Test
    fun `deleteBoolean calls repository returns true on success`() {
        runBlocking {
            val key = "key"

            `when`(repository.deleteBoolean(key)).thenReturn(true)

            val result = cacherImpl.deleteBoolean(key)

            assertTrue(result)
            verify(repository).deleteBoolean(key)
        }
    }

    @Test
    fun `storeString calls repository and returns true on success`() {
        runBlocking {
            val key = "key"
            val value = "value"

            `when`(repository.storeString(key, value)).thenReturn(true)

            val result = cacherImpl.storeString(key, value)

            assertTrue(result)
            verify(repository).storeString(key, value)
        }
    }

    @Test
    fun `fetchString fetches value from repository`() {
        runBlocking {
            val key = "key"
            val value = "value"

            `when`(repository.fetchString(key)).thenReturn(value)

            val fetchedValue = cacherImpl.fetchString(key)

            assertEquals(value, fetchedValue)
            verify(repository).fetchString(key)
        }
    }

    @Test
    fun `deleteString calls repository returns true on success`() {
        runBlocking {
            val key = "key"

            `when`(repository.deleteString(key)).thenReturn(true)

            val result = cacherImpl.deleteString(key)

            assertTrue(result)
            verify(repository).deleteString(key)
        }
    }
}