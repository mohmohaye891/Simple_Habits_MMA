package com.padcmyanmar.simple_habits_mma.data.models;

import com.padcmyanmar.simple_habits_mma.data.vos.TopicsVO;
import com.padcmyanmar.simple_habits_mma.delegates.TopicsDelegate;

import java.util.List;

public interface TopicsModel {

    List<TopicsVO> getTopics(String accessToken, TopicsDelegate topicDelegate);


}
