package com.xaymaca.criminalintent.model

import androidx.lifecycle.ViewModel
import com.xaymaca.criminalintent.database.CrimeRepository

class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()
    fun addCrime(crime: Crime) {
        crimeRepository.addCrime(crime)
    }

}