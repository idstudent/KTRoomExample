package com.example.test

import androidx.room.Entity
import androidx.room.PrimaryKey

//룸클래스로 사용하기위한 어노테이션이라는데 설명을 저래해줌.
@Entity
data class Todo(var title : String) {
    // @PrimaryKey(autoGenerate = true) auto increment역할 (id 자동으로 1씩 올려주는그거)
    @PrimaryKey(autoGenerate = true) var id : Int = 0
}