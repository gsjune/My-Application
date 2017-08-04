package com.hckim.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Target2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target2);

        findViewById(R.id.management1_button).setOnClickListener(this); // (1)
        findViewById(R.id.management2_button).setOnClickListener(this);
        findViewById(R.id.management3_button).setOnClickListener(this);
    }

//    @Override // 방법 1
//    public void onClick(View v) { // (2)
//        switch (v.getId()) { // 눌린 것의 레퍼런스가 v로 들어온다
//            case R.id.management1_button:
//                Intent intent = new Intent();
//                intent.putExtra("text", "고객관리");
//                setResult(RESULT_OK);
//                finish();
//                break;
//            case R.id.management2_button:
//                break;
//            case R.id.management3_button:
//                break;
//        }
//    }
//    @Override // 방법 2 세련 공통된 부분 위 아래로 빼고
//    public void onClick(View v) {
//        Intent intent = new Intent();
//        switch (v.getId()) {
//            case R.id.management1_button:
//                intent.putExtra("text", "고객관리");
//                break;
//            case R.id.management2_button:
//                intent.putExtra("text", "매출관리");
//                break;
//            case R.id.management3_button:
//                intent.putExtra("text", "상품관리");
//                break;
//        }
//        setResult(RESULT_OK);
//        finish();
//    }
    @Override // 방법 3 가장 세련
    public void onClick(View v) {
        Intent intent = new Intent();
        String text = ((Button) v).getText().toString(); // v(뷰)를 Button으로 캐스팅. v(눌린 것)를 활용하는 방법
        intent.putExtra("text", text); // 눌린 것의 텍스트를 가져와서 넘긴다
        setResult(RESULT_OK);
        finish();
    }
}
