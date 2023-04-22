package com.simcodic.pincodegenerator.data.repositories.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.simcodic.pincodegenerator.data.data.PinCode
import com.simcodic.pincodegenerator.data.repositories.local.dao.PinCodeDao

@Database(entities = [PinCode::class], version = 1)
abstract class PinCodeDatabase : RoomDatabase() {

    abstract fun pinCodeDao(): PinCodeDao
}