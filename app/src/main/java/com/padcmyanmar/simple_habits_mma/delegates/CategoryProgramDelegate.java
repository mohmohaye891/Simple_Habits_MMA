package com.padcmyanmar.simple_habits_mma.delegates;

import com.padcmyanmar.simple_habits_mma.data.vos.CategoryProgramsVO;

import java.util.List;

public interface CategoryProgramDelegate {

    void onSuccess(List<CategoryProgramsVO> categoryProgram);

    void onFail(String error);
}
