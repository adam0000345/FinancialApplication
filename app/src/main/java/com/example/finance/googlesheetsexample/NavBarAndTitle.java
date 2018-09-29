package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;

import com.example.finance.googlesheetsexample.post.PostData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ADJ on 2/21/2017.
 */
public class NavBarAndTitle extends AppCompatActivity{

    Button getData;
    Button sendData;
    FrameLayout frameLayout;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();
    /**
     *  This flag is used just to check that launcher activity is called first time
     *  so that we can open appropriate Activity on launch and make list item position selected accordingly.
     * */
    private static boolean isLaunch = true;


    private WACCDetailedObject waccDetailedObject;


    private DrawerLayout mDrawerLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navbarandtitle);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.baseline_menu_black_18dp);
        frameLayout = (FrameLayout)findViewById(R.id.content_frame);

        waccDetailedObject = new WACCDetailedObject();


        expandableListView = findViewById(R.id.expandableListView);


        prepareMenuData();
        populateExpandableList();


        mDrawerLayout = findViewById(R.id.drawer_layout);


        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();


        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {


                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        //displaySelectedScreen(menuItem.getItemId());


                        return true;
                    }


                });

        if(isLaunch){
            /**
             *Setting this flag false so that next time it will not open our first activity.
             *We have to use this flag because we are using this BaseActivity as parent activity to our other activity.
             *In this case this base activity will always be call when any child activity will launch.
             */
            isLaunch = false;
            Intent intent = new Intent(getApplicationContext(), MainMenu.class);
            startActivity(intent);
        }


    };

    public  WACCDetailedObject getWaccDetailedObject(){
        return waccDetailedObject;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void displaySelectedScreen(String MenuName) {



        //initializing the Activity object which is selected
        switch (MenuName) {
            case "EquityvalueFirmvalue":
                Intent i = new Intent(getApplicationContext(), EquityValueFirmValue.class);
                startActivity(i);
                break;

        }

        //initializing the Activity object which is selected
        switch (MenuName) {
            case "WACCDetailedPageOne":
                Intent i = new Intent(getApplicationContext(), WACCDetailedPageOne.class);
                startActivity(i);
                break;

        }

        switch (MenuName) {
            case "WACCDetailedPageTwo":
                Intent i = new Intent(getApplicationContext(), WACCDetailedPageTwo.class);
                startActivity(i);
                break;

        }

        switch (MenuName) {
            case "WACCDetailedPageModelInputsOne":
                Intent i = new Intent(getApplicationContext(), WACCDetailedPageModelInputsOne.class);
                startActivity(i);
                break;

        }

        switch (MenuName) {
            case "WACCDetailedPageModelInputsTwo":
                Intent i = new Intent(getApplicationContext(), WACCDetailedPageModelInputsTwo.class);
                startActivity(i);
                break;

        }

        switch (MenuName) {
            case "WACCDetailedPageCostOfCapitalOne":
                Intent i = new Intent(getApplicationContext(), WACCDetailedPageCostOfCapitalOne.class);
                startActivity(i);
                break;

        }

        switch (MenuName) {
            case "WACCDetailedPageCostOfCapitalTwo":
                Intent i = new Intent(getApplicationContext(), WACCDetailedPageCostOfCapitalTwo.class);
                startActivity(i);
                break;

        }

        switch (MenuName) {
            case "WACCDetailedPageTerminalValue":
                Intent i = new Intent(getApplicationContext(), WACCDetailedPageTerminalValue.class);
                startActivity(i);
                break;

        }

        switch (MenuName) {
            case "WACCDetailedPageResults":
                Intent i = new Intent(getApplicationContext(), WACCDetailedPageResults.class);
                startActivity(i);
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

            case R.id.viweruser:
                Intent intent = new Intent(getApplicationContext(), UserList.class);
                startActivity(intent);
                return true;

            case R.id.adduser:
                intent = new Intent(getApplicationContext(), PostData.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



    private void prepareMenuData() {

        MenuModel menuModel = new MenuModel("EquityvalueFirmvalue", true, false);
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("WACCDetailed", true, true);
        headerList.add(menuModel);
        List<MenuModel> childModelsList = new ArrayList<>();
        MenuModel childModel = new MenuModel("WACCDetailedPageOne", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("WACCDetailedPageTwo", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("WACCDetailedPageModelInputsOne", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("WACCDetailedPageModelInputsTwo", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("WACCDetailedPageCostOfCapitalOne", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("WACCDetailedPageCostOfCapitalTwo", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("WACCDetailedPageTerminalValue", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("WACCDetailedPageResults", false, false);
        childModelsList.add(childModel);


        if (menuModel.hasChildren) {
            Log.d("API123","here");
            childList.put(menuModel, childModelsList);
        }


        menuModel = new MenuModel("WACSimple", true, false);
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("APVDetailed", true, false);
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("APVSimple", true, false);
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("Dividend Growth Model", true, false);
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("Real Options Valuation", true, false);
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("Not Sure", true, false);
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

    }

    private void populateExpandableList() {

        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (headerList.get(groupPosition).isGroup) {
                    if (!headerList.get(groupPosition).hasChildren) {

//                        WebView webView = findViewById(R.id.webView);
//                        webView.loadUrl(headerList.get(groupPosition).url);
                        displaySelectedScreen(headerList.get(groupPosition).menuName);
                        onBackPressed();

                        // close drawer when item is tapped
                        //mDrawerLayout.closeDrawers();
                    }
                }

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null) {
                    MenuModel model = childList.get(headerList.get(groupPosition)).get(childPosition);
                    //WebView webView = findViewById(R.id.webView);
                    //webView.loadUrl(model.url);
                    displaySelectedScreen(model.menuName);

                    onBackPressed();

                }

                return false;
            }
        });
    }



}

