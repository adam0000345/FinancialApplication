package com.example.finance.googlesheetsexample;

import android.os.Bundle;
import androidx.annotation.Nullable;

import androidx.drawerlayout.widget.DrawerLayout;
import android.widget.ListView;

public class MainMenu extends FirstScreenToShowMenu {


    /**
     * ListView to add navigation drawer item in it.
     * We have made it protected to access it in child class. We will just use it in child class to make item selected according to activity opened.
     */

    protected ListView mDrawerList;



    /**
     *  Base layout node of this Activity.
     * */
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.mainmenu, frameLayout);


    }

}
