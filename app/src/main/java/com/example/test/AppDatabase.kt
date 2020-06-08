package com.example.test

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ktroomexam.TodoDao

@Database(entities = [Todo::class], version = 1) // entities = [] 괄호안에 여러개 클래스넣을수있다함
abstract class AppDatabase : RoomDatabase(){
    abstract fun todoDao() : TodoDao
}