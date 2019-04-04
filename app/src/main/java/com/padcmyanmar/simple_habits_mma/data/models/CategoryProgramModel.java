package com.padcmyanmar.simple_habits_mma.data.models;

import com.padcmyanmar.simple_habits_mma.data.vos.CategoryProgramsVO;

import java.util.List;

public interface CategoryProgramModel {

    List<CategoryProgramsVO> getCategoryProgram(String accessToken, CategoryProgramDelegate delegate);

    interface CategoryProgramDelegate {

        void onSuccess(List<CategoryProgramsVO> categoryProgramVO);

        void onFail(String error);

    }
}
