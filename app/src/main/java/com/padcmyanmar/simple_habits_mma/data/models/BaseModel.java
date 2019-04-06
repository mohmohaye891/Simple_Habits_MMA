package com.padcmyanmar.simple_habits_mma.data.models;

import android.content.Context;

import com.padcmyanmar.simple_habits_mma.network.DataAgent;
import com.padcmyanmar.simple_habits_mma.network.RetrofitDA;
import com.padcmyanmar.simple_habits_mma.persistance.SimpleHabitDatabase;

public abstract class BaseModel {
    protected SimpleHabitDatabase mDataBase;

    protected DataAgent mDataAgent;

    public BaseModel(Context context) {
        mDataAgent = RetrofitDA.getObjInstance();
        mDataBase = SimpleHabitDatabase.getDatabase(context);
    }

}
