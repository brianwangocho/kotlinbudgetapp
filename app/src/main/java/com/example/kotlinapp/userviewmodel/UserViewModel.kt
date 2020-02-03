package com.example.kotlinapp.userviewmodel

import android.view.animation.Transformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.kotlinapp.models.User
import com.example.kotlinapp.repository.BudgetRepository


class UserViewModel :ViewModel(){

    private val _userId:MutableLiveData<String> = MutableLiveData()

    val user :LiveData<User> = Transformations.switchMap(_userId){
        BudgetRepository.getUser(it)
    }

    fun setUserId(userId:String){
        val update = userId
        if(_userId.value == update){
            return
        }
        _userId.value = update
    }
    fun cancelJobs(){
        BudgetRepository.cancleJobs()
    }
}