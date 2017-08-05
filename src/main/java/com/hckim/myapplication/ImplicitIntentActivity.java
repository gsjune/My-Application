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
}