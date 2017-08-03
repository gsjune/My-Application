package com.hckim.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CoffeeActivity extends AppCompatActivity {

    private TextView mQuantityTextView;
    private TextView mPriceTetView; // B(1)
    private int mQuantity = 1; // (2)''

    private DecimalFormat mFormat = new DecimalFormat("#,##0"); // C(1)

    // 메인
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 레이아웃 설정
        setContentView(R.layout.activity_coffee); // 레퍼런스

        // xml에 있는 View의 레퍼런스를 가져오는 방법
//        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text); (2) Find Action field
        mQuantityTextView = (TextView) findViewById(R.id.quantity_text); // (2)' cf. 우클릭 refactor
        mPriceTetView = (TextView) findViewById(R.id.price_text); // B(2)
//        Button minusButton = (Button) findViewById(R.id.minus_button); // onClick 방법 쓴다
//        Button plusButton = (Button) findViewById(R.id.plus_button);

//        quantityTextView.setText("10"); // 10 테스트. setText()는 텍스트 바꿈.
        mQuantityTextView.setText("" + mQuantity); // (2)''' "" + mQuantity
        mPriceTetView.setText(mFormat.format(mQuantity * 3000) + "원"); // B(3) C(4)
    }

    public void minusButtonClicked(View view) { // (1) 전역변수 필요
//        Toast.makeText(this, "잘 눌림", Toast.LENGTH_SHORT).show();
        mQuantity--;
        if (mQuantity < 1) { // (5)
            mQuantity = 1;
        }
        mQuantityTextView.setText("" + mQuantity); // (3) (2)''' 복사
//        mPriceTetView.setText(mQuantity * 3000 + "원"); // B(4)
        mPriceTetView.setText(mFormat.format(mQuantity * 3000) + "원"); // C(2)
    }

    public void plusButtonClicked(View view) {
        mQuantity++;
        mQuantityTextView.setText("" + mQuantity); // (4)
//        mPriceTetView.setText(mQuantity * 3000 + "원"); // B(5)
        mPriceTetView.setText(mFormat.format(mQuantity * 3000) + "원"); // C(3)
    }
}
