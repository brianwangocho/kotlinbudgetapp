package com.example.kotlinapp.Dao

import androidx.room.*
import com.example.kotlinapp.models.DailyTransactions

@Dao
interface DailyTransactionDao{
    @Query("SELECT * From daily_Transactions")
    suspend fun getDailyTransactions():List<DailyTransactions>
    @Query("SELECT * from  daily_Transactions WHERE  creation_date = :createdOn")
    suspend fun gettransactionByDate(createdOn :String):DailyTransactions
    @Delete
    suspend  fun deleteDailyTransaction(transaction:DailyTransactions)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertorUpdateTransaction(transaction :DailyTransactions):Long
}