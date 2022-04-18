package com.example.mysecondapplication.data.local.converters

import androidx.room.TypeConverter
import com.example.mysecondapplication.domain.models.TrainingItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class TrainingConverter {
    @TypeConverter
    fun toList(team:String?):List<TrainingItem>{
        if(team == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<TrainingItem>>(){}.type
        return Gson().fromJson(team,type)
    }
    @TypeConverter
    fun toString(team:List<TrainingItem>):String{
        return Gson().toJson(team)
    }
}