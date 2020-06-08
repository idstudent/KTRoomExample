package com.example.ktroomexam

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.test.Todo

@Dao // 설명안해줌
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll() : LiveData<List<Todo>>

    @Insert
    suspend fun insert(todo : Todo)

    @Update
    suspend fun update(todo : Todo)

    @Delete
    suspend fun delete(todo : Todo)
}