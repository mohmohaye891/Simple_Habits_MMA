package com.padcmyanmar.simple_habits_mma.data.models;

import com.padcmyanmar.simple_habits_mma.data.vos.CategoryProgramsVO;
import com.padcmyanmar.simple_habits_mma.data.vos.ProgramsVO;
import com.padcmyanmar.simple_habits_mma.delegates.CategoryProgramDelegate;
import com.padcmyanmar.simple_habits_mma.network.DataAgent;
import com.padcmyanmar.simple_habits_mma.network.RetrofitDA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoryProgramModelImpl implements CategoryProgramModel {

    private static CategoryProgramModelImpl objInstance;

    private DataAgent mDataAgent;

    private List<CategoryProgramsVO> mCategoryProgram;

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private CategoryProgramModelImpl() {
       mCategoryProgram = new ArrayList<>();
       mDataAgent = RetrofitDA.getObjInstance();
    }

    public static CategoryProgramModelImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new CategoryProgramModelImpl();
        }

        return objInstance;
    }

    @Override
    public List<CategoryProgramsVO> getCategoryProgram(String accessToken, final CategoryProgramDelegate delegate) {

        if (mCategoryProgram.isEmpty())  {
            mDataAgent.getCategoryProgram(DUMMY_ACCESS_TOKEN, 1, new com.padcmyanmar.simple_habits_mma.delegates.CategoryProgramDelegate() {
                @Override
                public void onSuccess(List<CategoryProgramsVO> categoryProgramData) {
                    mCategoryProgram = categoryProgramData;
                    delegate.onSuccess(categoryProgramData);
                }

                @Override
                public void onFail(String errorMsg) {
                    delegate.onFail(errorMsg);
                }
            });
        }
        return null;
    }
}
