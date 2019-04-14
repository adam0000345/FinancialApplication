package com.example.finance.googlesheetsexample;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The primary activity of the demo application. The activity embeds the
 * {@link com.google.blockly.android.webview.BlocklyWebViewFragment}.
 */
public class MainActivity extends FirstScreenToShowMenu {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_main, frameLayout);


    }
}
