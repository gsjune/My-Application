package com.hckim.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView; // (2)
    private EditText mUrlEditext; // (5)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWebView = (WebView) findViewById(R.id.web_view); // (3)
        mUrlEditext = (EditText) findViewById(R.id.url_edit); // (4) Alt Enter Create field 'mUrlEditText'
    }

    public void showWebPage(View view) { // (1)
        String url = mUrlEditext.getText().toString();
        mWebView.loadUrl(url); // (6) (8) 괄호 안

        // 요거 해 줘야 한다
        mWebView.setWebViewClient(new WebViewClient()); // (9) 중요
    }

    public void goBack(View view) {
        mWebView.goBack();
    }

    public void goForward(View view) {
        mWebView.goForward();
    }
}
