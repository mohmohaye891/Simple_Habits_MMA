package com.padcmyanmar.simple_habits_mma.persistance.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.simple_habits_mma.data.vos.CurrentProgramVO;

@Dao
public interface CurrentProgramDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertCurrentProgram(CurrentProgramVO currentProgramVO);

    @Query("SELECT * FROM current_program LIMIT 1")
    CurrentProgramVO getCurrentProgram();

    @Query("DELETE FROM current_program")
    void deleteCurrentProgram();
}
