package com.hckim.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityMoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

//        View.OnClickListener // (3) 객체를 만듦 OnC... Enter. 인스턴스화할 수 있는 객체가 아니므로 객체로 만들려면 클래스를 구현해야
        View.OnClickListener listener = new MyClickListener(); // (6) 인스턴스화해서

        Button button = (Button) findViewById(R.id.button); // (1) 클릭 이벤트를 다르게. on CLick 말고 레퍼런스 갖고 와서 하는 방법
//        button.setOnClickListener(); // (2) onClickListener라는 객체를 받음
        button.setOnClickListener(listener); // (7) 넘겨 주어야
    }

    class MyClickListener implements View.OnClickListener { // (4) Implement method Enter
        @Override
        public void onClick(View v) { // (5)
            Toast.makeText(ActivityMoveActivity.this, "잘 되나?", Toast.LENGTH_SHORT).show(); // (8) 클릭했을 때 여기가 호출
        }
    }
}
