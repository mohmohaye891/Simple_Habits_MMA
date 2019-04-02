package com.padcmyanmar.simple_habits_mma.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProgramsVO {

    @SerializedName("program-id")
    private String programID;

    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private String image;

    @SerializedName("average-lengths")
    private List<Integer> averageLength;

    @SerializedName("description")
    private String description;

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

    public List<SessionVO> getSession() {
        return session;
    }
}
