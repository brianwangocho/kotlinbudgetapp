package com.example.kotlinapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.temporal.TemporalAmount


@Entity(
    tableName = "daily_Transactions",
    indices = [Index("creation_date")]
)
data class DailyTransactions(
    @PrimaryKey
    @ColumnInfo(name="creation_date")
    val creationDate :String,

    @ColumnInfo(name="expenses_type")
    val expensesType    :String,

    @ColumnInfo(name="amount")
    val amount    :Int
)