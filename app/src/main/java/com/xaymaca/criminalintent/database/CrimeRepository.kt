package com.xaymaca.criminalintent.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.xaymaca.criminalintent.model.Crime
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "crime-database"
private  val executor = Executors.newSingleThreadExecutor()

class CrimeRepository private constructor(context: Context) {


    private val database: CrimeDatabase = Room.databaseBuilder(
        context.applicationContext, CrimeDatabase::class.java, DATABASE_NAME)
        .build()

    private val crimeDao = database.crimeDAO()

    fun getCrimes(): LiveData<List<Crime>> = crimeDao.getCrimes()
    fun getCrime(id: UUID) : LiveData<Crime?> = crimeDao.getCrime(id)

    fun updateCrime(crime: Crime) {
        executor.execute(){
            crimeDao.updateCrime(crime)
        }
    }

    fun addCrime(crime: Crime) {
        executor.execute {
            crimeDao.addCrime(crime)
        }
    }


    companion object {
        private var INSTANCE: CrimeRepository? = null
        fun initialize(context: Context) {
            if(INSTANCE == null ) {
                INSTANCE = CrimeRepository(context)
            }
        }
        fun get(): CrimeRepository {
            return INSTANCE ?:
                    throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}