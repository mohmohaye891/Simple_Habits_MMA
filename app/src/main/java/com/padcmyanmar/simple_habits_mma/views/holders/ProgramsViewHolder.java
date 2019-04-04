package com.padcmyanmar.simple_habits_mma.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.padcmyanmar.simple_habits_mma.R;
import com.padcmyanmar.simple_habits_mma.data.vos.ProgramsVO;
import com.padcmyanmar.simple_habits_mma.delegates.ProgramDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgramsViewHolder extends BaseViewHolder<ProgramsVO> {

    @BindView(R.id.tv_program)
    TextView tvProgram;

    @BindView(R.id.tv_time)
    TextView tvTime;

    private ProgramDelegate mProgramDelegate;

    private ProgramsVO mData;

    public ProgramsViewHolder(@NonNull View itemView, ProgramDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.mProgramDelegate = delegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgramDelegate.onTapProgramItem(mData);
            }
        });
    }

    @Override
    public void bindData(ProgramsVO data) {

        mData = data;

        tvProgram.setText(data.getTitle());
        tvTime.setText(data.getAverageLength().get(0) + "min");
    }
}
