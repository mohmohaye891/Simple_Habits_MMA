package com.padcmyanmar.simple_habits_mma.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.padcmyanmar.simple_habits_mma.R;
import com.padcmyanmar.simple_habits_mma.adapters.TopicsAdapter;
import com.padcmyanmar.simple_habits_mma.data.models.TopicsModel;
import com.padcmyanmar.simple_habits_mma.data.models.TopicsModelImpl;
import com.padcmyanmar.simple_habits_mma.data.vos.ProgramsVO;
import com.padcmyanmar.simple_habits_mma.data.vos.TopicsVO;
import com.padcmyanmar.simple_habits_mma.delegates.ProgramDelegate;
import com.padcmyanmar.simple_habits_mma.delegates.TopicsDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

   /* @BindView(R.id.rv_one)
    RecyclerView rvOne;*/

    @BindView(R.id.rv_all_topics)
    RecyclerView rvAllTopics;


    private TopicsAdapter mTopicsAdapter;

    private TopicsModel mTopicsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


       /* rvOne.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false));*/

       rvAllTopics.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
               LinearLayoutManager.VERTICAL,
               false));
       mTopicsAdapter = new TopicsAdapter();
       rvAllTopics.setAdapter(mTopicsAdapter);

       mTopicsModel = TopicsModelImpl.getObjInstance();

        bindTopics();

    }

    private void bindTopics() {

       List<TopicsVO> topics = mTopicsModel.getTopics("b002c7e1a528b7cb460933fc2875e916", new TopicsDelegate() {
           @Override
           public void onSuccess(List<TopicsVO> topics) {

               mTopicsAdapter.setNewData(topics);
           }

           @Override
           public void onFail(String error) {

           }
       });

        if (!topics.isEmpty()) {
            mTopicsAdapter.setNewData(topics);
        }
    }


}
