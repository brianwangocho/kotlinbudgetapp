package com.example.kotlinapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName="budget",
    indices = [Index("creation_date")]
)
data class Budget(
    @PrimaryKey
    @ColumnInfo(name="creation_date")
    val creationDate :String,
    @ColumnInfo(name="expenses")
    val expenses    :Int,
    @ColumnInfo(name="amount_budgeted")
    val amountBudgeted :Int,
    @ColumnInfo(name="balance")
    val balance         :Int,
    @ColumnInfo(name="end_date")
    val endDate :String

)