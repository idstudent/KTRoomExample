package com.example.ktroomexam

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.test.Todo

@Dao // 설명안해줌
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll() : LiveData<List<Todo>>

    @Insert
    fun insert(todo : Todo)

    @Update
    fun update(todo : Todo)

    @Delete
    fun delete(todo : Todo)
}