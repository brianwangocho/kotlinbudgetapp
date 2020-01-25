package com.example.kotlinapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlinapp.Dao.BudgetDao
import com.example.kotlinapp.Dao.DailyTransactionDao
import com.example.kotlinapp.models.Budget
import com.example.kotlinapp.models.DailyTransactions
import java.sql.Types.NULL

private const val DATABASE = "room"

@Database(
    entities = [Budget::class,DailyTransactions::class],
    version = 1,
    exportSchema = false
)

abstract class BudgetDatabase: RoomDatabase(){

    abstract fun budgetDao():BudgetDao
    abstract fun dailyTransactionDao():DailyTransactionDao

    ////create a companion object
    companion object{

        @Volatile
        private var INSTANCE:BudgetDatabase? =null

        fun getDatabase(context:Context):BudgetDatabase{
            val tempInstance = INSTANCE
            if(tempInstance !=null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BudgetDatabase::class.java,
                    "budget_database"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }


    }

}