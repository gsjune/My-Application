package com.hckim.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//public class LoginActivity extends AppCompatActivity implements View.OnClickListener { // (2) Implement methods
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
////        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() { // 최상의 방법 1.
////            @Override
////            public void onClick(View v) {
////
////            }
////        });
//
//        findViewById(R.id.login_button).setOnClickListener(this); // (1)
//    }
//
//    @Override
//    public void onClick(View v) { // (3) (2)의 결과
//
//    }
//}
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_LOGIN = 1000;
    private EditText mIdEditText; // (2)
    private EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mIdEditText = (EditText) findViewById(R.id.id_edit); // (3)
        mPasswordEditText = (EditText) findViewById(R.id.password_edit);

        findViewById(R.id.login_button).setOnClickListener(this); // (1) 최상의 방법 2(switch). Alt Enter Make 'LoginActivity' implement...

        /*
        this 자기 자신을 던졌으니까 AppCompatActivity 자기 자신이 View.OnClickListener를 구현해서
        추상 메소드를 오버라이드를 한 것이 @Override ... onClick이니까 seOnClickListener를 클릭하면
        onClick(View v) { 다음이 동작한다.
         */

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(); // (4)
        intent.putExtra("id", mIdEditText.getText().toString());
        intent.putExtra("password", mPasswordEditText.getText().toString());
        startActivityForResult(intent, REQUEST_CODE_LOGIN); // 보내고
    }

    @Override // 받고
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_LOGIN && resultCode == RESULT_OK && data != null) { // 조건을 자유롭게 준다
            String text = data.getStringExtra("text");
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }
}
