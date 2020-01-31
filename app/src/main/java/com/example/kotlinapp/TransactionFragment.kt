package com.example.kotlinapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.adapter.MyAdapter
import kotlinx.android.synthetic.main.fragment_transaction.*

/**
 * A simple [Fragment] subclass.
 */
class TransactionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_transaction, container, false)


        val myAdapter = MyAdapter(arrayOf("test","make","work"))
        val recycler = view.findViewById<RecyclerView>(R.id.transactionsrecyclerview)
        recycler.adapter=myAdapter
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = layoutManager



        return view

    }


}
