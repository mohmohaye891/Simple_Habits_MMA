package com.padcmyanmar.simple_habits_mma.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.simple_habits_mma.data.vos.TopicsVO;

import java.util.List;

public class TopicsResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String page;

    @SerializedName("topics")
    private List<TopicsVO> topics;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<TopicsVO> getTopics() {
        return topics;
    }

    public boolean isSuccess() {
        return code == 200;
    }
}
