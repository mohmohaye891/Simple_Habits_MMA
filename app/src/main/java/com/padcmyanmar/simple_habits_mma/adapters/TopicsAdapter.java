package com.padcmyanmar.simple_habits_mma.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simple_habits_mma.R;
import com.padcmyanmar.simple_habits_mma.data.vos.TopicsVO;
import com.padcmyanmar.simple_habits_mma.views.holders.TopicsViewHolder;

public class TopicsAdapter extends BaseRecyclerAdapter<TopicsViewHolder, TopicsVO> {

    public TopicsAdapter() {

    }

    @NonNull
    @Override
    public TopicsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.view_item_topics, viewGroup, false);
        return new TopicsViewHolder(itemView);
    }
}
