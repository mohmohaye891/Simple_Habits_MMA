package com.padcmyanmar.simple_habits_mma.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.simple_habits_mma.data.vos.CategoryProgramsVO;

import java.util.List;

public class CategoriesProgramsResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String page;

    @SerializedName("categoriesPrograms")
    private List<CategoryProgramsVO> categoryPrograms;

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

    public List<CategoryProgramsVO> getCategoryPrograms() {
        return categoryPrograms;
    }

    public boolean isSuccess() {
        return code == 200;
    }
}
