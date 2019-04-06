package com.padcmyanmar.simple_habits_mma.persistance.typeconverter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.padcmyanmar.simple_habits_mma.data.vos.SessionVO;

import java.lang.reflect.Type;
import java.util.List;

public class SessionConverter {

    @TypeConverter
    public static String fromListToJson(List<SessionVO> sessions)
    {
        return new Gson().toJson(sessions);
    }

    @TypeConverter
    public static List<SessionVO> fromJsonToList(String jsonSessions){
        Type listType = new TypeToken<List<SessionVO>>(){
        }.getType();
        return new Gson().fromJson(jsonSessions,listType);
    }
}
