package com.padcmyanmar.simple_habits_mma.views.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.padcmyanmar.simple_habits_mma.R;
import com.padcmyanmar.simple_habits_mma.adapters.CategoryProgramAdapter;
import com.padcmyanmar.simple_habits_mma.adapters.ProgramsAdapter;
import com.padcmyanmar.simple_habits_mma.data.vos.CategoryProgramsVO;
import com.padcmyanmar.simple_habits_mma.delegates.ProgramDelegate;

import butterknife.BindView;

public class CategoryViewHolder extends BaseViewHolder<CategoryProgramsVO> {

    @BindView(R.id.rv_category)
    RecyclerView rvCategory;

    @BindView(R.id.tv_category)
    TextView tvCategory;

    private ProgramDelegate mProgramDelegate;

    public CategoryViewHolder(@NonNull View itemView, ProgramDelegate programDelegate) {
        super(itemView);
        mProgramDelegate = programDelegate;
    }

    @Override
    public void bindData(CategoryProgramsVO data) {

        rvCategory.setLayoutManager(new LinearLayoutManager(itemView.getContext(),
                LinearLayoutManager.HORIZONTAL,
                false));
        ProgramsAdapter adapter = new ProgramsAdapter(mProgramDelegate);
        rvCategory.setAdapter(adapter);


        adapter.setNewData(data.getPrograms());

        tvCategory.setText(data.getTitle());

    }
}
