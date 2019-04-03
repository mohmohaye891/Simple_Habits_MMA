package com.padcmyanmar.simple_habits_mma.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simple_habits_mma.R;
import com.padcmyanmar.simple_habits_mma.activities.MainActivity;
import com.padcmyanmar.simple_habits_mma.data.vos.CategoryProgramsVO;
import com.padcmyanmar.simple_habits_mma.delegates.ProgramDelegate;
import com.padcmyanmar.simple_habits_mma.views.holders.CategoryViewHolder;

public class CategoryProgramAdapter extends BaseRecyclerAdapter<CategoryViewHolder, CategoryProgramsVO> {

    private ProgramDelegate mProgramDelegate;

    public CategoryProgramAdapter(ProgramDelegate programDelegate) {
        mProgramDelegate = programDelegate;
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.view_item_category, viewGroup, false);
        return new CategoryViewHolder(itemView, mProgramDelegate);
    }
}
