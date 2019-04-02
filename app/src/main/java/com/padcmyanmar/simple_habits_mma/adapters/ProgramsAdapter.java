package com.padcmyanmar.simple_habits_mma.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simple_habits_mma.R;
import com.padcmyanmar.simple_habits_mma.data.vos.ProgramsVO;
import com.padcmyanmar.simple_habits_mma.views.holders.ProgramsViewHolder;

import java.util.PriorityQueue;

public class ProgramsAdapter extends BaseRecyclerAdapter<ProgramsViewHolder, ProgramsVO> {

    @NonNull
    @Override
    public ProgramsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.view_item_program, viewGroup, false);
        return new ProgramsViewHolder(itemView);
    }
}
