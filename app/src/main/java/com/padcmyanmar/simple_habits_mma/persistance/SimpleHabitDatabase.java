package com.padcmyanmar.simple_habits_mma.persistance;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;

import com.padcmyanmar.simple_habits_mma.data.vos.CategoryProgramsVO;
import com.padcmyanmar.simple_habits_mma.data.vos.CurrentProgramVO;
import com.padcmyanmar.simple_habits_mma.data.vos.LoginUserVO;
import com.padcmyanmar.simple_habits_mma.data.vos.TopicsVO;
import com.padcmyanmar.simple_habits_mma.persistance.dao.CategoryProgramDao;
import com.padcmyanmar.simple_habits_mma.persistance.dao.CurrentProgramDao;
import com.padcmyanmar.simple_habits_mma.persistance.dao.LoginUserDao;
import com.padcmyanmar.simple_habits_mma.persistance.dao.TopicDao;
import com.padcmyanmar.simple_habits_mma.persistance.typeconverter.AverageLengthConverter;
import com.padcmyanmar.simple_habits_mma.persistance.typeconverter.ProgramConverter;
import com.padcmyanmar.simple_habits_mma.persistance.typeconverter.SessionConverter;


@Database(entities = {CurrentProgramVO.class,
                        TopicsVO.class,
                        CategoryProgramsVO.class,
                        LoginUserVO.class}, version = 5)

@TypeConverters({SessionConverter.class, ProgramConverter.class,
        AverageLengthConverter.class})

public abstract class SimpleHabitDatabase extends RoomDatabase {

    private static SimpleHabitDatabase INSTANCE;

    public abstract  CurrentProgramDao currentProgramDao();

    public abstract TopicDao topicDao();

    public abstract CategoryProgramDao categoryProgramDao();

    public abstract LoginUserDao loginUserDao();

    public static SimpleHabitDatabase getDatabase(Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, SimpleHabitDatabase.class, "SimpleHabitDatabase.DB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public boolean isCurrentProgramEmpty(){
        CurrentProgramVO currentProgram = currentProgramDao().getCurrentProgram();
        return currentProgram == null;

    }

    public boolean isTopicsEmpty() {
        TopicsVO topics = topicDao().getLatestTopics();
        return topics == null;
    }

    public boolean isCategoryEmpty() {
        CategoryProgramsVO categoryPrograms = categoryProgramDao().getLatestCategory();
        return categoryPrograms == null;
    }
}
