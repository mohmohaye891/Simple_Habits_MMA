package com.padcmyanmar.simple_habits_mma.data.models;

import com.padcmyanmar.simple_habits_mma.data.vos.CategoryProgramsVO;
import com.padcmyanmar.simple_habits_mma.data.vos.ProgramsVO;
import com.padcmyanmar.simple_habits_mma.delegates.CategoryDelegate;
import com.padcmyanmar.simple_habits_mma.network.DataAgent;
import com.padcmyanmar.simple_habits_mma.network.RetrofitDA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoryProgramModelImpl implements CategoryProgramModel {

    private static CategoryProgramModelImpl objInstance;

    private DataAgent mDataAgent;

    private HashMap<String, ProgramsVO> programs;

    private List<CategoryProgramsVO> mCategoryProgram;

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private CategoryProgramModelImpl() {
        programs = new HashMap<>();
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
            mDataAgent.getCategoryProgram(DUMMY_ACCESS_TOKEN, 1, new CategoryDelegate() {
                @Override
                public void onSuccess(List<CategoryProgramsVO> categoryProgramData) {
                    mCategoryProgram = categoryProgramData;
                    addToList(categoryProgramData);
                    delegate.onSuccess(categoryProgramData);
                }

                @Override
                public void onFail(String errorMsg) {
                    delegate.onFail(errorMsg);
                }
            });
        }
        return mCategoryProgram;
    }

    private void addToList(List<CategoryProgramsVO> categoryPrograms) {

        for (CategoryProgramsVO categoryProgramsVO : categoryPrograms) {

            for (ProgramsVO program : categoryProgramsVO.getPrograms()) {

                programs.put(program.getProgramID(), program);
            }

        }
    }

    public ProgramsVO getProgramByID(String id) {
        return programs.get(id);
    }
}
