package com.padcmyanmar.simple_habits_mma.persistance.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.simple_habits_mma.data.vos.TopicsVO;

import java.util.List;

@Dao
public interface TopicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertTopics(List<TopicsVO> topics);

    @Query("SELECT * FROM  topic WHERE topic_name = :topicsId")
    TopicsVO getTopicsById(String topicsId);

    @Query("SELECT * FROM topic ORDER BY topic_name_pk DESC")
    List<TopicsVO> getAllTopics();


    @Query("SELECT * FROM topic ORDER BY topic_name_pk DESC LIMIT 1") // return upper one
    TopicsVO getLatestTopics();
}
