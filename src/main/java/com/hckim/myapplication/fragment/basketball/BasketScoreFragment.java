package com.hckim.myapplication.fragment.basketball;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hckim.myapplication.R;

/**
 * Created by K on 2017-08-11.
 */

public class BasketScoreFragment extends Fragment implements View.OnClickListener {

    public interface OnWarningListener { // B(2)
//        void onWarning();
        void onWarning(String teamName); // B(6)
    }

    private TextView mScoreTextView; // (3)
    private int mScore; // (6)
    private TextView mTeamNameTextView; // (9)'

    private OnWarningListener mListener; // B(3) B(2)의 onWarning 발동시키려면 객체가 필요

    @Override
    public void onAttach(Context context) { // B(5) Activity 연결
        super.onAttach(context);

        // 액티비티와 연결됨
        mListener = (OnWarningListener) context; // B(6) Alt Enter Cast...하면 (onWarningListener) 만들어짐
    }

    // 뷰를 만드는 곳
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { // (1) onCre... Enter (5)' (5)의 결과
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_basket_score, container, false); // (2) 수정
    }

    // 뷰가 다 만들어진 다음에 호출되는 곳
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) { // (4) onVi... Enter
        super.onViewCreated(view, savedInstanceState);

        mScoreTextView = (TextView) view.findViewById(R.id.score_text);
        mTeamNameTextView = (TextView) view.findViewById(R.id.team_name_text); // (9)
        view.findViewById(R.id.button_1).setOnClickListener(this); // (5) Alt Enter Make BasketScoreFragment implements... Enter
        view.findViewById(R.id.button_2).setOnClickListener(this);
        view.findViewById(R.id.button_3).setOnClickListener(this);

        if (savedInstanceState != null) { // (11)
            mScore = savedInstanceState.getInt("score");
            mScoreTextView.setText("" + mScore);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) { // (10)
        outState.putInt("score", mScore);
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onClick(View v) { // (5)'' (5)의 결과
        switch (v.getId()) {
            case R.id.button_1:
                mScore++; // (6)'
                break;
            case R.id.button_2:
                mScore += 2;
                break;
            case R.id.button_3:
                mScore += 3;
                break;
        }
        if (mScore > 20) {
            mListener.onWarning(mTeamNameTextView.getText().toString()); // B(4). () 안 B(7)
        }
        mScoreTextView.setText("" + mScore);
    }

    public void reset() { // (7)
        mScore = 0;
        mScoreTextView.setText("" + mScore);
    }

    public void setTeamName(String name) { // (8)
        mTeamNameTextView.setText(name); // (9)''
    }

    public void warning() { // B(1)
        getView().setBackgroundColor(Color.RED);
    }
}
/*
Fragment B(1) Activity B(1) B(2) B(3) Fragment B(2) Activity B(4) B(5) Fragment B(3) B(4) B(5) (Activity B(2) B(3) 사라짐) B(6) B(7)
Activity B(5) 다시. B(6)
 */