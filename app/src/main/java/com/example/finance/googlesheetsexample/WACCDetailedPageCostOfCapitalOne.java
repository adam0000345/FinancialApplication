package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
//test


public class WACCDetailedPageCostOfCapitalOne extends NavBarAndTitle {

    private TextView WACCDetailedPageCostOfCapitalTitle;
    private TextView WACCDetailedPageCostOfCapitalSubTitle;
    private TextView WACCDetailedPageCostOfCapitalCash;
    private TextView WACCDetailedPageCostOfCapitalDebt;
    private TextView WACCDetailedPageCostOfCapitalMarketCap;
    private TextView WACCDetailedPageCostOfCapitalEquityBeta;
    private TextView WACCDetailedPageCostOfCapitalRiskFreeRate;


    private TextView WACCDetailedPageCostOfCapitalCashValue;
    private TextView WACCDetailedPageCostOfCapitalDebtValue;
    private TextView WACCDetailedPageCostOfCapitalMarketCapValue;
    private TextView WACCDetailedPageCostOfCapitalEquityBetaValue;
    private TextView WACCDetailedPageCostOfCapitalRiskFreeRateValue;
    private TextView WACCDetailedPageCostOfCapitalMarketRiskPremiumValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getLayoutInflater().inflate(R.layout.waccdetailedpagecostofcapitalone, frameLayout);




        WACCDetailedPageCostOfCapitalTitle = (TextView) this.findViewById(R.id.
                WACCDetailedPageCostOfCapitalTitle);
        WACCDetailedPageCostOfCapitalTitle.setText("'WACC: Detailed' Model Inputs: Cost of Capital " +
                "and Terminal Value");

        WACCDetailedPageCostOfCapitalSubTitle = (TextView) this.findViewById(R.id.
                WACCDetailedPageCostOfCapitalSubTitle);
        WACCDetailedPageCostOfCapitalSubTitle.setText("COST OF CAPITAL");


        //Firm Cash Value

        WACCDetailedPageCostOfCapitalCash = (TextView) this.
                findViewById(R.id.WACCDetailedPageCostOfCapitalCash);
        WACCDetailedPageCostOfCapitalCash.setText("Cash (C: $millions)");

        WACCDetailedPageCostOfCapitalCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopUpWindow popUpWindow = new PopUpWindow();
                //TODO: look into setting text like above way
                Intent intent = new Intent(WACCDetailedPageCostOfCapitalOne.this, PopUpWindow.class);
                intent.putExtra("flagExcelViewer", "false");
                intent.putExtra("message", "This is the sum of all cash and cash" +
                        "equivalents from the company's balance sheet, as of the end of the " +
                        "base year of valuation.  Input the most recent value.");

                //

