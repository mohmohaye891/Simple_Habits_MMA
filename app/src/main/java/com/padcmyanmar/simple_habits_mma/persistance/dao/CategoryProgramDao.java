package com.padcmyanmar.simple_habits_mma.persistance.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.padcmyanmar.simple_habits_mma.data.vos.CategoryProgramsVO;

import java.util.List;

@Dao
public interface CategoryProgramDao {

    @Insert
    long[] insertCategorys(List<CategoryProgramsVO> newsList);

    @Query("SELECT * FROM category_programs WHERE category_id = :categoryIdPK")
    CategoryProgramsVO getCategoryById(String categoryIdPK);

    @Query("SELECT * FROM category_programs ORDER BY category_program_id_pk DESC")
    List<CategoryProgramsVO> getAllCategory();

    @Query("SELECT * FROM category_programs ORDER BY category_program_id_pk DESC LIMIT 1")
    CategoryProgramsVO getLatestCategory();
}
