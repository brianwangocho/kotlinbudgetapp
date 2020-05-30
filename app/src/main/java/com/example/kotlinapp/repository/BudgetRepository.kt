package com.example.kotlinapp.repository

import androidx.lifecycle.LiveData
import com.example.kotlinapp.Dao.BudgetDao
import com.example.kotlinapp.models.Budget
import com.example.kotlinapp.models.User
import com.example.kotlinapp.retrofitclient.MyRetrofitBuilder
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import java.util.*

object BudgetRepository{

    ///// (1)create a job since we are using coroutines in this Repository

    var job : CompletableJob?= null

    fun getUser(userId:String):LiveData<User>{
        /// (2) initialize the job first
        /// we need to return dataType LiveDate<User>
        job =  Job()
            return object :LiveData<User>(){
                override fun onActive() {
                    super.onActive()
                    ///run the job on Active
                    job?.let {job ->
                        /// we add the job to the IO scope to ensure is this job in this io thread we are working on
                        CoroutineScope(IO + job).launch {
                            val user = MyRetrofitBuilder.apiService.getUser(userId)
                            //3 now we switch the value to the main thread from the IO thread
                            withContext(Main){
                                value = user

                                ///4 complete the job
                                job.complete()
                            }
                        }

                    }
                }
            }

    }

    fun cancleJobs(){
        job?.cancel()
    }
}