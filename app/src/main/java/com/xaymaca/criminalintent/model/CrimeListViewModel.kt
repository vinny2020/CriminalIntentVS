package com.xaymaca.criminalintent.model

import androidx.lifecycle.ViewModel

class CrimeListViewModel: ViewModel() {

    var crimes = mutableListOf<Crime>()

    init {
        for (i in 0 until 100 ) {
            val crime = Crime()
            crime.title = "crime #$i"
            crime.isSolved = i % 2 == 0
            crimes.plusAssign(crime)
        }
    }

}