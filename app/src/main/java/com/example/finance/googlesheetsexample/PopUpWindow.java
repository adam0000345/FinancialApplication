package com.example.finance.googlesheetsexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class PopUpWindow extends Activity{

    private TextView TVmessage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popupwindow);

        DisplayMetrics displayMetrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        Intent intent = getIntent();
        String message = intent.getStringExtra("flagExcelViewer");

        if (message.equals("false")) {
            intent = getIntent();
            message = intent.getStringExtra("message");

            TVmessage = (TextView)  findViewById(R.id.PopUpMessage);
            TVmessage.setText(message);
        }
        else if (message.equals("true")) {



        }
        //TODO troubleshoot here if the flag does not contain either message
        else {

        }






        getWindow().setLayout((int) (width*.85), (int) (height *.85));
    }


}
