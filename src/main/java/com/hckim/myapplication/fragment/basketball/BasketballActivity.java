package com.hckim.myapplication.fragment.basketball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hckim.myapplication.R;

//public class BasketballActivity extends AppCompatActivity {
public class BasketballActivity extends AppCompatActivity implements BasketScoreFragment.OnWarningListener{ // B(4) 알기 위해 implements OnWarningListener Enter

    private BasketScoreFragment mATeamFragment;
    private BasketScoreFragment mBTeamFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball2);


        mATeamFragment = (BasketScoreFragment) getSupportFragmentManager().findFragmentById(R.id.frag_team_a); // Alt Enter Cast to ... Enter
        mBTeamFragment = (BasketScoreFragment) getSupportFragmentManager().findFragmentById(R.id.frag_team_b);

        mBTeamFragment.setTeamName("Team B");

//        new View.OnClickListener() { // B(2) 가장 많이 쓰인 콜백은 OnClickListener. new OnC... Enter -> Alt Enter Implement method
//            @Override
//            public void onClick(View v) {
//
//            }
//        }; // B(3)
    }

    public void onResetButtonClicked(View view) {
        mATeamFragment.reset();
        mBTeamFragment.reset();

//        mATeamFragment.warning(); // B(1) 시험
    }

    @Override
    public void onWarning(String teamName) { // B(5) 다시 해야 함
//        Toast.makeText(this, "경고 " + teamName, Toast.LENGTH_SHORT).show(); // B(6)
        if (teamName.equals("Team A")) {
            mBTeamFragment.warning();
        } else {
            mATeamFragment.warning();
        }
    }

//    @Override
//    public void onWarning() { // B(5) B(4)로부터 생성. 여기서 아는 거.
//        Toast.makeText(this, "경고!!", Toast.LENGTH_SHORT).show(); // 프래그먼트 입장에서 호출한 것이고, 액티비티 입장에서 호출받은 것(콜백 받은 것).
//    }
}
