package com.hckim.myapplication.fragment.color;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hckim.myapplication.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    // 프래그먼트는 반드시 빈 생성자만 있어야 한다
    public ColorFragment() {
        // Required empty public constructor
    }

    public static ColorFragment newInstance(int color) { // B(1) new... Enter. B(2) () 안 int color

        Bundle args = new Bundle();
        args.putInt("color", color); // B(3)

        ColorFragment fragment = new ColorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static ColorFragment newInstance() { // C(1)

        Bundle args = new Bundle();

        int r = new Random().nextInt(256); // C(4) 아래에서 이동
        int g = new Random().nextInt(256);
        int b = new Random().nextInt(256);
        int color = Color.argb(255, r, g, b);

        args.putInt("color", color); // C(2)

        ColorFragment fragment = new ColorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) { // B(1) 색깔 랜덤으로 onvi... Enter
        super.onViewCreated(view, savedInstanceState);

//        int r = new Random().nextInt(256);
//        int g = new Random().nextInt(256);
//        int b = new Random().nextInt(256);
//        int color = Color.argb(255, r, g, b);

        int color = getArguments().getInt("color"); // C(3)

        view.setBackgroundColor(color);
    }

//    public void setColor(int color) {
//        getView().setBackgroundColor(color);
//    }
}
