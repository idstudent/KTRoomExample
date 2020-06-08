package com.example.test

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application : Application) : AndroidViewModel(application){

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "todo-db" // todo-db는 db이름 임의로 지정
    )
//            .allowMainThreadQueries() // 메인쓰레드에서도 하도록 함 실무에서는 백그라운드 쓰레드에서 하니 잘안쓴다고함
        .build()

    var todos : LiveData<List<Todo>>
    var newTodo : String ?= null

    init {
        todos = getAll()
    }
    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    //suspend를 쓰면 코루틴 안에서만 쓸수있도록 밖에서 쓰면 에러남
    fun insert(todo : String) {
        viewModelScope.launch(Dispatchers.IO) {
            db.todoDao().insert(Todo(todo))
        }
    }
}