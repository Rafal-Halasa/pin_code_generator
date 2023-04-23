package com.simcodic.pincodegenerator.data.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import  com.simcodic.pincodegenerator.domain.data.PinCode as PinCodeDomain

const val PIN_CODE_TABLE_NAME = "pin_code_table"
const val PIN_CODE_COLUMN_PIN_NAME = "pin_name"
const val PIN_CODE_COLUMN_PIN_CODE = "pin_code"

@Entity(tableName = PIN_CODE_TABLE_NAME)
data class PinCode(

    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = PIN_CODE_COLUMN_PIN_NAME) val name: String,
    @ColumnInfo(name = PIN_CODE_COLUMN_PIN_CODE) val pinCode: String
)

fun PinCode.toDomainModel() = PinCodeDomain(id = uid, name = name, pinCode = pinCode)