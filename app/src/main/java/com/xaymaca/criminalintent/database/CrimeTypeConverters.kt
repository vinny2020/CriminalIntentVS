package com.xaymaca.criminalintent.database

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.util.*

class CrimeTypeConverters {
    @TypeConverter
    fun fromDFate(date: Date) : Long? {
        return date?.time
    }

    @TypeConverter
    fun toDate(millisSinceEpoch: Long?) : Date? {
        return millisSinceEpoch?.let {
            Date(it)
        }
    }
    @TypeConverter
    fun toUUID(uuid: String?) : UUID? {
        return UUID.fromString(uuid)
    }
    @TypeConverter
    fun fromUUID(uuid: UUID?) : String? {
        return uuid.toString()
    }


}