package com.simcodic.pincodegenerator.data.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val PIN_CODE_TABLE_NAME = "pin_code"

@Entity(tableName = PIN_CODE_TABLE_NAME)
data class PinCode(

    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "pin_name") val pinName: String,
    @ColumnInfo(name = "pin_code") val lastName: String
)