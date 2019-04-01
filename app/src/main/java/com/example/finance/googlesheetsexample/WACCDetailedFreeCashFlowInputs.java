package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.drawerlayout.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class WACCDetailedFreeCashFlowInputs extends FirstScreenToShowMenu {

    private DrawerLayout mDrawerLayout;
    private TextView WACCDetailedFreeCashFlowInputsTitle;
    private TextView WACCDetailedFreeCashFlowInputsCompanyNameValue;
    private TextView WACCDetailedFreeCashFlowInputsCompanyNameText;
    private TextView WACCDetailedFreeCashFlowInputsBaseYear;
    private TextView WACCDetailedFreeCashFlowInputsBaseYearValue;
    private TextView WACCDetailedFreeCashFlowInputsNumberForecastPeriods;
    private TextView WACCDetailedFreeCashFlowInputsNumberForecastPeriodsValue;
    private TextView WACCDetailedFreeCashFlowInputsBaseYearRevenue;
    private TextView WACCDetailedFreeCashFlowInputsCurrentYearRevenueValue;
    private TextView WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRate;
    private TextView WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateValue;
    private TextView WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateToTerminal;
    private TextView WACCDetailedFreeCashFlowInputsCostGoodsSold;
    private TextView WACCDetailedFreeCashFlowInputsCostGoodsSoldValue;
    private ToggleButton WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateToTerminalToggleButton;
    private TextView WACCDetailedFreeCashFlowInputsCostGoodsSoldButton;
    private TextView WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateButton;
    private boolean WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateToTerminalToggleButtonCondition;
    private TextView WACCDetailedFreeCashFlowInputsSGA;
    private TextView WACCDetailedFreeCashFlowInputsSGAValue;
    private TextView WACCDetailedFreeCashFlowInputsInitialEBIT;
    private TextView WACCDetailedFreeCashFlowInputsInitialEBITValue;
    private TextView WACCDetailedFreeCashFlowInputsLastPeriodEBIT;
    private TextView WACCDetailedFreeCashFlowInputsLastPeriodEBITValue;
    private TextView WACCDetailedFreeCashFlowInputsCapitalExpenditure;
    private TextView WACCDetailedFreeCashFlowInputsCapitalExpenditureValue;
    private TextView WACCDetailedFreeCashFlowInputsOperatingNWC;
    private TextView WACCDetailedFreeCashFlowInputsOperatingNWCValue;
    private TextView WACCDetailedFreeCashFlowInputsStraightLineYears;
    private TextView WACCDetailedFreeCashFlowInputsStraightLineYearsValue;
    private TextView WACCDetailedFreeCashFlowInputsTaxRate;
    private TextView WACCDetailedFreeCashFlowInputsTaxRateValue;
    private TextView WACCDetailedFreeCashFlowInputsBaseYearDepreciation;
    private TextView WACCDetailedFreeCashFlowInputsBaseYearDepreciationValue;
    private WACCDetailedObject WACCDetailedObject;


    //TODO add ability to pull data from website

    //TODO add a vertical scroll with an animated floating "Submit" button

    //TODO use side scroll to go to next input section of model, for example:
    // TODO Free Cash Flow inputs to Cost Of Capital Inputs

    @Override
    protected void onCreate(Bundle savedInstanceState) {

       

        super.onCreate(savedInstanceState);


        getLayoutInflater().inflate(R.layout.waccdetailedpagefreecashflowinputs, frameLayout);


        WACCDetailedFreeCashFlowInputsTitle = (TextView) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsTitle);
        WACCDetailedFreeCashFlowInputsTitle.setText("'WACC: Detailed' Model Inputs: Free Cash Flow " +
                "(FCFF)");


        WACCDetailedFreeCashFlowInputsCompanyNameText = (TextView) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsCompanyNameText);
        WACCDetailedFreeCashFlowInputsCompanyNameText.setText("Company Name");


        WACCDetailedFreeCashFlowInputsCompanyNameValue = (EditText) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsCompanyNameInput);


        //do error checking, implement Excel here


        WACCDetailedFreeCashFlowInputsBaseYear = (TextView) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsBaseYear);
        WACCDetailedFreeCashFlowInputsBaseYear.setText("Base Year");

        WACCDetailedFreeCashFlowInputsBaseYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, PopUpWindow.class);


                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "If you are doing a valuation mid-year" +
                        ", the base year may span two years. for instance, you may have a fiscal " +
                        "year that ends in June 2011, or use trailing 12-month data from July " +
                        "2010 to June 2011.  The first year of the forecast will be labeled 2012 " +
                        "but it will represent the cash flow from July 2011 to " +
                        "June 2012.");

                startActivity(intent);

            }

        });


        WACCDetailedFreeCashFlowInputsBaseYearValue = (EditText)
                this.findViewById
                        (R.id.
                                WACCDetailedFreeCashFlowInputsBaseYearValue);


        //Number of Forecast Periods

        WACCDetailedFreeCashFlowInputsNumberForecastPeriods = (TextView) this.findViewById
                (R.id.WACCDetailedFreeCashFlowInputsNumberForecastPeriods);
        WACCDetailedFreeCashFlowInputsNumberForecastPeriods.setText("Number of forecast periods");

        WACCDetailedFreeCashFlowInputsNumberForecastPeriods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "We recommend using at least five " +
                        "forecast periods, but perhaps no more than ten.");

                startActivity(intent);

            }

        });


        WACCDetailedFreeCashFlowInputsNumberForecastPeriodsValue = (EditText)
                this.findViewById
                        (R.id.
                                WACCDetailedFreeCashFlowInputsNumberForecastPeriodsValue);


        //Base year revenue input

        WACCDetailedFreeCashFlowInputsBaseYearRevenue = (TextView) this.findViewById
                (R.id.WACCDetailedFreeCashFlowInputsBaseYearRevenue);

        WACCDetailedFreeCashFlowInputsBaseYearRevenue.setText("Base year revenue ($ millions)");

        WACCDetailedFreeCashFlowInputsBaseYearRevenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "This is the total revenue (sales) " +
                        "during the base year in US dollars (or in absolute terms). " +
                        "Once you have picked your units, make sure to stay consistent " +
                        "with those same units for your other inputs. \n\n " +
                        "In some instances, base year revenue may require to be " +
                        "'normalized.' This requries judgment, especially in " +
                        "cyclical businesses, industries whose revenues are " +
                        "dependent on commodity prices, or when base-year revenue " +
                        "and profits of the firms were subject to extraordinary " +
                        "exogenous shocks (e.g., a dotcom firm in the early 2000s, " +
                        "or a financial services firm in 2008-09).");


                startActivity(intent);

            }

        });


        WACCDetailedFreeCashFlowInputsCurrentYearRevenueValue = (EditText)
                this.findViewById
                        (R.id.WACCDetailedFreeCashFlowInputsBaseYearRevenueValue);


        //Annual revenue growth rate

        WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRate = (TextView) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRate);

        WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRate.setText("Annual revenue growth rate (%)");

        WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "This is one where mistakes are often made! " +
                        "Just calculating the firm's past compounded annual growth rates (CAGR) " +
                        "in revenue, and treating that as a basis for a future forecast will " +
                        "likely over- or underestimate growth rates. \n\n " +
                        "For instance, past CAGRs reflect revenue gained from acquisitions " +
                        "(overestimate) or that lost from divestitures and asset sales " +
                        "(underestimate). Similarly, they could reflect the positive or " +
                        "negative effects of a home currency depreciation or appreciation.  " +
                        "We recommend that revenue CAGR forecasts be based on organic (bolded) " +
                        "(i.e., non-acquisition), constant-currency (bolded) (i.e., no real " +
                        "exchange rate effects) growth rates.  In some instances, " +
                        "the industry growth rate can give you a better estimate, but even then, " +
                        "recognize that currency or cross-border acquisition effects might be " +
                        "present. \n\n Also, note that you can input negative revenue growth rates " +
                        "(but note they can't be negative forever!).  If you input a negative number " +
                        "here, a new screen will open up which will require you to input year-by-year " +
                        "growth rates (i.e., to allow you to change rates from negative to positive) " +
                        "during the forecast period.");

                startActivity(intent);

            }

        });

        WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRate.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, pdf_viewer.class);


                startActivity(intent);
                return false;
            }


        });


        WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateValue = (EditText)
                this.findViewById(R.id.WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateValue);


        //Revenue growth fade to terminal growth

        //TODO this can be changed to Different per-period revenue growth rates?

        WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateToTerminal = (TextView) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateToTerminal);

        WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateToTerminal.setText("Revenue growth fade to terminal growth?");

        WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateToTerminalToggleButton =
                (ToggleButton) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateToTerminalToggleButton);

        WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateToTerminalToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateToTerminalToggleButtonCondition = true;
                    WACCDetailedObject.setRevenueGrowthFadeToTerminalGrowth(true);
                } else {
                    WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateToTerminalToggleButtonCondition = false;
                    WACCDetailedObject.setRevenueGrowthFadeToTerminalGrowth(false);
                }
            }


        });

        //TO BE USED IN DIFFERENT PER_PERIOD REVENUE GROWTH RATES
