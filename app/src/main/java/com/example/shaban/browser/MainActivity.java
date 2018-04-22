package com.example.shaban.browser;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ImageView google;
    private ImageView facebook;
    private ImageView youtube;
    private ImageView history;
    private ImageView cancel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.home_edit_text);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                WebViewActivity.msg = v.getText().toString();
                if(actionId == EditorInfo.IME_ACTION_DONE) {
                    goto_new_tap();
                }
                return false;
            }
        });


        cancel_btn = (ImageView)findViewById(R.id.home_cancel_btn);
        cancel_btn.setVisibility(View.INVISIBLE);
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                cancel_btn.setVisibility(View.INVISIBLE);
            }
        });

        google = (ImageView)findViewById(R.id.google);
        facebook = (ImageView)findViewById(R.id.facebook);
        youtube = (ImageView)findViewById(R.id.youtube);
        history = (ImageView)findViewById(R.id.history_img);

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(),HistoryActivity.class);
                download("");
                //startActivity(intent);
            }
        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewActivity.msg = "www.google.com.eg";
                goto_new_tap();
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewActivity.msg = "www.facebook.com";
                goto_new_tap();
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewActivity.msg = "www.youtube.com.eg";
                goto_new_tap();
            }
        });
    }

    private void goto_new_tap() {
        Intent intent = new Intent(this,WebViewActivity.class);
        startActivity(intent);
    }

    private void download(String url) {
        DownloadActivity.downloadUri = url;
        Intent intent = new Intent(this,DownloadActivity.class);
        startActivity(intent);
    }
}
