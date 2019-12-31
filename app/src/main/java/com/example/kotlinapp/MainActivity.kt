package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var homeFragment: Home
    lateinit var transactionFragment: TransactionFragment
    lateinit var profileFragment: profileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeFragment = Home()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayout,homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        val bottomNavigationView:BottomNavigationView = findViewById(R.id.bottom_nav)


      bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.home->{
                    homeFragment = Home()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.framelayout,homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.transactions->{
                    transactionFragment = TransactionFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.framelayout,transactionFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.profile->{
                    profileFragment = profileFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.framelayout,profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true

        }

    }
}
