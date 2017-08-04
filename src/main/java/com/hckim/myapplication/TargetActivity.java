package com.hckim.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        // 넘어온 데이터 받기
        Intent intent = getIntent();
        if (intent != null) {
            String message = intent.getStringExtra("data");
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    public void onFinishButtonClicked(View view) {
        // 액티비티 종료
        finish();
    }
}