                startActivity(intent);

            }

        });

        WACCDetailedPageCostOfCapitalCashValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalCashValue);

        WACCDetailedPageCostOfCapitalCashValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA

                    getWaccDetailedObject().setCash(
                            Double.valueOf(WACCDetailedPageCostOfCapitalCashValue.getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().getCompanyName());
                }

            }
        });


        //Firm Debt Value

        WACCDetailedPageCostOfCapitalDebt = (TextView) this.findViewById(R.id.WACCDetailedPageCostOfCapitalDebt);
        WACCDetailedPageCostOfCapitalDebt.setText("Debt (D: $ millions)");

        //TODO: Get subscripts to work properly
        WACCDetailedPageCostOfCapitalDebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Logic
                Intent intent = new Intent(WACCDetailedPageCostOfCapitalOne.this, PopUpWindow.class);
                intent.putExtra("flagExcelViewer", "false");
                intent.putExtra("message", "This is, at a minimum, the sum of all" +
                        " interest-bearing debt - i.e., short-term debt, plus current portion of" +
                        " long-term debt, plus long-term debt.  In addition, it may include " +
                        "the capitalized value of long-term leases.");

                //



                startActivity(intent);


            }

        });

        WACCDetailedPageCostOfCapitalDebtValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalDebtValue);

        WACCDetailedPageCostOfCapitalDebtValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA

                    getWaccDetailedObject().setDebt(
                            Double.valueOf(WACCDetailedPageCostOfCapitalDebtValue.getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().getCompanyName());
                }

            }
        });

        //Market Capitalization

        WACCDetailedPageCostOfCapitalMarketCap = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalMarketCap);
        WACCDetailedPageCostOfCapitalMarketCap.setText("Market capitalization \n(E: $millions)");

        WACCDetailedPageCostOfCapitalMarketCap
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalOne.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
                        intent.putExtra("message", "Market capitalization is" +
                                " the total market value of all common equity in your firm. " +
                                "While multiplying the current share price by the number of shares " +
                                "will usually give you this number, you should add the value of all" +
                                "classes of common stock (even non-traded common stock, with an estimated" +
                                "value per share).");

                        startActivity(intent);

                    }

                });

        WACCDetailedPageCostOfCapitalMarketCapValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalMarketCapValue);

        WACCDetailedPageCostOfCapitalMarketCapValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA

                    getWaccDetailedObject().setDebt(
                            Double.valueOf(WACCDetailedPageCostOfCapitalMarketCapValue.getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().getCompanyName());
                }

            }
        });



        //Equity Beta

        WACCDetailedPageCostOfCapitalEquityBeta = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalEquityBeta);
        WACCDetailedPageCostOfCapitalEquityBeta.setText("Equity beta ß)");

        WACCDetailedPageCostOfCapitalEquityBeta
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalOne.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
                        intent.putExtra("message", "Equity beta (ßE) measures " +
                                "the sensitivity of a stock's expected returns to that of the " +
                                "market as a whole.  It measures the expected percent change in " +
                                "the value of an asset or every 1% change in the market index.  " +
                                "For instance, a stock with a ßE = 1.5 would be expected to go up, " +
                                "on average, by 1.5% for every 1% increase in the value of the market.  " +
                                "It is derived from the Capital Asset Pricing Model (CAPM), which " +
                                "says that the expected return on equity, rE, is: \n\n" +
                                "rE = rF + ßE x MRP \n\n where rF is the risk-free rate or return " +
                                "(proxied by yield on long-run US goverment Treasury bonds), " +
                                "ßE is as as above, and MRP the 'market risk premium' or " +
                                "'equity risk premium' is the excess return that investors demand to " +
                                " put their money into a diversified portfolio of stocks relative to a " +
                                "safe asset such as US government Treasury bonds (rF).  \n\n" +
                                "You can use the beta that you find for your company on a service (YahooFinance," +
                                " Value Line, etc.). In many instances, a better choice may be an " +
                                "industry average.");

                        startActivity(intent);

                    }

                });

        WACCDetailedPageCostOfCapitalEquityBetaValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalEquityBetaValue);

        WACCDetailedPageCostOfCapitalEquityBetaValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA

                    getWaccDetailedObject().setEquityBeta(
                            Double.valueOf(WACCDetailedPageCostOfCapitalEquityBetaValue
                                    .getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().getCompanyName());
                }
            }
        });

        //Risk-free rate (rF: %)

        WACCDetailedPageCostOfCapitalRiskFreeRate = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalRiskFreeRate);
        WACCDetailedPageCostOfCapitalRiskFreeRate.setText("Risk-free rate (rF: %)");

        WACCDetailedPageCostOfCapitalRiskFreeRate
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic

                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalOne.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
                        intent.putExtra("message", "This is proxied by the yield" +
                        "on long-term US government Treasury bonds. It is recommended using at least a " +
                                "10-year bond, perhaps even a 30-year bond if you're " +
                                "assuming a constant long-run MRP.  In Euros, use German " +
                                "government bonds.  In other currencies, proceed with caution.");
                        startActivity(intent);



                    }

                });

        WACCDetailedPageCostOfCapitalRiskFreeRateValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalRiskFreeRateValue);

        WACCDetailedPageCostOfCapitalRiskFreeRateValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //SAVE THE DATA

                    getWaccDetailedObject().setRiskFreeRate(
                            Double.valueOf(WACCDetailedPageCostOfCapitalRiskFreeRateValue
                                    .getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().getCompanyName());
                }
            }
        });



    }
}

