package com.hckim.myapplication.fragment.basketball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hckim.myapplication.R;

public class BasketballActivity extends AppCompatActivity {

    private BasketScoreFragment mATeamFragment;
    private BasketScoreFragment mBTeamFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball2);


        mATeamFragment = (BasketScoreFragment) getSupportFragmentManager().findFragmentById(R.id.frag_team_a); // Alt Enter Cast to ... Enter
        mBTeamFragment = (BasketScoreFragment) getSupportFragmentManager().findFragmentById(R.id.frag_team_b);

        mBTeamFragment.setTeamName("Team B");
    }

    public void onResetButtonClicked(View view) {
        mATeamFragment.reset();
        mBTeamFragment.reset();
    }
}