//        intent.putExtra("isExcelPopup", "false");
//        intent.putExtra("message", "The default is set to 'NO'. If you wish to " +
//                "input a different revenue growth rate for each period, touch the " +
//                "button to change it to 'YES'. A new screen will open up which " +
//                "will give you the option to do so. \n\n The screen will also " +
//                "open up if you input a negative revenue growth rate in the previous " +
//                "cell, requiring you to input year-by-year growth rates" +
//                "(thereby allowing you to change rates from negative to positive) " +
//                "during the forecast period.");
//
//        startActivity(intent);


        //Cost of goods sold as % revenue
        //only show if option "Input % CGS and % SGA"
        //TODO make textviews be dynamically be added based off previous input

        TextView tvcostofgood = (TextView)findViewById(R.id.WACCDetailedFreeCashFlowInputsCostGoodsSold);
        tvcostofgood.setVisibility(View.INVISIBLE);
        TextView tvcostofgoodvalue = (TextView)findViewById(R.id.WACCDetailedFreeCashFlowInputsCostGoodsSoldValue);
        tvcostofgoodvalue.setVisibility(View.INVISIBLE);
        TextView tvFreeCashFlowInputsSGA = (TextView)findViewById(R.id.WACCDetailedFreeCashFlowInputsSGA);
        tvFreeCashFlowInputsSGA.setVisibility(View.INVISIBLE);
        TextView tvFreeCashFlowInputsSGAValue = (TextView)findViewById(R.id.WACCDetailedFreeCashFlowInputsSGAValue);
        tvFreeCashFlowInputsSGAValue.setVisibility(View.INVISIBLE);

        if (WACCDetailedObject.getOperatingIncomeOption() == "Will input percent CGS and percent SGA") {

            tvcostofgood = (TextView)findViewById(R.id.WACCDetailedFreeCashFlowInputsCostGoodsSold);
            tvcostofgood.setVisibility(View.VISIBLE);
            tvcostofgoodvalue = (TextView)findViewById(R.id.WACCDetailedFreeCashFlowInputsCostGoodsSoldValue);
            tvcostofgoodvalue.setVisibility(View.VISIBLE);
            tvFreeCashFlowInputsSGA = (TextView)findViewById(R.id.WACCDetailedFreeCashFlowInputsSGA);
            tvFreeCashFlowInputsSGA.setVisibility(View.VISIBLE);
            tvFreeCashFlowInputsSGAValue = (TextView)findViewById(R.id.WACCDetailedFreeCashFlowInputsSGAValue);
            tvFreeCashFlowInputsSGAValue.setVisibility(View.VISIBLE);



            WACCDetailedFreeCashFlowInputsCostGoodsSold = (TextView) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsCostGoodsSold);

            WACCDetailedFreeCashFlowInputsCostGoodsSold.setText("Cost of goods sold as % revenue");

            WACCDetailedFreeCashFlowInputsCostGoodsSold.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, PopUpWindow.class);

                    intent.putExtra("isExcelPopup", "false");
                    intent.putExtra("message", "Cost of goods sold (CGS) captures, in principle, " +
                            "the direct costs of producing and selling the company's goods and services. " +
                            "In most financial reporting, CGS-typically includes associated Depreciation " +
                            " (make in italics) charges.");

                    startActivity(intent);


                }

            });


            WACCDetailedFreeCashFlowInputsCostGoodsSold.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, pdf_viewer.class);


                    startActivity(intent);
                    return false;
                }


            });

            WACCDetailedFreeCashFlowInputsCostGoodsSoldValue = (EditText) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsCostGoodsSoldValue);


            //SG&A as % revenue

            WACCDetailedFreeCashFlowInputsSGA
                    = (TextView) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsSGA);

            WACCDetailedFreeCashFlowInputsSGA.setText("SG&A (incl. R&D) as % revenue");
            WACCDetailedFreeCashFlowInputsSGA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, PopUpWindow.class);

                    intent.putExtra("isExcelPopup", "false");
                    intent.putExtra("message", "SG&A - selling, general, and administrative " +
                            "expenditures or SGA - captures, in principle, the indirect costs of producing " +
                            "and selling the company's goods and services. (R&D expenses are assumed to " +
                            "be included, so if it is reported separately in the company's financial " +
                            "statements, R&D should be included here.) In most financial reporting, SGA " +
                            "typically includes the associated Depreciation (make in italics) charges.");

                    startActivity(intent);

                }

            });

            WACCDetailedFreeCashFlowInputsSGA.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, pdf_viewer.class);


                    startActivity(intent);
                    return false;
                }


            });

            WACCDetailedFreeCashFlowInputsSGAValue
                    = (EditText) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsSGAValue);


            //do error checking, implement Excel here

            WACCDetailedFreeCashFlowInputsSGAValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        //SAVE THE DATA


                        WACCDetailedObject.setSGAValue(Double.parseDouble(WACCDetailedFreeCashFlowInputsSGAValue.getText().toString()));
                        //Log.d("TEST", WACCDetailedObject.);
                    }

                }
            });

        }

        //Initial EBIT

        WACCDetailedFreeCashFlowInputsInitialEBIT
                = (TextView) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsInitialEBIT);

        WACCDetailedFreeCashFlowInputsInitialEBIT.setText("Initial EBIT as % revenue (Operating Income)");

        WACCDetailedFreeCashFlowInputsInitialEBIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "EBIT = Operating Income = Revenue - CGS - SGA " +
                        "(if Depreciation (italics) is not already included in CGS and SGA, it has to be " +
                        "subtracted). \n\n The input here is the percent operating margin for Year 1 " +
                        "of the valuation. (Note that initial EBIT can be a negative number; in that event, " +
                        "last-period EBIT as % revenue should be input as a positive number; see below.)");

                startActivity(intent);


            }

        });

        WACCDetailedFreeCashFlowInputsInitialEBIT.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, pdf_viewer.class);


                startActivity(intent);
                return false;
            }


        });

        WACCDetailedFreeCashFlowInputsInitialEBITValue
                = (EditText) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsInitialEBITValue);

        WACCDetailedFreeCashFlowInputsInitialEBITValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //SAVE THE DATA


                    WACCDetailedObject
                            .setInitialEBIT(Double.
                                    valueOf(WACCDetailedFreeCashFlowInputsInitialEBITValue.getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.);
                }

            }
        });

        //Last-period EBIT

        WACCDetailedFreeCashFlowInputsLastPeriodEBIT = (TextView) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsLastPeriodEBIT);

        WACCDetailedFreeCashFlowInputsLastPeriodEBIT.setText("Last-period/last year EBIT as % revenue");

        WACCDetailedFreeCashFlowInputsLastPeriodEBIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "This is the targeted operating margin for the " +
                        "last year of the forecast period.  The defualt value is set to the initial EBIT as " +
                        "% revenue, but you can change it.  \n\n The model changes the percent operating margin " +
                        "linearly between the first period and last.  It is, therefore, possible to model a " +
                        "situation where the firm has negative initial EBIT but its EBIT grows positive over time" +
                        " ; or the firm has a supra-normal initial EBIT but its EBIT declines over time.");

                startActivity(intent);

            }

        });

        WACCDetailedFreeCashFlowInputsLastPeriodEBIT.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, pdf_viewer.class);


                startActivity(intent);
                return false;
            }


        });

        WACCDetailedFreeCashFlowInputsLastPeriodEBITValue
                = (EditText) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsLastPeriodEBITValue);

        WACCDetailedFreeCashFlowInputsLastPeriodEBITValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //SAVE THE DATA


                    WACCDetailedObject
                            .setLastYearEBIT(Double.
                                    valueOf(
                                            WACCDetailedFreeCashFlowInputsLastPeriodEBITValue
                                                    .getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.);
                }

            }
        });

        //Capital expenditure as % revenue

        WACCDetailedFreeCashFlowInputsCapitalExpenditure = (TextView) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsCapitalExpenditure);

        WACCDetailedFreeCashFlowInputsCapitalExpenditure.setText("Capital expenditure as % revenue (Capex)");

        WACCDetailedFreeCashFlowInputsCapitalExpenditure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "You have three choices for this input.  You " +
                        "can divide the capital expenditure in the most recent period by revenues " +
                        "and use the value; while simple, it could be affected by unusually high or low" +
                        " numbers in the base year.  You can choose an average value over 3-5 years to smooth " +
                        "the input.  Or, you can use an industry average. (If you are using the Cash Flow " +
                        "Statement to get this number, know that is may how up with a negative sign!).");

                startActivity(intent);

            }

        });

        WACCDetailedFreeCashFlowInputsCapitalExpenditure.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, pdf_viewer.class);


                startActivity(intent);
                return false;
            }


        });

        WACCDetailedFreeCashFlowInputsCapitalExpenditureValue
                = (EditText) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsCapitalExpenditureValue);

        WACCDetailedFreeCashFlowInputsCapitalExpenditureValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //SAVE THE DATA


                    WACCDetailedObject
                            .setCapitalExpenditure(Double.
                                    valueOf(
                                            WACCDetailedFreeCashFlowInputsCapitalExpenditureValue
                                                    .getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.);
                }

            }
        });

        //Operating NWC as % revenue

        WACCDetailedFreeCashFlowInputsOperatingNWC = (TextView) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsOperatingNWC);

        WACCDetailedFreeCashFlowInputsOperatingNWC.setText("Operating NWC (Non-cash working capital)" +
                " as % revenue");

        WACCDetailedFreeCashFlowInputsOperatingNWC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");
                intent.putExtra("message", "Operating net working capital (NWC) is " +
                        "the non-cash (needs to be underlined) current assets minus non-debt (underlined) " +
                        "current liabilities.  You can use the last year's number, or a 'normalized' " +
                        "number for your company over time, or an industry average.\n\n" +
                        "In principle, NWC can be negative (i.e., a source of cash) if non-cash " +
                        "current assets are smaller than the non-debt current liabilities.  In our " +
                        "model, we do not allow negative NWC.  The reason is, allowing negative NWC " +
                        "to grow over time (as revenue grows) can not only inflate cash flows forecasts, " +
                        "but also make accounts payable unsustainable thereby impacting credit risk.  " +
                        "Hence, we put a floor of zero for this input.  \n\n" +
                        "When inputting the assumption for 'Operating NWC as % revenue', " +
                        "note that you are inputting the percentage for total (i.e., not " +
                        "incremental) revenue for the forecasted year.  In other words, the " +
                        "input you provide will calculate the total NWC for the year, based on" +
                        " which, the model will calculate the Change in NWC.");


                startActivity(intent);

            }

        });

        WACCDetailedFreeCashFlowInputsOperatingNWCValue
                = (EditText) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsOperatingNWCValue);

        WACCDetailedFreeCashFlowInputsOperatingNWCValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //SAVE THE DATA


                    WACCDetailedObject
                            .setOperatingNWC(Double.
                                    valueOf(
                                            WACCDetailedFreeCashFlowInputsOperatingNWCValue
                                                    .getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.);
                }

            }
        });

        //Straight-line depreciation rule
        //Straight-line method; Depreciation Expense = Depreciable Amount/ Useful Life

        TextView tvStraightLine = (TextView)findViewById(R.id.WACCDetailedFreeCashFlowInputsStraightLineYears);
        tvStraightLine.setVisibility(View.INVISIBLE);
        TextView tvStraightLineValue = (TextView)findViewById(R.id.WACCDetailedFreeCashFlowInputsStraightLineValue);
        tvStraightLineValue.setVisibility(View.INVISIBLE);



        if  (WACCDetailedObject.getDepreciationOption().equals("Will use straight line rule")) {


            tvStraightLine = (TextView)findViewById(R.id.WACCDetailedFreeCashFlowInputsStraightLineYears);
            tvStraightLine.setVisibility(View.VISIBLE);
            tvStraightLineValue = (TextView)findViewById(R.id.WACCDetailedFreeCashFlowInputsStraightLineValue);
            tvStraightLineValue.setVisibility(View.VISIBLE);


            WACCDetailedFreeCashFlowInputsStraightLineYears = (TextView) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsStraightLineYears);

            WACCDetailedFreeCashFlowInputsStraightLineYears.setText("Straight-line depreciation rule (#years)");

            WACCDetailedFreeCashFlowInputsStraightLineYears.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, PopUpWindow.class);

                    intent.putExtra("isExcelPopup", "false");
                    intent.putExtra("message", "If you chose the option of 'straight line" +
                            " depreciation rule' in the 'Key Questions' page, the model will calculate " +
                            "Year T Depreciation (italics) as: \n\n Dt = Dt-1 + [Capext/N]  " +
                            "\n\n where Capext is the Capital expenditure for Year T, and N is " +
                            "assumed average depreciable life of assets. (If the number of forecast " +
                            "periods exceeds N, the model fades Depreciation (italics) charges " +
                            "to account for the fact that capital expenditure incurred in the early " +
                            "periods will get fully depreciated, i.e., to account for the fact that " +
                            "its book value fades to zero.)");

                    startActivity(intent);

                }

            });

            WACCDetailedFreeCashFlowInputsStraightLineYearsValue
                    = (EditText) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsStraightLineValue);

            WACCDetailedFreeCashFlowInputsStraightLineYearsValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        //SAVE THE DATA


                        WACCDetailedObject
                                .setStraightLineDepreciationYears(Integer.
                                        valueOf(
                                                WACCDetailedFreeCashFlowInputsStraightLineYearsValue
                                                        .getText().toString()));
                        //Log.d("TEST", WACCDetailedObject.);
                    }

                }
            });
        }

        //Tax rate

        WACCDetailedFreeCashFlowInputsTaxRate = (TextView) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsTaxRate);

        WACCDetailedFreeCashFlowInputsTaxRate.setText("Tax rate (T; %)");

        WACCDetailedFreeCashFlowInputsTaxRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, PopUpWindow.class);

                intent.putExtra("isExcelPopup", "false");

                intent.putExtra("message", "Under the assumption that there are few " +
                        "long-run permanent differences, we recommend using a rate that is much " +
                        "closer to the statutory rate plus local tax rate (30% - 40% in the US) " +
                        "than to zero. \n\n In the case of firms that grant a lot of stock " +
                        "options, a somewhat lower rate (e.g., 25% - 30%) might be justified, " +
                        "assuming that the tax benefit associated with employee options  " +
                        "exercise continues into the future.");

                startActivity(intent);

            }

        });

        WACCDetailedFreeCashFlowInputsTaxRateValue
                = (EditText) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsTaxRateValue);

        WACCDetailedFreeCashFlowInputsTaxRateValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //SAVE THE DATA


                    WACCDetailedObject
                            .setTaxRate(Double.
                                    valueOf(
                                            WACCDetailedFreeCashFlowInputsTaxRateValue
                                                    .getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.);
                }

            }
        });







            WACCDetailedFreeCashFlowInputsBaseYearDepreciation = (TextView) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsBaseYearDepreciation);

            WACCDetailedFreeCashFlowInputsBaseYearDepreciation.setText("Base year depreciation ($ millions)");

            WACCDetailedFreeCashFlowInputsBaseYearDepreciation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, PopUpWindow.class);

                    intent.putExtra("isExcelPopup", "false");

                    intent.putExtra("message", "The base year value for this can " +
                            "be found in the Cash Flow Statement.");

                    startActivity(intent);
                }

            });

            WACCDetailedFreeCashFlowInputsBaseYearDepreciation.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    Intent intent = new Intent(WACCDetailedFreeCashFlowInputs.this, pdf_viewer.class);


                    startActivity(intent);
                    return false;
                }


            });

            WACCDetailedFreeCashFlowInputsBaseYearDepreciationValue
                    = (EditText) this.findViewById(R.id.WACCDetailedFreeCashFlowInputsBaseYearDepreciationValue);

            WACCDetailedFreeCashFlowInputsBaseYearDepreciationValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        //SAVE THE DATA


                        WACCDetailedObject
                                .setBaseYearDepreciation(Double.
                                        valueOf(
                                                WACCDetailedFreeCashFlowInputsBaseYearDepreciationValue
                                                        .getText().toString()));
                        //Log.d("TEST", WACCDetailedObject.);
                    }

                }
            });




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //leverage the Snackbar to make user aware of any errors in their data
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Data Submitted", null).show();


                //Add all the model data here
                WACCDetailedObject.
                        setCompanyName(WACCDetailedFreeCashFlowInputsCompanyNameValue.getText().toString());


                WACCDetailedObject.setBaseYear(Integer.parseInt(
                        WACCDetailedFreeCashFlowInputsBaseYearValue.getText().toString()));

                WACCDetailedObject.setNumberOfForecastPeriods(Integer.parseInt(
                        WACCDetailedFreeCashFlowInputsNumberForecastPeriodsValue.getText().toString()));

                Double num = Double.parseDouble(
                        WACCDetailedFreeCashFlowInputsCurrentYearRevenueValue.getText().toString());
                WACCDetailedObject.setCurrentYearRevenue(Double.parseDouble(
                        WACCDetailedFreeCashFlowInputsCurrentYearRevenueValue.getText().toString()));

                String string = Double.toString(WACCDetailedObject.getCurrentYearRevenue());

                Log.v("CurrentYearRevenue", String.valueOf(WACCDetailedObject.getCurrentYearRevenue()));

                WACCDetailedObject.setAnnualRevenueGrowthPercentage(Double.parseDouble(
                        WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateValue.getText().toString()));

                if (WACCDetailedObject.getOperatingIncomeOption() == "Will input percent CGS and percent SGA") {


                    WACCDetailedObject.setCostOfGoodsSoldAsPercentage(Double.parseDouble(
                        WACCDetailedFreeCashFlowInputsCostGoodsSoldValue.getText().toString()));

                    WACCDetailedObject.setSGAValue(Double.parseDouble(
                            WACCDetailedFreeCashFlowInputsSGAValue.getText().toString()));
                }




                WACCDetailedObject.setInitialEBIT(Double.parseDouble(
                        WACCDetailedFreeCashFlowInputsInitialEBITValue.getText().toString()));

                WACCDetailedObject.setLastYearEBIT(Double.parseDouble(
                        WACCDetailedFreeCashFlowInputsLastPeriodEBITValue.getText().toString()));

                WACCDetailedObject.setCapitalExpenditure(Double.parseDouble(
                        WACCDetailedFreeCashFlowInputsCapitalExpenditureValue.getText().toString()));

                WACCDetailedObject.setOperatingNWC(Double.parseDouble(
                        WACCDetailedFreeCashFlowInputsOperatingNWCValue.getText().toString()));



                    WACCDetailedObject.setStraightLineDepreciationYears(Integer.valueOf(
                            WACCDetailedFreeCashFlowInputsStraightLineYearsValue.getText().toString()));



                    WACCDetailedObject.setBaseYearDepreciation(Double.parseDouble(
                            WACCDetailedFreeCashFlowInputsBaseYearDepreciationValue.getText().toString()));



                WACCDetailedObject.setOperatingNWC(Double.parseDouble(
                        WACCDetailedFreeCashFlowInputsOperatingNWCValue.getText().toString()));

                WACCDetailedObject.setTaxRate(Double.parseDouble(
                        WACCDetailedFreeCashFlowInputsOperatingNWCValue.getText().toString()));



            }
        });




    }


}
