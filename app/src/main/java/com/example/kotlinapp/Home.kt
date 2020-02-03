package com.example.kotlinapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

/**
 * A simple [Fragment] subclass.
 */
class Home : Fragment() {

    val JOB_TIMEOUT =2100L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        CoroutineScope(IO).launch {
            fakeApiRequest()

        }
        return view
    }

    private suspend fun fakeApiRequest(){

        withContext(IO){
            val job = withTimeoutOrNull(JOB_TIMEOUT){
                val result = getResultsFromApi()
                println("debug: result :$result")

                val result2 = getResultsFromApi()
                println("debug: result2 :$result2")
            }
            if(job==null){
                val cancelMessage = "Cancelling job ... Job took longer than $JOB_TIMEOUT ms"
                println(cancelMessage)
            }

        }
    }

    private suspend  fun getResultsFromApi():String{
        delay(1000)
        return "Result of ResultsFromApi"
    }

}
