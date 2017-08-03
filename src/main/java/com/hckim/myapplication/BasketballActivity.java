package com.hckim.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BasketballActivity extends AppCompatActivity {
    private int mScoreA = 0; // (3)
    private int mScoreB = 0;
    private TextView mScoreATextView; // (4)의 결과
    private TextView mScoreBTextView; // (5)의 결과

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);

        mScoreATextView = (TextView) findViewById(R.id.score_a_text); // (4) Alt Enter
        mScoreBTextView = (TextView) findViewById(R.id.score_b_text); // (5) Alt Enter
    }

    public void onButtonClicked(View view) { // (1) view 눌린 버튼의 레퍼런스가 온다
        switch (view.getId()) { // (2)
            case R.id.a_1_button:
                mScoreA++; //
                break;
            case R.id.a_2_button:
                mScoreA += 2;
                break;
            case R.id.a_3_button:
                mScoreA += 3;
                break;
            case R.id.b_1_button:
                mScoreB++;
                break;
            case R.id.b_2_button:
                mScoreB += 2;
                break;
            case R.id.b_3_button:
                mScoreB += 3;
                break;
            case R.id.reset_button:
                mScoreA = 0;
                mScoreB = 0;
                break;
        }

        mScoreATextView.setText("" + mScoreA); // (6)
        mScoreBTextView.setText("" + mScoreB);
    }
}
