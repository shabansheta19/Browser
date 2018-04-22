package com.example.shaban.browser;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class WebViewActivity extends AppCompatActivity {

    public static String msg = "www.google.com.eg";
    private EditText uri_edit_text;
    private WebView webView;
    private ProgressBar progressBar;
    private ImageView backward_btn;
    private ImageView forward_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_web_view);

        webView = (WebView)findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClientDemo());
        webView.setWebChromeClient(new WebChromeClientDemo());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                download(url);
            }
        });


        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(100);

        uri_edit_text = (EditText)findViewById(R.id.uri_edit_text);
        uri_edit_text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE) {
                    open_website(v.getText().toString());
                }
                return false;
            }
        });

        backward_btn = (ImageView)findViewById(R.id.backward);
        forward_btn = (ImageView)findViewById(R.id.forward);
        backward_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();
            }
        });
        forward_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goForward();
            }
        });

        open_website(msg);
    }

    private void open_website(String website_uri) {
        if (website_uri.startsWith("http://")) {
            uri_edit_text.setHint(website_uri);
            webView.loadUrl(website_uri);
        } else {
            uri_edit_text.setText("http://" + website_uri);
            webView.loadUrl("http://" + website_uri);
        }
    }

    private void download(String url) {
        DownloadActivity.downloadUri = url;
        Intent intent = new Intent(this,DownloadActivity.class);
        startActivity(intent);
    }


    private class WebViewClientDemo extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            progressBar.setProgress(100);
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(0);
        }

    }

    private class WebChromeClientDemo extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int progress) {
            progressBar.setProgress(progress);
        }
    }

    public void return_to_home(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
