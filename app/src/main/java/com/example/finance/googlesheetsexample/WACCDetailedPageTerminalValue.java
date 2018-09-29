package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;

public class WACCDetailedPageTerminalValue extends NavBarAndTitle {



    private TextView WACCDetailedPageTerminalValueSubTitle;
    private TextView WACCDetailedPageTerminalValueTerminalROIC;
    private TextView WACCDetailedPageTerminalValueTerminalReinvestmentRate;
    private TextView WACCDetailedPageTerminalValueTerminalGrowthRate;
    private TextView WACCDetailedPageTerminalValueTerminalWACC;


    private TextView WACCDetailedPageTerminalValueTerminalROICValue;
    private TextView WACCDetailedPageTerminalValueTerminalReinvestmentRateValue;
    private TextView WACCDetailedPageTerminalValueTerminalGrowthRateValue;
    private TextView WACCDetailedPageTerminalValueTerminalWACCValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getLayoutInflater().inflate(R.layout.waccdetailedpageterminalvalue,
                frameLayout);




        WACCDetailedPageTerminalValueSubTitle = (TextView) this.findViewById(R.id.
                WACCDetailedPageTerminalValueSubTitle);
        WACCDetailedPageTerminalValueSubTitle.setText("TERMINAL VALUE");


        //Terminal ROIC

        WACCDetailedPageTerminalValueTerminalROIC = (TextView) this.
                findViewById(R.id.WACCDetailedPageTerminalValueTerminalROIC);
        WACCDetailedPageTerminalValueTerminalROIC.setText("Terminal ROIC \n(%)");

        WACCDetailedPageTerminalValueTerminalROIC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopUpWindow popUpWindow = new PopUpWindow();
                //TODO: look into setting text like above way
                //Logic
                Intent intent = new Intent(WACCDetailedPageTerminalValue.this, PopUpWindow.class);
                intent.putExtra("flagExcelViewer", "false");
                intent.putExtra("message", "If you chose the option to calculate g using the " +
                        "formula ROICxRR in the 'Few Key Questions' page, you will input the ROIC assumption here. " +
                        "Otherwise, it will be grayed out.  If you have a firm with exceptional competitive " +
                        "advantages, you can input an ROIC that is higher than your cost of capital.");

