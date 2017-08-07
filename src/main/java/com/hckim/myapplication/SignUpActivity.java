package com.hckim.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_MESSAGE = 1000;
    private EditText mIdEditText; // (4)
    private EditText mPasswordEditText;
    private EditText mPasswordConfirmEditText;
    private EditText mEmailEditText;
    private RadioGroup mGenderRadioGroup; // (10)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mIdEditText = (EditText) findViewById(R.id.id_edit); // (5)
        mPasswordEditText = (EditText) findViewById(R.id.password_edit);
        mPasswordConfirmEditText = (EditText) findViewById(R.id.password_confirm_edit);
        mEmailEditText = (EditText) findViewById(R.id.email_edit);
        mGenderRadioGroup = (RadioGroup) findViewById(R.id.gender_group); // (10)'

        // 버튼 이벤트
        findViewById(R.id.reset_button).setOnClickListener(this); // (1) Alt Enter
        findViewById(R.id.sign_up_button).setOnClickListener(this); // (2)
    }

    @Override // (1)의 결과
    public void onClick(View v) {
        switch (v.getId()) { // (3)
            case R.id.reset_button:
                break;
            case R.id.sign_up_button:
//                if (mIdEditText.getText().toString().equals(""))
//                if (TextUtils.isEmpty(mEmailEditText.getText().toString()) ||
//                        TextUtils.isEmpty(mPasswordEditText.getText().toString()) ||
//                        TextUtils.isEmpty(mPasswordConfirmEditText.getText().toString()) ||
//                        TextUtils.isEmpty(mEmailEditText.getText().toString())) { // (6)
                if (isEditTextEmpty()) { // (7) if () 안만 드래그 Find Action method
                    Toast.makeText(this, "모두 입력해 주셔야 합니다", Toast.LENGTH_SHORT).show();
                    return;
                }

//                if (!mPasswordEditText.getText().toString().equals(mPasswordConfirmEditText.getText().toString())) {
                if (isInvalidPassword()) { // (8) if () 안만 드래그 Find Action method
//                if (mPasswordEditText.getText().toString().equals(mPasswordConfirmEditText.getText().toString()) == false)
                    Toast.makeText(this, "비밀번호가 다릅니다", Toast.LENGTH_SHORT).show();
                    return;
                }

                String gender = "남성"; // (10)''
                if (mGenderRadioGroup.getCheckedRadioButtonId() == R.id.female_radio_button) {
                    gender = "여성";
                }

//                String gender = ((RadioButton)findViewById(mGenderRadioGroup.getCheckedRadioButtonId())).getText().toString();

                Intent intent = new Intent(SignUpActivity.this, SignUpMessageActivity.class); // (9)
                intent.putExtra("id", mIdEditText.getText().toString());
                intent.putExtra("password", mPasswordEditText.getText().toString());
                intent.putExtra("email", mEmailEditText.getText().toString());
                intent.putExtra("gender", gender); // (10)'''
//                startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE_MESSAGE);

                break;
        }
    }

    private boolean isInvalidPassword() { // (8)의 결과
        return !mPasswordEditText.getText().toString().equals(mPasswordConfirmEditText.getText().toString());
    }

    private boolean isEditTextEmpty() { // (7)의 결과
        return TextUtils.isEmpty(mEmailEditText.getText().toString()) ||
                TextUtils.isEmpty(mPasswordEditText.getText().toString()) ||
                TextUtils.isEmpty(mPasswordConfirmEditText.getText().toString()) ||
                TextUtils.isEmpty(mEmailEditText.getText().toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MESSAGE || resultCode == RESULT_OK ) {
            Toast.makeText(this, "확인 버튼을 누르셨습니다", Toast.LENGTH_SHORT).show();
        }
    }
}
