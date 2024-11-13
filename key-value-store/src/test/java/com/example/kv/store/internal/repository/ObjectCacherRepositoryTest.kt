package com.example.kv.store.internal.repository

import com.example.kv.store.internal.db.ObjectCacherDbService
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class ObjectCacherRepositoryTest {
    @Mock
    private lateinit var dbService: ObjectCacherDbService
    private lateinit var repository: ObjectCacherRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = ObjectCacherRepository(dbService)
    }

    @Test
    fun `storeValue saves to cache and DB and returns true`() {
        runBlocking {
            val key = "key"
            val value = Any()

            `when`(dbService.storeValue(key, value)).thenReturn(true)

            val result = repository.storeValue(key, value)

            assertTrue(result)
            assertEquals(value, repository.fetchValue(key))
            verify(dbService).storeValue(key, value)
        }
    }

    @Test
    fun `fetchValue returns cached value without calling DB`() {
        runBlocking {
            val key = "key"
            val value = Any()
            repository.storeValue(key, value)

            val fetchedValue = repository.fetchValue(key)

            assertEquals(value, fetchedValue)
            verify(dbService).storeValue(key, value)
            verifyNoMoreInteractions(dbService)
        }
    }

    @Test
    fun `fetchValue calls DB if not in cache`() {
        runBlocking {
            val key = "key"
            val value = Any()

            `when`(dbService.fetchValue(key)).thenReturn(value)

            val fetchedValue = repository.fetchValue(key)

            assertEquals(value, fetchedValue)
            verify(dbService).fetchValue(key)
        }
    }

    @Test
    fun `deleteValue removes from cache and DB`() {
        runBlocking {
            val key = "deleteKey"
            val value = "deleteValue"

            repository.storeValue(key, value)
            `when`(dbService.deleteValue(key)).thenReturn(true)

            val result = repository.deleteValue(key)

            assertTrue(result)
            assertNull(repository.fetchValue(key))
            verify(dbService).deleteValue(key)
        }
    }
}