package com.hckim.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ImplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        // ...findViewById()... 원래 여기(필드)에서 하는 게 맞음. 예제를 버튼마다 여러 개 만들 것인데 메소드 안에서 하는 것으로
    }

    public void openWebBrowser(View view) {
        EditText urlEditText = (EditText) findViewById(R.id.url_edit);

        openWebPage(urlEditText.getText().toString());
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void dialPhone(View view) {
        EditText phoneEditText = (EditText) findViewById(R.id.phone_edit);

        dialPhoneNumber(phoneEditText.getText().toString());
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void sendMessage(View view) {
        EditText messageEditText = (EditText) findViewById(R.id.message_edit);

        sendTextMessage(messageEditText.getText().toString());
    }

    public void sendTextMessage(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
