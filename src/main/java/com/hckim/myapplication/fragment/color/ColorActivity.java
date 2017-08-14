package com.hckim.myapplication.fragment.color;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hckim.myapplication.R;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }

//    public void onCreateFragmentButtonClicked(View view) {
//        // 새로운 프래그먼트를 생성
//
//        ColorFragment fragment = new ColorFragment();
//
//        // R.id.container 영역에 프래그먼트를 교체하겠다
//        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
//    }
    public void onCreateRedFragmentButtonClicked(View view) {

        ColorFragment fragment = ColorFragment.newInstance(Color.RED);

        // R.id.container 영역에 프래그먼트를 교체하겠다
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    public void onCreateGreenFragmentButtonClicked(View view) {
        ColorFragment fragment = ColorFragment.newInstance(Color.GREEN);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    public void onCreateBlueFragmentButtonClicked(View view) {
        ColorFragment fragment = ColorFragment.newInstance(Color.BLUE);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    public void onCreateRandomFragmentButtonClicked(View view) {
        ColorFragment fragment = new ColorFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
