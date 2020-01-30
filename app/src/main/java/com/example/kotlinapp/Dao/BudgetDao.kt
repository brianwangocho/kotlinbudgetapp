package com.example.kotlinapp.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlinapp.models.Budget
import com.example.kotlinapp.models.DailyTransactions

@Dao
interface BudgetDao {
    @Query("SELECT * FROM budget" )
    suspend fun getBudget(): List<Budget>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertorUpdateTransaction(budget :Budget):Long
    @Query("SELECT * from  budget WHERE  creation_date = :createdOn")
    suspend fun getbudgetByDate(createdOn :String):Budget
}