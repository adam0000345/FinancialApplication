package com.example.finance.googlesheetsexample;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;



import com.example.finance.googlesheetsexample.androidlabs.gsheets1.JSONparser;
import com.example.finance.googlesheetsexample.androidlabs.gsheets1.MyArrayAdapter;
import com.example.finance.googlesheetsexample.androidlabs.gsheets1.MyDataModel;
import com.example.finance.googlesheetsexample.util.InternetConnection;
import com.example.finance.googlesheetsexample.util.Keys;
import com.facebook.drawee.backends.pipeline.Fresco;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserList extends NavBarAndTitle {

    private ListView listView;
    private ArrayList<MyDataModel> list;
    private MyArrayAdapter adapter;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waitingscreentopullexceldata);
        Fresco.initialize(this);

        //!!!!!!!!!!!!!FORMAT THIS EVENTUALLY!!!!!!!!!!!!!!!!!!!!!
        //Below is repeat code from the NavBarAndTitle, NavBarAndTitle and Userlist use
        //the same code as below, see if there is a way to condense this

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.baseline_menu_black_18dp);



        mDrawerLayout = findViewById(R.id.drawer_layout);


        NavigationView navigationView = findViewById(R.id.nav_view);
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

                        return true;
                    }
                });

        /**
         * Array List for Binding Data from JSON to this List
         */
        list = new ArrayList<>();
        /**
         * Binding that List to Adapter
         */
        adapter = new MyArrayAdapter(this, list);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //list.get(position).getPhone()
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(findViewById(R.id.parentLayout), list.get(position).getYear() + " => " + list.get(position).getCashFlowToEquity(), Snackbar.LENGTH_LONG).show();
            }
        });

        /**
         * Just to know onClick and Printing Hello Toast in Center.
         */
        Toast toast = Toast.makeText(getApplicationContext(), "Click on FloatingActionButton to Load JSON", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View view) {

                /**
                 * Checking Internet Connection
                 */
                if (InternetConnection.checkConnection(getApplicationContext())) {
                    new GetDataTask().execute();

                } else {
                    Snackbar.make(view, "Internet Connection Not Available", Snackbar.LENGTH_LONG).show();
                }


            }
        });


    }

    /**
     * Creating Get Data Task for Getting Data From Web
     */
    class GetDataTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog dialog;
        int jIndex;
        int x;



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            /**
             * Progress Dialog for User Interaction
             */

            x=list.size();

            if(x==0)
                jIndex=0;
            else
                jIndex=x;

            dialog = new ProgressDialog(UserList.this);
            dialog.setTitle("Hey Wait Please..."+x);
            dialog.setMessage("I am getting your JSON");
            dialog.show();
        }

        @Nullable
        @Override
        protected Void doInBackground(Void... params) {

            /**
             * Getting JSON Object from Web Using okHttp
             */
            JSONObject jsonObject = JSONparser.getDataFromWeb();

            try {
                /**
                 * Check Whether Its NULL???
                 */
                if (jsonObject != null) {
                    /**
                     * Check Length...
                     *
                     *
                     */
                    if(jsonObject.length() > 0) {
                        /**
                         * Getting Array named "contacts" From MAIN Json Object
                         */
                        JSONArray array = jsonObject.getJSONArray(Keys.KEY_ENTRY);

                        /**
                         * Check Length of Array...
                         */


                        int lenArray = array.length();
                        if(lenArray > 0) {
                            for(jIndex = 0; jIndex <= lenArray; jIndex++) {

                                /**
                                 * Creating Every time New Object
                                 * and
                                 * Adding into List
                                 */
                                MyDataModel model = new MyDataModel();

                                /**
                                 * Getting Inner Object from contacts array...
                                 * and
                                 * From that We will get Name of that Contact
                                 *
                                 */
                                JSONObject innerObject = array.getJSONObject(jIndex);

                                //Log.e("MYAPP", "unexpected JSON exception", e);

                                try {
                                    int year = innerObject.getInt(Keys.KEY_YEAR);
                                    int cashflowtoequity = innerObject.getInt(Keys.KEY_CFTOEQUITY);
                                    int cashflowtofirm = innerObject.getInt(Keys.KEY_CFTOFIRM);
                                    int difference = innerObject.getInt(Keys.KEY_DIFFERENCE);

                                    model.setYear(year);
                                    model.setCashFlowToEquity(cashflowtoequity);
                                    model.setCashFlowToFirm(cashflowtofirm);
                                    model.setDifference(difference);

                                }
                                //probably not best practice here, this can be improved
                                catch (JSONException je) {
                                    Log.i(JSONparser.TAG, "JSONPARSER error" + je.getLocalizedMessage());

                                    //not needed
                                    model.flipTerminalboolean();

                                    try {

                                        int terminalcashflowtoequity = innerObject.getInt(Keys.KEY_TERMINALCFTOEQUITY);
                                        int terminalcashflowtofirm = innerObject.getInt(Keys.KEY_TERMINALCFTOFIRM);
                                        int terminaldifference = innerObject.getInt(Keys.KEY_TERMINALDIFFERENCE);

                                        model.setTerminalCashFlowToEquity(terminalcashflowtoequity);
                                        model.setTerminalCashFlowToFirm(terminalcashflowtofirm);
                                        model.setTerminaldifference(terminaldifference);
                                    }
                                    catch(JSONException JE){
                                        Log.i(JSONparser.TAG, "JSONPARSER error" + JE.getLocalizedMessage());
                                    }


                                }


                                /**
                                 * Getting Object from Object "phone"
                                 */
                                //JSONObject phoneObject = innerObject.getJSONObject(Keys.KEY_PHONE);
                                //String phone = phoneObject.getString(Keys.KEY_MOBILE);


                                /**
                                 * Adding numeric values from excel sheet to List...
                                 */
                                list.add(model);
                            }
                        }
                    }
                } else {

                }
            } catch (JSONException je) {
                Log.i(JSONparser.TAG, "JSONPARSER error" + je.getLocalizedMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
            /**
             * Checking if List size if more than zero then
             * Update ListView
             */


            if(list.size() > 0) {
                adapter.notifyDataSetChanged();
                //use the fetched data for calculations here

                double EquityValue = 0;
                double ValueOfFirm = 0;

                for (int i=0; i < adapter.getCount(); i++){
                    MyDataModel dataModel = adapter.getItem(i);


                    //int FreeCashFlowToEquity = Net Income - (Capital Expenditures - Depreciation) -
                            //(Change in Non-cash Working Capital)+ (New Debt Issued - Debt Repayments)

                    //assuming Two-stage FCFE model, designed to value a firm which is expected to grow
                    //much faster than a stable firm in the initial period and at a stable rate after that.

                    //calculate Return on Equity
                    //Return on Equity = Net Income/Shareholder's Equity
                    //int ReturnOnEquity = 0/0;


                    int TerminalValueCFToEquity  = 0;
                    int TerminalValueDifference = 0;
                    int TerminalValueCFToFirm = 0;

                    //EquityValue = EquityValue += ((Double.valueOf(dataModel.getCashFlowToEquity()))/(Math.pow(1+CostOfEquity, i+1)));
                    //ValueOfFirm = ValueOfFirm += ((Double.valueOf(dataModel.getCashFlowToFirm()))/(Math.pow(1+CostOfEquity, i+1)));
                }

            } else {
                Snackbar.make(findViewById(R.id.parentLayout), "No Data Found", Snackbar.LENGTH_LONG).show();
            }
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}