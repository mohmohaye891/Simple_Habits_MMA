package com.padcmyanmar.simple_habits_mma.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.padcmyanmar.simple_habits_mma.R;
import com.padcmyanmar.simple_habits_mma.data.vos.SessionVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SessionViewHolder extends BaseViewHolder<SessionVO> {

    @BindView(R.id.tv_session_id)
    TextView tvSessionId;

    @BindView(R.id.tv_session_name)
    TextView tvSessionName;

    @BindView(R.id.tv_session_duration)
    TextView tvSessionDuration;

    public SessionViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(SessionVO data) {
        tvSessionId.setText(data.getSessionId());
        tvSessionName.setText(data.getTitle());
        tvSessionDuration.setText(data.getLengthInSeconds() + "mins");
    }
}
