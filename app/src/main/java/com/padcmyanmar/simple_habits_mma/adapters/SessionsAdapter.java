package com.padcmyanmar.simple_habits_mma.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simple_habits_mma.R;
import com.padcmyanmar.simple_habits_mma.data.vos.SessionVO;
import com.padcmyanmar.simple_habits_mma.views.holders.SessionViewHolder;

public class SessionsAdapter extends BaseRecyclerAdapter<SessionViewHolder, SessionVO> {


    @NonNull
    @Override
    public SessionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.view_item_sessions, viewGroup, false);
        return new SessionViewHolder(view);
    }
}
