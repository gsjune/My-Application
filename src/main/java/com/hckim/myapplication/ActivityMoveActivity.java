package com.hckim.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ActivityMoveActivity extends AppCompatActivity {

    // 방법 1
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_move);
//
////        View.OnClickListener // (3) 객체를 만듦 OnC... Enter. 인스턴스화할 수 있는 객체가 아니므로 객체로 만들려면 클래스를 구현해야
//        View.OnClickListener listener = new MyClickListener(); // (6) 인스턴스화해서
//
//        Button button = (Button) findViewById(R.id.button); // (1) 클릭 이벤트를 다르게. on CLick 말고 레퍼런스 갖고 와서 하는 방법
////        button.setOnClickListener(); // (2) onClickListener라는 객체를 받음
//        button.setOnClickListener(listener); // (7) 넘겨 주어야
//    }
//
//    class MyClickListener implements View.OnClickListener { // (4) Implement method Enter
//        @Override
//        public void onClick(View v) { // (5)
//            Toast.makeText(ActivityMoveActivity.this, "잘 되나?", Toast.LENGTH_SHORT).show(); // (8) 클릭했을 때 여기가 호출
//        }
//    }
    // 방법 2
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_move);
//
//        View.OnClickListener listener = new View.OnClickListener() { // B(1)
//            @Override // B(2)
//            public void onClick(View v) {
//                Toast.makeText(ActivityMoveActivity.this, "잘 되나?", Toast.LENGTH_SHORT).show(); // B(3)
//            }
//        };
//
//        Button button = (Button) findViewById(R.id.button);
////
//        button.setOnClickListener(listener);
//    }
//
////    class MyClickListener implements View.OnClickListener {
////        @Override
////        public void onClick(View v) {
////            Toast.makeText(ActivityMoveActivity.this, "잘 되나?", Toast.LENGTH_SHORT).show();
////        }
////    }
    // 방법 3
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_move);
//
////        View.OnClickListener listener = new View.OnClickListener() { // B(1)
////            @Override // B(2)
////            public void onClick(View v) {
////                Toast.makeText(ActivityMoveActivity.this, "잘 되나?", Toast.LENGTH_SHORT).show(); // B(3)
////            }
////        };
//
//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() { // C(1) new O... Enter
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ActivityMoveActivity.this, "잘 되나?", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
    // 방법 4
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
        findViewById(R.id.basketball_button).setOnClickListener(new View.OnClickListener() { // 코드로 하는 방법 중 best. cf. xml onClick
            @Override
            public void onClick(View v) {
//                Toast.makeText(ActivityMoveActivity.this, "잘 되나?", Toast.LENGTH_SHORT).show();
                // 의도
                // 화면 새로 띄우는 코드
                Intent intent = new Intent(ActivityMoveActivity.this, BasketballActivity.class);
                startActivity(intent);
            }
        });
    }
}
