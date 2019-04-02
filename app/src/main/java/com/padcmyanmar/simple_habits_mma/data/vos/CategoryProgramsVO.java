package com.padcmyanmar.simple_habits_mma.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryProgramsVO {

    @SerializedName("category-id")
    private String categoryID;

    @SerializedName("title")
    private String title;

    @SerializedName("programs")
    private List<ProgramsVO> programs;

    public String getCategoryID() {
        return categoryID;
    }

    public String getTitle() {
        return title;
    }

    public List<ProgramsVO> getPrograms() {
        return programs;
    }
}