                startActivity(intent);

            }



        });

        WACCDetailedPageTerminalValueTerminalROICValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageTerminalValueTerminalROICValue);

        WACCDetailedPageTerminalValueTerminalROICValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA

                    getWaccDetailedObject().setTerminalROIC(Double.valueOf(WACCDetailedPageTerminalValueTerminalROICValue.getText().toString()));
                    Log.d("TEST", getWaccDetailedObject().getCompanyName());
                }

            }
        });

        // Terminal reinvestment rate

        WACCDetailedPageTerminalValueTerminalReinvestmentRate = (TextView) this.findViewById(R.id.
                WACCDetailedPageTerminalValueTerminalReinvestmentRate);
        WACCDetailedPageTerminalValueTerminalReinvestmentRate.setText("Terminal reinvestment rate \n(RR: %)");

        //TODO: Get subscripts to work properly
        WACCDetailedPageTerminalValueTerminalReinvestmentRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Logic
                Intent intent = new Intent(WACCDetailedPageTerminalValue.this, PopUpWindow.class);

                intent.putExtra("flagExcelViewer", "false");
                intent.putExtra("message", "If you chose the option to calculate g using the " +
                        "formula ROICxRR in the 'Few Key Questions' page, you will input the reinvestment rate (RR) " +
                        "assumption here.  Otherwise, it will be grayed out.  Enter an RR that is consistent with a g " +
                        "equal to rF or to the long-run nominal growth rate of GDP.");

                startActivity(intent);

                //





            }


        });

        WACCDetailedPageTerminalValueTerminalReinvestmentRateValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageTerminalValueTerminalReinvestmentRateValue);


        WACCDetailedPageTerminalValueTerminalReinvestmentRateValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA

                    getWaccDetailedObject().setTerminalReinvestmentRate(
                            Double.valueOf(WACCDetailedPageTerminalValueTerminalReinvestmentRateValue
                                    .getText().toString()));
                    Log.d("TEST", getWaccDetailedObject().getCompanyName());
                }

            }
        });

        // Terminal growth rate (g: %)

        WACCDetailedPageTerminalValueTerminalGrowthRate = (TextView) this.findViewById
                (R.id.WACCDetailedPageTerminalValueTerminalGrowthRate);
        WACCDetailedPageTerminalValueTerminalGrowthRate.setText("Terminal growth rate \n(g: %)");

        //TODO: Get subscripts to work properly
        WACCDetailedPageTerminalValueTerminalGrowthRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Logic
                Intent intent = new Intent(WACCDetailedPageTerminalValue.this, PopUpWindow.class);
                intent.putExtra("flagExcelViewer", "false");
                intent.putExtra("message", "Terminal Value (TV) is the continuing value of " +
                        "the business after the detailed forecast (or, 'proforma') period ends.  It is " +
                        "calculated using the constant growth model: \n\n TV = FCFFr + (WACCr-g), \n\n" +
                        "where FCFFr is the cash flow in the first period after the forecast period ends " +
                        "(if the forecast period is seven years, this year 8), WACCr is the cost of capital " +
                        "in perpetuity after the forecast period, and g is the Terminal Growth Rate (the growth " +
                        "rate in free cash flow in perptuity).\n\nThe enterprise value, EV, is the present value " +
                        "of TV plus the present value of cash flows for each year of the proforma period. \n\n" +
                        "Some analysts use multiples (e.g. EV/EBITDA, EV/SALES) to estimate TV.  However, g is " +
                        "implicit (and therefore, hidden) in a multiple, while it is made explicit in the " +
                        "constant growth model.  Moreover, the danger with using this approach is that it undercuts " +
                        "the very notion of this being a discounted cash flow or an intrinsic valuation, and makes " +
                        "this instead a relative valuation.");

                startActivity(intent);

                //





            }


        });

        WACCDetailedPageTerminalValueTerminalGrowthRateValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageTerminalValueTerminalGrowthRateValue);

        WACCDetailedPageTerminalValueTerminalGrowthRateValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA

                    getWaccDetailedObject().setTerminalReinvestmentRate(
                            Double.valueOf(WACCDetailedPageTerminalValueTerminalGrowthRateValue
                                    .getText().toString()));
                    Log.d("TEST", getWaccDetailedObject().getCompanyName());
                }

            }
        });



        //Terminal WACC


        WACCDetailedPageTerminalValueTerminalWACC = (TextView) this.findViewById
                (R.id.WACCDetailedPageTerminalValueTerminalWACC);
        WACCDetailedPageTerminalValueTerminalWACC.setText("Terminal WACC \n(%)");

        //TODO: Get subscripts to work properly
        WACCDetailedPageTerminalValueTerminalWACC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Logic
                Intent intent = new Intent(WACCDetailedPageTerminalValue.this, PopUpWindow.class);
                intent.putExtra("flagExcelViewer", "false");
                intent.putExtra("message", "You can choose to input a long-run terminal WACC " +
                        "that is different from the default WACC, which is the cost of capital for the proforma period. " +
                        "One option may be the industry average.  Another, the market average.");

                //


                startActivity(intent);


            }


        });

        WACCDetailedPageTerminalValueTerminalWACCValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageTerminalValueTerminalWACCValue);

        WACCDetailedPageTerminalValueTerminalWACCValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA

                    getWaccDetailedObject().setTerminalReinvestmentRate(
                            Double.valueOf(WACCDetailedPageTerminalValueTerminalWACCValue
                                    .getText().toString()));
                    Log.d("TEST", getWaccDetailedObject().getCompanyName());
                }

            }
        });

    }




}




