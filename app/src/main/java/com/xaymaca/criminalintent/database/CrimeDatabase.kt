package com.xaymaca.criminalintent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.xaymaca.criminalintent.model.Crime

@Database(entities = [Crime::class],version = 2, exportSchema = true)
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDatabase: RoomDatabase() {
    abstract fun crimeDAO(): CrimeDAO
}
    val migration_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                "ALTER TABLE CRIME ADD COLUMN suspect TEXT NOT NULL DEFAULT ''"
            )
        }
    }
