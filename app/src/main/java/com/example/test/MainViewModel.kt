package com.example.test

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainViewModel(application : Application) : AndroidViewModel(application){

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "todo-db" // todo-db는 db이름 임의로 지정
    )
//            .allowMainThreadQueries() // 메인쓰레드에서도 하도록 함 실무에서는 백그라운드 쓰레드에서 하니 잘안쓴다고함
        .build()

    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    //suspend를 쓰면 코루틴 안에서만 쓸수있도록 밖에서 쓰면 에러남
    suspend fun insert(todo : Todo) {
        db.todoDao().insert(todo)
    }
}