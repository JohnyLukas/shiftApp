package com.example.shiftapp.data.database

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shiftapp.data.model.entity.BinRequestEntity

@androidx.room.Database(entities = [BinRequestEntity::class], version = 1)
@TypeConverters(DateTypeConverters::class)
abstract class BinDatabase : RoomDatabase() {
    abstract fun getBinDao(): BinDao
}