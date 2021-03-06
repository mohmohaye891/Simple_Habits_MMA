package com.padcmyanmar.simple_habits_mma.network;

import com.padcmyanmar.simple_habits_mma.network.responses.CategoriesProgramsResponse;
import com.padcmyanmar.simple_habits_mma.network.responses.CurrentProgramResponse;
import com.padcmyanmar.simple_habits_mma.network.responses.TopicsResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SimpleHabitAPI {

    @FormUrlEncoded
    @POST("getTopics.php")
    Call<TopicsResponse> getTopics(@Field("access_token") String accessToken,
                                   @Field("page") int page);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<CategoriesProgramsResponse> getCategoryProgramResponse(@Field("access_token") String accessToken,
                                                                @Field("page") int page);

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Call<CurrentProgramResponse> getCurrentProgramResponse (@Field("access_token") String accessToken,
                                                            @Field("page") int page);
}
