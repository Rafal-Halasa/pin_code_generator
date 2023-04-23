package com.simcodic.pincodegenerator.data.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import  com.simcodic.pincodegenerator.domain.data.PinCode as PinCodeDomain

const val PIN_CODE_TABLE_NAME = "pin_code"

@Entity(tableName = PIN_CODE_TABLE_NAME)
data class PinCode(

    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "pin_name") val name: String,
    @ColumnInfo(name = "pin_code") val pinCode: String
)

fun PinCode.toDomainModel() = PinCodeDomain(name = name, pinCode = pinCode)