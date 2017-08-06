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

        // 요거 해 줘야 한다
        mWebView.setWebViewClient(new WebViewClient()); // D(1) 여기에서 한 번만 해 주면 된다
        // 자바스크립트 사용하는 페이지를 볼 수 있게
        mWebView.getSettings().setJavaScriptEnabled(true); // D(2) D(1)과 D(2) 두 줄은 필수
    }
//    // 기본
//    public void showWebPage(View view) { // (1)
//        String url = mUrlEditext.getText().toString();
//        mWebView.loadUrl(url); // (6) (8) 괄호 안
//
//        // 요거 해 줘야 한다
//        mWebView.setWebViewClient(new WebViewClient()); // (9) 중요
    // 응용
    public void showWebPage(View view) { // C(1)
        String url = mUrlEditext.getText().toString();

        if (url.startsWith("http://") || url.startsWith("https://")) {
            mWebView.loadUrl(url);
        } else {
            mWebView.loadUrl("https://" + url);
        }
    }

    public void goBack(View view) { // B(1)
        mWebView.goBack();
    }

    public void goForward(View view) { // B(2)
        mWebView.goForward();
    }

    @Override
    public void onBackPressed() { // B(3) onb... Enter
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed(); // 종료
        }
    }
}
