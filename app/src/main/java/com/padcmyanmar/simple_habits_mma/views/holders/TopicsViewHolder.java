package com.padcmyanmar.simple_habits_mma.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.padcmyanmar.simple_habits_mma.R;
import com.padcmyanmar.simple_habits_mma.data.vos.TopicsVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopicsViewHolder extends BaseViewHolder<TopicsVO> {

    @BindView(R.id.tv_title)
    TextView tvTopicsTitle;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    public TopicsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(TopicsVO data) {

        tvTopicsTitle.setText(data.getTopicName());
        tvDescription.setText(data.getTopicDesc());
    }
}
