package com.padcmyanmar.simple_habits_mma.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "category_programs",indices = {@Index(value = {"category_id"}, unique = true)})
public class CategoryProgramsVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_program_id_pk")
    private int categoryProgramIdPK;

    @ColumnInfo(name = "category_id")
    @SerializedName("category-id")
    private String categoryID;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title;

    @ColumnInfo(name = "programs")
    @SerializedName("programs")
    private List<ProgramsVO> programs;


    public int getCategoryProgramIdPK() {
        return categoryProgramIdPK;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getTitle() {
        return title;
    }

    public List<ProgramsVO> getPrograms() {
        return programs;
    }

    public void setCategoryProgramIdPK(int categoryProgramIdPK) {
        this.categoryProgramIdPK = categoryProgramIdPK;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrograms(List<ProgramsVO> programs) {
        this.programs = programs;
    }
}
