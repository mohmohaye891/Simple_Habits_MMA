package com.padcmyanmar.simple_habits_mma.network;

import com.padcmyanmar.simple_habits_mma.data.models.TopicsModel;
import com.padcmyanmar.simple_habits_mma.delegates.CategoryProgramDelegate;
import com.padcmyanmar.simple_habits_mma.delegates.CurrentProgramDelegate;
import com.padcmyanmar.simple_habits_mma.delegates.ProgramDelegate;
import com.padcmyanmar.simple_habits_mma.delegates.TopicsDelegate;
import com.padcmyanmar.simple_habits_mma.network.responses.TopicsResponse;

public interface DataAgent {

    void getTopics(String accessToken, int page, TopicsDelegate topicsDelegate);

    void getCategoryProgram(String accessToken, int page, CategoryProgramDelegate categoryProgramDelegate);

    void getCurrentProgram(String accessToken, int page, CurrentProgramDelegate currentProgramDelegate);
}
