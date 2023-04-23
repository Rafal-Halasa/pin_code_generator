package com.simcodic.pincodegenerator.data.repositories.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.simcodic.pincodegenerator.data.data.PIN_CODE_COLUMN_PIN_NAME
import com.simcodic.pincodegenerator.data.data.PIN_CODE_TABLE_NAME
import com.simcodic.pincodegenerator.data.data.PinCode
import kotlinx.coroutines.flow.Flow

@Dao
interface PinCodeDao {
    @Query("SELECT * FROM $PIN_CODE_TABLE_NAME ORDER BY $PIN_CODE_COLUMN_PIN_NAME ASC;")
    fun getAll(): Flow<List<PinCode>>

    @Insert
    suspend fun insert(pinCode: PinCode)

    @Delete
    suspend fun delete(pinCode: PinCode)
}