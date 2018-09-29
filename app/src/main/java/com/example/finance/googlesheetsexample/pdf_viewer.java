package com.example.finance.googlesheetsexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class pdf_viewer extends AppCompatActivity{

    PDFView pdfviewer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdfviewer);
        pdfviewer = (PDFView) findViewById(R.id.pdfviewer);

        //TODO: Find a way to do an autozoom
        pdfviewer.fromAsset("uValuebook.pdf").defaultPage(36).enableSwipe(true).load();
    }
}
