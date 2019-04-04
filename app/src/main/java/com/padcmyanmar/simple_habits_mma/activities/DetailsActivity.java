package com.padcmyanmar.simple_habits_mma.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.padcmyanmar.simple_habits_mma.R;
import com.padcmyanmar.simple_habits_mma.adapters.SessionsAdapter;
import com.padcmyanmar.simple_habits_mma.data.models.CategoryProgramModelImpl;
import com.padcmyanmar.simple_habits_mma.data.vos.ProgramsVO;
import com.padcmyanmar.simple_habits_mma.delegates.ProgramDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_sessions)
    RecyclerView rvSessions;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    private String programID;

    private ProgramsVO programs;

    private SessionsAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs_details);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        programID = getIntent().getStringExtra("programID");

        programs = CategoryProgramModelImpl.getObjInstance().getProgramByID(programID);

        collapsingToolbarLayout.setTitle(programs.getTitle());

        tvDescription.setText(programs.getDescription());

        rvSessions.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
        adapter = new SessionsAdapter();
        rvSessions.setAdapter(adapter);
        adapter.setNewData(programs.getSession());

    }

}
