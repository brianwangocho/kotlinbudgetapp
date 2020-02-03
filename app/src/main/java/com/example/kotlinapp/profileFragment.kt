package com.example.kotlinapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinapp.userviewmodel.UserViewModel

/**
 * A simple [Fragment] subclass.
 */
class profileFragment : Fragment() {
    lateinit var  profielViewModel:UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_profile, container, false)
        ////call the view model
        profielViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        ////now we call the observer we use viewLifecycleOwner on fragements

        profielViewModel.user.observe(viewLifecycleOwner, Observer {
            println("DEBUG:${it}")
        })
        profielViewModel.setUserId("1");
        return  view
    }

    override fun onDestroy() {
        super.onDestroy()
        profielViewModel.cancelJobs()
    }




}
