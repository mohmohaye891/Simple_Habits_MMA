package com.padcmyanmar.simple_habits_mma.network;

import com.padcmyanmar.simple_habits_mma.delegates.CategoryDelegate;
import com.padcmyanmar.simple_habits_mma.delegates.CurrentProgramDelegate;
import com.padcmyanmar.simple_habits_mma.delegates.TopicsDelegate;

public interface DataAgent {

    void getTopics(String accessToken, int page, TopicsDelegate topicsDelegate);

    void getCategoryProgram(String accessToken, int page, CategoryDelegate categoryProgramDelegate);

    void getCurrentProgram(String accessToken, int page, CurrentProgramDelegate currentProgramDelegate);
}
