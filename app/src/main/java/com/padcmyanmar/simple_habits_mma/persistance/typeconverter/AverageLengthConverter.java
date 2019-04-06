package com.padcmyanmar.simple_habits_mma.persistance.typeconverter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class AverageLengthConverter {

    @TypeConverter
    public static String fromListToJson(Integer[] averageLengths)
    {
        return new Gson().toJson(averageLengths);
    }

    @TypeConverter
    public static Integer[] fromJsonToList(String jsonAverageLengths){
        Type listType = new TypeToken<Integer[]>(){
        }.getType();
        return new Gson().fromJson(jsonAverageLengths,listType);
    }
}
