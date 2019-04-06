package com.padcmyanmar.simple_habits_mma;

import android.app.Application;

import com.padcmyanmar.simple_habits_mma.data.models.CategoryProgramModelImpl;
import com.padcmyanmar.simple_habits_mma.data.models.CurrentProgramModelImpl;
import com.padcmyanmar.simple_habits_mma.data.models.TopicsModelImpl;
import com.padcmyanmar.simple_habits_mma.data.models.UserModelImpl;

public class SimpleHabitApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CurrentProgramModelImpl.initCurrentProgramModel(getApplicationContext());
        TopicsModelImpl.initTopicsModel(getApplicationContext());
        CategoryProgramModelImpl.initCategoryProgramModel(getApplicationContext());
        UserModelImpl.initUserModel(getApplicationContext());
    }
}
