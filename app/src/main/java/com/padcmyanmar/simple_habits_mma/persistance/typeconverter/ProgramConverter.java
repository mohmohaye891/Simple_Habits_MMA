package com.padcmyanmar.simple_habits_mma.persistance.typeconverter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.padcmyanmar.simple_habits_mma.data.vos.ProgramsVO;

import java.lang.reflect.Type;
import java.util.List;

public class ProgramConverter {

    @TypeConverter
    public static String fromListToJson(List<ProgramsVO> programs)
    {
        return new Gson().toJson(programs);
    }

    @TypeConverter
    public static List<ProgramsVO> fromJsonToList(String jsonPrograms){
        Type listType = new TypeToken<List<ProgramsVO>>(){
        }.getType();
        return new Gson().fromJson(jsonPrograms,listType);
    }
}
