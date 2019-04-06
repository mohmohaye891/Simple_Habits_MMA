package com.padcmyanmar.simple_habits_mma.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.padcmyanmar.simple_habits_mma.R;
import com.padcmyanmar.simple_habits_mma.adapters.CategoryProgramAdapter;
import com.padcmyanmar.simple_habits_mma.adapters.TopicsAdapter;
import com.padcmyanmar.simple_habits_mma.data.models.CategoryProgramModel;
import com.padcmyanmar.simple_habits_mma.data.models.CategoryProgramModelImpl;
import com.padcmyanmar.simple_habits_mma.data.models.CurrentProgramModel;
import com.padcmyanmar.simple_habits_mma.data.models.CurrentProgramModelImpl;
import com.padcmyanmar.simple_habits_mma.data.models.TopicsModel;
import com.padcmyanmar.simple_habits_mma.data.models.TopicsModelImpl;
import com.padcmyanmar.simple_habits_mma.data.models.UserModel;
import com.padcmyanmar.simple_habits_mma.data.models.UserModelImpl;
import com.padcmyanmar.simple_habits_mma.data.vos.CategoryProgramsVO;
import com.padcmyanmar.simple_habits_mma.data.vos.CurrentProgramVO;
import com.padcmyanmar.simple_habits_mma.data.vos.ProgramsVO;
import com.padcmyanmar.simple_habits_mma.data.vos.TopicsVO;
import com.padcmyanmar.simple_habits_mma.delegates.CurrentProgramDelegate;
import com.padcmyanmar.simple_habits_mma.delegates.ProgramDelegate;
import com.padcmyanmar.simple_habits_mma.delegates.TopicsDelegate;
import com.padcmyanmar.simple_habits_mma.views.pods.LoginUserViewPod;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements ProgramDelegate{

    @BindView(R.id.rv_category)
    RecyclerView rvCategory;

    @BindView(R.id.rv_all_topics)
    RecyclerView rvAllTopics;

    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.btn_play)
    Button btnPlay;

    @BindView(R.id.tv_start_here)
    TextView tvStart;

    @BindView(R.id.tv_time)
    TextView tvTime;


    private TopicsAdapter mTopicsAdapter;

    private TopicsModel mTopicsModel;

    private CurrentProgramModel mCurrentProgramModel;

    private CategoryProgramModel mCategoryProgramModel;

    private CategoryProgramAdapter categoryProgramAdapter;

    private UserModel mUserModel;


    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_lastest_news:
                        Toast.makeText(getApplicationContext(), getString(R.string.title_latest_news), Toast.LENGTH_SHORT).show();
                        mToolbar.setTitle(R.string.title_latest_news);
                        break;
                    case R.id.menu_news_just_for_you:
                        Toast.makeText(getApplicationContext(), getString(R.string.title_news_just_for_you), Toast.LENGTH_SHORT).show();
                        mToolbar.setTitle(R.string.title_news_just_for_you);
                        break;
                    case R.id.menu_favorite_news:
                        Toast.makeText(getApplicationContext(), getString(R.string.title_favorite_news), Toast.LENGTH_SHORT).show();
                        mToolbar.setTitle(R.string.title_favorite_news);
                        break;
                }
                for (int index = 0; index < mNavigationView.getMenu().size(); index++) {
                    mNavigationView.getMenu().getItem(index).setChecked(false);
                }
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        rvCategory.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false));
        categoryProgramAdapter = new CategoryProgramAdapter(this);
        rvCategory.setAdapter(categoryProgramAdapter);


       rvAllTopics.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
               LinearLayoutManager.VERTICAL,
               false));
       mTopicsAdapter = new TopicsAdapter();
       rvAllTopics.setAdapter(mTopicsAdapter);

       mTopicsModel = TopicsModelImpl.getObjInstance();

       mCurrentProgramModel = CurrentProgramModelImpl.getObjInstance();

       mUserModel = UserModelImpl.getInstance();

        if (!mUserModel.isUserdLogin()){
            //User hasn't login
            navigateToLogInScreen();

            return;
        }

        LoginUserViewPod vpLoginUser = (LoginUserViewPod) mNavigationView.getHeaderView(0);
        vpLoginUser.setData(mUserModel.getLoginUser());
        vpLoginUser.setDelegate(new LoginUserViewPod.LoginViewPodActionDelegate() {
            @Override
            public void onTapLogout() {
                UserModelImpl.getInstance().onUserLogout();
                navigateToLogInScreen();
            }
        });

       bindCurrentProgram();

       bindCategoryProgram();

       bindTopics();

    }


    private void bindCurrentProgram() {
        CurrentProgramVO currentProgramVO = mCurrentProgramModel.getCurrentProgram("b002c7e1a528b7cb460933fc2875e916",
                new CurrentProgramDelegate() {
                    @Override
                    public void onSuccess(CurrentProgramVO currentProgram) {
                        tvStart.setText(currentProgram.getTitle());
                      //  tvTime.setText(currentProgram.getAverageLength().get(0) + "mins");
                        btnPlay.setText(currentProgram.getCurrentPeriod());
                    }

                    @Override
                    public void onFail(String Msg) {

                    }
                });

        if (currentProgramVO != null) {
            tvStart.setText(currentProgramVO.getTitle());
         //   tvTime.setText(currentProgramVO.getAverageLength().get(0) + "mins");
            btnPlay.setText(currentProgramVO.getCurrentPeriod());
        }
    }


    private void bindCategoryProgram() {

        List<CategoryProgramsVO> categoryList = CategoryProgramModelImpl.getObjInstance().getCategoryProgram("b002c7e1a528b7cb460933fc2875e916", new CategoryProgramModel.CategoryProgramDelegate() {
            @Override
            public void onSuccess(List<CategoryProgramsVO> categoryProgramVO) {
                categoryProgramAdapter.setNewData(categoryProgramVO);
            }

            @Override
            public void onFail(String error) {

            }
        });

        /*if (!categoryList.isEmpty()) {

            categoryProgramAdapter.setNewData(categoryList);

        }*/
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
/*
        if (!topics.isEmpty()) {
            mTopicsAdapter.setNewData(topics);
        }*/
    }

    private void navigateToLogInScreen() {
        Intent intent =  LoginActivity.newIntent(getApplicationContext());
        startActivity(intent);
    }


    @Override
    public void onTapProgramItem(ProgramsVO programsVO) {

        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        intent.putExtra("programID", programsVO.getProgramID());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
