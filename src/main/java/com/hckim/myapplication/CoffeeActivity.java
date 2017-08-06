package com.hckim.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CoffeeActivity extends AppCompatActivity {

    public static final int MIN_QUANTITY = 1; // D(1)의 결과
    public static final int DEFAULT_QUANTITY = 1; // D(2)의 결과
    public static final int COFFEE_PRICE = 3000; // D(3)의 결과
    private TextView mQuantityTextView;
    private TextView mPriceTextView; // B(1)
    private CheckBox mWhippedCreamCheckBox; // E(2)
    private EditText mNameEditText; // F(1)
    //    private int mQuantity = 1;
    private int mQuantity = DEFAULT_QUANTITY; // (2)'' D(2)

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
        mPriceTextView = (TextView) findViewById(R.id.price_text); // B(2)
        mWhippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_check); // E(3)
        mNameEditText = (EditText) findViewById(R.id.name_edit); // F(2)
//        Button minusButton = (Button) findViewById(R.id.minus_button); // onClick 방법 쓴다
//        Button plusButton = (Button) findViewById(R.id.plus_button);


////        quantityTextView.setText("10"); // 10 테스트. setText()는 텍스트 바꿈.
//        mQuantityTextView.setText("" + mQuantity); // (2)''' "" + mQuantity
//        mPriceTetView.setText(mFormat.format(mQuantity * COFFEE_PRICE) + "원"); // B(3) C(4) D(3)
//    }
//
//    public void minusButtonClicked(View view) { // (1) 전역변수 필요
////        Toast.makeText(this, "잘 눌림", Toast.LENGTH_SHORT).show();
//        mQuantity--;
////        if (mQuantity < 1) { // (5)
////            mQuantity = 1;
////        }
//        if (mQuantity < MIN_QUANTITY) { // D(1) 상수 Find Action constant
//            mQuantity = MIN_QUANTITY;
//        }
//        mQuantityTextView.setText("" + mQuantity); // (3) (2)''' 복사
////        mPriceTetView.setText(mQuantity * 3000 + "원"); // B(4)
//        mPriceTetView.setText(mFormat.format(mQuantity * COFFEE_PRICE) + "원"); // C(2)
//    }
//
//    public void plusButtonClicked(View view) {
//        mQuantity++;
//        mQuantityTextView.setText("" + mQuantity); // (4)
////        mPriceTetView.setText(mQuantity * 3000 + "원"); // B(5)
//        mPriceTetView.setText(mFormat.format(mQuantity * COFFEE_PRICE) + "원"); // C(3)
//    }


//        quantityTextView.setText("10"); // 10 테스트. setText()는 텍스트 바꿈.
        display(); // D(4)' D(4)의 결과
    }

    private void display() {
        mQuantityTextView.setText("" + mQuantity);

        String message = "주문자: " + mNameEditText.getText().toString(); // F(3)
        message += "\n휘핑크림 추가 여부: " + mWhippedCreamCheckBox.isChecked(); // E(4)
        message += "\n갯수: " + mQuantity;
        message += "\n가격: " + mFormat.format(mQuantity * COFFEE_PRICE) + "원";

//        mPriceTetView.setText(mFormat.format(mQuantity * COFFEE_PRICE) + "원"); // D(4) Alt Enter method
        mPriceTextView.setText(message); // E(5)
    }

    public void minusButtonClicked(View view) { // (1) 전역변수 필요
//        Toast.makeText(this, "잘 눌림", Toast.LENGTH_SHORT).show();
        mQuantity--;
//        if (mQuantity < 1) { // (5)
//            mQuantity = 1;
//        }
        if (mQuantity < MIN_QUANTITY) { // D(1) 상수 Find Action constant
            mQuantity = MIN_QUANTITY;
        }
        display(); // D(4)'' D(4)의 결과
    }

    public void plusButtonClicked(View view) {
        mQuantity++;
        display(); // D(4)''' D(4)의 결과
    }

    public void onCheckBoxClicked(View view) { // E(1)
//        Toast.makeText(this, "잘 되나?", Toast.LENGTH_SHORT).show();
        display();
    }

    public void order(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"master@suwonsmartapp.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "주문이요!!");
        intent.putExtra(Intent.EXTRA_TEXT, mPriceTextView.getText().toString());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }
    }
}
