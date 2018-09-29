package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class WACCDetailedPageModelInputsOne extends NavBarAndTitle {

    private DrawerLayout mDrawerLayout;
    private TextView WACCDetailedPageModelInputsOneTitle;
    private TextView WACCDetailedPageModelInputsOneCompanyNameValue;
    private TextView WACCDetailedPageModelInputsOneCompanyNameText;
    private TextView WACCDetailedPageModelInputsOneBaseYear;
    private TextView WACCDetailedPageModelInputsOneBaseYearValue;
    private TextView WACCDetailedPageModelInputsOneNumberForecastPeriods;
    private TextView WACCDetailedPageModelInputsOneNumberForecastPeriodsValue;
    private TextView WACCDetailedPageModelInputsOneBaseYearRevenue;
    private TextView WACCDetailedPageModelInputsOneBaseYearRevenueValue;
    private TextView WACCDetailedPageModelInputsOneAnnualRevenueGrowthRate;
    private TextView WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateValue;
    private TextView WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminal;
    private TextView WACCDetailedPageModelInputsOneCostGoodsSold;
    private TextView WACCDetailedPageModelInputsOneCostGoodsSoldValue;
    private ToggleButton WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButton;
    private TextView WACCDetailedPageModelInputsOneCostGoodsSoldButton;
    private TextView WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateButton;
    private boolean WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButtonCondition;


    //TODO add ability to pull data from website
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getLayoutInflater().inflate(R.layout.waccdetailedpagemodelinputsone, frameLayout);




        WACCDetailedPageModelInputsOneTitle = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneTitle);
        WACCDetailedPageModelInputsOneTitle.setText("'WACC: Detailed' Model Inputs: Free Cash Flow " +
                "(FCFF)");


        WACCDetailedPageModelInputsOneCompanyNameText = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneCompanyNameText);
        WACCDetailedPageModelInputsOneCompanyNameText.setText("Company Name");


        WACCDetailedPageModelInputsOneCompanyNameValue = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsOneCompanyNameInput);



        //do error checking, implement Excel here

        WACCDetailedPageModelInputsOneCompanyNameValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if(!hasFocus) {
                        //SAVE THE DATA

                        getWaccDetailedObject().setCompanyName(WACCDetailedPageModelInputsOneCompanyNameValue.getText().toString());
                        Log.d("TEST", getWaccDetailedObject().getCompanyName());
                    }

                }
            });







        WACCDetailedPageModelInputsOneBaseYear = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneBaseYear);
        WACCDetailedPageModelInputsOneBaseYear.setText("Base Year");

        WACCDetailedPageModelInputsOneBaseYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, PopUpWindow.class);



                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });


        WACCDetailedPageModelInputsOneBaseYearValue = (EditText)
                this.findViewById
                        (R.id.
                                WACCDetailedPageModelInputsOneBaseYearValue);

        WACCDetailedPageModelInputsOneBaseYearValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA


                    getWaccDetailedObject().setBaseYear(Integer.getInteger(
                            WACCDetailedPageModelInputsOneBaseYearValue.getText().toString()));
                    Log.d("TEST", String.valueOf(getWaccDetailedObject().getBaseYear()));
                }

            }
        });




        //Number of Forecast Periods

        WACCDetailedPageModelInputsOneNumberForecastPeriods = (TextView) this.findViewById
                (R.id.WACCDetailedPageModelInputsOneNumberForecastPeriods);
        WACCDetailedPageModelInputsOneNumberForecastPeriods.setText("Number of forecast periods");

        WACCDetailedPageModelInputsOneNumberForecastPeriods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });


        WACCDetailedPageModelInputsOneNumberForecastPeriodsValue = (EditText)
                this.findViewById
                        (R.id.
                                WACCDetailedPageModelInputsOneNumberForecastPeriodsValue);

        WACCDetailedPageModelInputsOneNumberForecastPeriodsValue
                .setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA


                    getWaccDetailedObject().setBaseYear(Integer.getInteger(
                            WACCDetailedPageModelInputsOneNumberForecastPeriodsValue.getText().toString()));
                    Log.d("TEST", String.valueOf(getWaccDetailedObject().getNumberOfForecastPeriods()));
                }

            }
        });



        //Base year revenue input

        WACCDetailedPageModelInputsOneBaseYearRevenue = (TextView) this.findViewById
                (R.id.WACCDetailedPageModelInputsOneBaseYearRevenue);

        WACCDetailedPageModelInputsOneBaseYearRevenue .setText("Base your revenue ($ millions)");

        WACCDetailedPageModelInputsOneBaseYearRevenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });


        WACCDetailedPageModelInputsOneBaseYearRevenueValue = (EditText)
                this.findViewById
                        (R.id.WACCDetailedPageModelInputsOneBaseYearRevenueValue);


        WACCDetailedPageModelInputsOneBaseYearRevenueValue
                .setOnFocusChangeListener(new View.OnFocusChangeListener() {

                    public void onFocusChange(View v, boolean hasFocus) {
                        if(!hasFocus) {
                            //SAVE THE DATA


                            getWaccDetailedObject().setBaseRevenue(Integer.getInteger(
                                    WACCDetailedPageModelInputsOneBaseYearRevenueValue.getText().toString()));
                            Log.d("TEST", String.valueOf(getWaccDetailedObject().getNumberOfForecastPeriods()));
                        }

                    }
                });

        //Annual revenue growth rate

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRate = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneAnnualRevenueGrowthRate);

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRate.setText("Annual revenue growth rate (%)");

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRate.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, pdf_viewer.class);



                startActivity(intent);
                return false;
            }




        });


        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateValue = (EditText)
                this.findViewById(R.id.WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateValue);

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateValue
                .setOnFocusChangeListener(new View.OnFocusChangeListener() {

                    public void onFocusChange(View v, boolean hasFocus) {
                        if(!hasFocus) {
                            //SAVE THE DATA


                            getWaccDetailedObject().setAnnualRevenueGrowthPercentage(Double.valueOf(
                                    WACCDetailedPageModelInputsOneBaseYearRevenueValue.getText().toString()));
                            Log.d("TEST", String.valueOf(getWaccDetailedObject().getNumberOfForecastPeriods()));
                        }

                    }
                });

        //Revenue growth fade to terminal growth

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminal = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminal);

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminal.setText("Revenue growth fade to terminal growth?");

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButton = (ToggleButton) this.findViewById(R.id.WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButton);

        WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButtonCondition = true;
                    getWaccDetailedObject().setRevenueGrowthFadeToTerminalGrowth(true);
                }
                else{
                    WACCDetailedPageModelInputsOneAnnualRevenueGrowthRateToTerminalToggleButtonCondition = false;
                    getWaccDetailedObject().setRevenueGrowthFadeToTerminalGrowth(false);
                }
            }



        });

        //Cost of goods sold as % revenue

        WACCDetailedPageModelInputsOneCostGoodsSold = (TextView) this.findViewById(R.id.WACCDetailedPageModelInputsOneCostGoodsSold);

        WACCDetailedPageModelInputsOneCostGoodsSold.setText("Cost of goods sold as % revenue");

        WACCDetailedPageModelInputsOneCostGoodsSold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, PopUpWindow.class);

                intent.putExtra("message", "test");

                startActivity(intent);

            }

        });

        WACCDetailedPageModelInputsOneCostGoodsSold.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedPageModelInputsOne.this, pdf_viewer.class);



                startActivity(intent);
                return false;
            }




        });

        WACCDetailedPageModelInputsOneCostGoodsSoldValue = (EditText) this.findViewById(R.id.WACCDetailedPageModelInputsOneCostGoodsSoldValue);


        WACCDetailedPageModelInputsOneCostGoodsSoldValue
                .setOnFocusChangeListener(new View.OnFocusChangeListener() {

                    public void onFocusChange(View v, boolean hasFocus) {
                        if(!hasFocus) {
                            //SAVE THE DATA


                            getWaccDetailedObject().setCostOfGoodsSoldAsPercentage(Double.valueOf(
                                    WACCDetailedPageModelInputsOneCostGoodsSoldValue.getText().toString()));
                            Log.d("TEST", String.valueOf(getWaccDetailedObject().getCostOfGoodsSoldAsPercentage()));
                        }

                    }
                });





    }


}
