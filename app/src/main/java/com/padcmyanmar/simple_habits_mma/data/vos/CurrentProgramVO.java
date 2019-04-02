package com.padcmyanmar.simple_habits_mma.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentProgramVO {

    @SerializedName("program-id")
    private String programID;

    @SerializedName("title")
    private String title;

    @SerializedName("background")
    private String image;

    @SerializedName("average-lengths")
    private List<Integer> averageLength;

    @SerializedName("description")
    private String description;

    @SerializedName("current-period")
    private String currentPeriod;

    @SerializedName("sessions")
    private List<SessionVO> session;

    public String getProgramID() {
        return programID;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public List<Integer> getAverageLength() {
        return averageLength;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public List<SessionVO> getSession() {
        return session;
    }
}
