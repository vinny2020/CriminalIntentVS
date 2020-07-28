package com.xaymaca.criminalintent.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xaymaca.criminalintent.model.Crime
import java.util.*

@Dao
interface CrimeDAO {
    @Query("Select * from crime")
    fun getCrimes() : LiveData<List<Crime>>

    @Query("SELECT * from crime where id = (:id)")
    fun getCrime(id: UUID ) : LiveData<Crime?>

    @Update
    fun updateCrime(crime: Crime)

    @Insert
    fun addCrime(crime: Crime)


}