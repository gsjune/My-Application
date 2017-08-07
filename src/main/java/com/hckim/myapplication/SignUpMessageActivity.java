package com.hckim.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignUpMessageActivity extends AppCompatActivity {

    private TextView mMessageTextView; // (2)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_message);

        mMessageTextView = (TextView) findViewById(R.id.message_text); // (3)

        Intent intent = getIntent(); // (1)
        if (intent != null) {
            String id = intent.getStringExtra("id");
            String password = intent.getStringExtra("password");
            String email = intent.getStringExtra("email");
            String gender = intent.getStringExtra("gender");

            mMessageTextView.setText(id + ", " + password + ", " + email + ", " + gender); // (4)
        }
    }

    public void confirm(View view) { // (5)
        setResult(RESULT_OK);
        finish();
    }
}
