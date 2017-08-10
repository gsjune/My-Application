package com.hckim.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LifeCycleActivity extends AppCompatActivity {

    private static final String TAG = LifeCycleActivity.class.getSimpleName();

    private int mNum = 0;
    private Button mButton; // B(4)

    // 액티비티가 실행될 때
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        mButton = (Button) findViewById(R.id.number_button); // B(5)

        // 초기화
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart: ");
    }

    // 재개, 화면이 보이기 직전
    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: ");

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this); // B(3) 복사 및 수정
        mNum = settings.getInt("number", 0);

        mButton.setText("" + mNum); // B(6)

        Log.d(TAG, "onResume: 복원");
    }

    // 일시 정지, 화면에서 안 보이기 직전
    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause: ");

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this); // B(2) 복사 및 수정
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("number", mNum);

        // Commit the edits! 비동기
        editor.apply();

        Log.d(TAG, "onPause: 저장");
    }

    // 정지, 화면에서 안 보이게 되면
    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop: ");
    }

    // 액티비티가 종료될 때
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 메모리 해제
        Log.d(TAG, "onDestroy: ");
    }

    public void showDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("test");
        builder.setMessage("test");
        builder.show();
    }

    public void increment(View view) { // B(1)
        mNum++;
        ((Button) view).setText("" + mNum);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) { // C(1)
        Log.d(TAG, "onSaveInstanceState: ");
        // 저장

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        // 복원
    }
}
