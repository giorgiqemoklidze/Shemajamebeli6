package com.example.shemajamebeli6

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private var users = MutableLiveData<List<User>>()
    var _users: MutableLiveData<List<User>> = users





    fun read(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val user =  DataBase.db.userDao().getAll()
                _users.postValue(user)

            }
        }
    }


    fun write(title:String,description:String,image:String){
        val user = User(title,description,image)
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                DataBase.db.userDao().insertAll(user)
            }
        }

    }

}