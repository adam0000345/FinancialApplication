package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
//test


public class WACCDetailedPageCostOfCapitalInputs extends FirstScreenToShowMenu {

    private TextView WACCDetailedPageCostOfCapitalTitle;

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

    private TextView WACCDetailedPageCostOfCapitalMarketRiskPremium;
    private TextView WACCDetailedPageCostOfCapitalLeveredCostOfEquity;
    private TextView WACCDetailedPageCostOfCapitalCostOfDebt;
    private TextView WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapital;
    private TextView WACCDetailedPageCostOfCapitalNumberOfShares;


    private TextView WACCDetailedPageCostOfCapitalLeveredCostOfEquityValue;
    private TextView WACCDetailedPageCostOfCapitalCostOfDebtValue;
    private TextView WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapitalValue;
    private TextView WACCDetailedPageCostOfCapitalNumberOfSharesValue;


    //TODO Figure out how to add $ and percent lines to suggestive text for input without crashing
    //TODO Figure out how to handle bad input, probably will involve a popup message
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getLayoutInflater().inflate(R.layout.waccdetailedpagecostofcapitalinputs, frameLayout);


        WACCDetailedPageCostOfCapitalTitle = (TextView) this.findViewById(R.id.
                WACCDetailedPageCostOfCapitalTitle);
        WACCDetailedPageCostOfCapitalTitle.setText("'WACC: Detailed' Model Inputs: Cost of Capital " +
                "and Terminal Value");


        //Firm Cash Value

        WACCDetailedPageCostOfCapitalCash = (TextView) this.
                findViewById(R.id.WACCDetailedPageCostOfCapitalCash);
        WACCDetailedPageCostOfCapitalCash.setText("Cash (C: $millions)");

        WACCDetailedPageCostOfCapitalCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //TODO: look into setting text like above way


                Intent intent = new Intent(WACCDetailedPageCostOfCapitalInputs.this, PopUpWindow.class);
                intent.putExtra("isExcelPopup", "false");
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
                if (!hasFocus) {
                    //SAVE THE DATA

                    WACCDetailedObject.setCash(
                            Double.parseDouble(WACCDetailedPageCostOfCapitalCashValue.getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.getCompanyName());
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
                Intent intent = new Intent(WACCDetailedPageCostOfCapitalInputs.this, PopUpWindow.class);
                intent.putExtra("isExcelPopup", "false");
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
                if (!hasFocus) {
                    //SAVE THE DATA

                    WACCDetailedObject.setDebt(
                            Double.parseDouble(WACCDetailedPageCostOfCapitalDebtValue.getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.getCompanyName());
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
                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalInputs.this, PopUpWindow.class);
                        intent.putExtra("isExcelPopup", "false");
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
                if (!hasFocus) {
                    //SAVE THE DATA

                    WACCDetailedObject.setMarketCapitalization(
                            Double.parseDouble(WACCDetailedPageCostOfCapitalMarketCapValue.getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.getCompanyName());
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
                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalInputs.this, PopUpWindow.class);
                        intent.putExtra("isExcelPopup", "false");
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
                if (!hasFocus) {
                    //SAVE THE DATA

                    WACCDetailedObject.setEquityBeta(
                            Double.parseDouble(WACCDetailedPageCostOfCapitalEquityBetaValue
                                    .getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.getCompanyName());
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

                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalInputs.this, PopUpWindow.class);
                        intent.putExtra("isExcelPopup", "false");
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
                if (!hasFocus) {
                    //SAVE THE DATA

                    WACCDetailedObject.setRiskFreeRate(
                            Double.parseDouble(WACCDetailedPageCostOfCapitalRiskFreeRateValue
                                    .getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.getCompanyName());
                }
            }
        });

        //Market risk premium (MRP: %)

        WACCDetailedPageCostOfCapitalMarketRiskPremium = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalMarketRiskPremium);
        WACCDetailedPageCostOfCapitalMarketRiskPremium.setText("Market risk premium \n(MRP: %)");

        WACCDetailedPageCostOfCapitalMarketRiskPremium
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalInputs.this, PopUpWindow.class);
                        intent.putExtra("isExcelPopup", "false");
                        intent.putExtra("message", "Market risk premium (MRP) " +
                                "is the excess return that investors demand to put their money" +
                                "into a diversified portfolio of risky assets - the 'market' - relative to the " +
                                "return that they can get on a relatively safe asset such as Treasury" +
                                "bonds.\n\n It is a matter of considerable debate in academia, but there " +
                                "is agreement on the fact that: (i) MRP is time-varying; (ii) MRP is, " +
                                "on average, lower today than the estimates we have been using in the past." +
                                "\n\n If your company is an emerging market company (or has significant" +
                                "exposure to emerging markets)m you may want to augment this number." +
                                "\n\nIt can be argued that it's fine to use the current estimate, implied " +
                                "by where the market is.\n\nIt can also be argued that it makes sense to use " +
                                "a long-run estimate - around 5% to 6% - since MRP is mean-reverting.");
                        startActivity(intent);
                    }

                });

        WACCDetailedPageCostOfCapitalMarketRiskPremiumValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalMarketRiskPremiumValue);

        WACCDetailedPageCostOfCapitalMarketRiskPremiumValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //SAVE THE DATA

                    WACCDetailedObject.setMarketRiskPremium(
                            Double.parseDouble(WACCDetailedPageCostOfCapitalMarketRiskPremiumValue
                                    .getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.getCompanyName());
                }
            }
        });

        //Levered cost of equity

        WACCDetailedPageCostOfCapitalLeveredCostOfEquity = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalLeveredCostOfEquity);
        //WACCDetailedPageCostOfCapitalLeveredCostOfEquity.setText("Levered cost of equity \n(rE: %)");

        WACCDetailedPageCostOfCapitalLeveredCostOfEquity
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalInputs.this, PopUpWindow.class);
                        intent.putExtra("isExcelPopup", "false");
                        intent.putExtra("message", "The levered cost of equity, rE, is " +
                                "calculated using CAPM with the equity beta, ßE:\n\n " +
                                "rE = rF + ßE x MRP \n\n (See 'Equity beta' above for the" +
                                " definition of variables in CAPM). It includes the effects of " +
                                "debt in the business.\n\n The rE is different from the 'unlevered' " +
                                "cost of equity, which is calculated using CAPM with the " +
                                "'unlevered' (or 'asset') beta, ßA.  This cost of equity is used in APV " +
                                "valuations (see our APV model.)\n\n" + "You may choose to use industry " +
                                "averages as a starting point.  If your firm is much smaller or riskier than the " +
                                "rest of the sector, you may want to add to this number.");

                        startActivity(intent);

                    }

                });

        WACCDetailedPageCostOfCapitalLeveredCostOfEquityValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalLeveredCostOfEquityValue);

        WACCDetailedPageCostOfCapitalLeveredCostOfEquityValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //SAVE THE DATA

                    WACCDetailedObject.setLeveredCostOfEquity(
                            Double.parseDouble(WACCDetailedPageCostOfCapitalLeveredCostOfEquityValue
                                    .getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.getCompanyName());
                }
            }
        });


        //Cost of debt

        WACCDetailedPageCostOfCapitalCostOfDebt = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalCostOfDebt);
        WACCDetailedPageCostOfCapitalCostOfDebt.setText("Cost of debt (rD: %)");

        WACCDetailedPageCostOfCapitalCostOfDebt
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalInputs.this, PopUpWindow.class);
                        intent.putExtra("isExcelPopup", "false");
                        intent.putExtra("message", "Cost of debt, rD, is the answer to the " +
                                " question: If the company were to go out and issue longer-term bonds today, " +
                                "what would the bond markets demand as a required yield?" + "\n\n" +
                                "This can be inferred from what the bond market is demanding as the default " +
                                "spread over the risk-free rate for bonds with comparable credit rating.  It should " +
                                "never be lower than the risk-free rate.  You can also use an industry average.  " +
                                "Avoid using 'book' costs of debt.");

                        startActivity(intent);

                    }

                });

        WACCDetailedPageCostOfCapitalCostOfDebtValue =
                (EditText) this.findViewById(R.id.WACCDetailedPageCostOfCapitalCostOfDebtValue);


        WACCDetailedPageCostOfCapitalCostOfDebtValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //SAVE THE DATA

                    WACCDetailedObject.setCostOfDebt(
                            Double.parseDouble(WACCDetailedPageCostOfCapitalCostOfDebtValue
                                    .getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.getCompanyName());
                }
            }
        });

        //Weighted average cost of capital
        WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapital = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapital);
        WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapital.setText("Weighted average cost of" +
                " capital \n(WACC: %)");

        WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapital
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalInputs.this, PopUpWindow.class);
                        intent.putExtra("isExcelPopup", "false");
                        intent.putExtra("message", "WACC is 'weighted average cost of capital.' " +
                                "It captures the idea that we must provide a 'fair' rate of return to each type of " +
                                "investor in our business, weighted by the proportion in which they are supplying " +
                                "its capital.  this rate is determined by the return on risk-equivalent assets " +
                                "- the notion is that, when investors give us their money, they are foregoing the " +
                                "opportunity to earn a risk-equivalent rate of return elsewhere; i.e., they are " +
                                "incurring an opportunity cost to the use of their capital.  \n\n Capital" +
                                " is of two types: owners' money (Equity, E) or borrowed money (Debt, D). " +
                                "If E expects a return rE, and D expects rD, and 'f is the tax rate, then WACC " +
                                "is defined as: \n\n WACC = rE (E/(D+E)) + rD(1-t)(D/(D+E))\n\n" +
                                "We multiply rD by (1-t) to reflect the fact that tax laws allow for interest payments " +
                                "to debtholders to be deducted as a cost of doing business (while dividend payments " +
                                "to equityholders, with occasional exceptions, are not).  As a result, the true cost " +
                                "of borrowing is not all of rD, but the after-tax rD. This provision in the tax laws is" +
                                " said to provide a 'tax shield benefit' to the company.\n\nWhat is the correct WACC " +
                                "to use? Always that of the asset under consideration and not that of the person " +
                                "considering the asset (e.g., in acquisition situations, the WACC of the target, not " +
                                "the acquirer).");

                        startActivity(intent);

                    }

                });

        WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapitalValue =
                (EditText) this.findViewById(R.id
                        .WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapitalValue);

        WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapitalValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //SAVE THE DATA

                    WACCDetailedObject.setWACC(
                            Double.parseDouble(WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapitalValue
                                    .getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.getCompanyName());
                }
            }
        });

        //Number of shares (millions)
        WACCDetailedPageCostOfCapitalNumberOfShares = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalNumberOfShares);
        WACCDetailedPageCostOfCapitalNumberOfShares.setText("Number of shares \n(millions)");

        WACCDetailedPageCostOfCapitalNumberOfShares
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalInputs.this, PopUpWindow.class);
                        intent.putExtra("isExcelPopup", "false");
                        intent.putExtra("message", "'This is the total number of common" +
                                " shares outstanding.");

                        startActivity(intent);

                    }

                });

        WACCDetailedPageCostOfCapitalNumberOfSharesValue =
                (EditText) this.findViewById(R.id
                        .WACCDetailedPageCostOfCapitalNumberOfSharesValue);


        WACCDetailedPageCostOfCapitalNumberOfSharesValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //SAVE THE DATA

                    WACCDetailedObject.setNumberOfShares(
                            Double.parseDouble(WACCDetailedPageCostOfCapitalNumberOfSharesValue
                                    .getText().toString()));
                    //Log.d("TEST", WACCDetailedObject.getCompanyName());
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
                WACCDetailedObject.setCash(Double.parseDouble(
                        WACCDetailedPageCostOfCapitalCashValue.getText().toString()));


                WACCDetailedObject.setDebt(Double.parseDouble(
                        WACCDetailedPageCostOfCapitalDebtValue.getText().toString()));

                WACCDetailedObject.setMarketCapitalization(Double.parseDouble(
                        WACCDetailedPageCostOfCapitalMarketCapValue.getText().toString()));


                WACCDetailedObject.setEquityBeta(Double.parseDouble(
                        WACCDetailedPageCostOfCapitalEquityBetaValue.getText().toString()));


                WACCDetailedObject.setRiskFreeRate(Double.parseDouble(
                        WACCDetailedPageCostOfCapitalRiskFreeRateValue.getText().toString()));

                WACCDetailedObject.setMarketRiskPremium(Double.parseDouble(
                        WACCDetailedPageCostOfCapitalMarketRiskPremiumValue.getText().toString()));

                WACCDetailedObject.setLeveredCostOfEquity(Double.parseDouble(
                        WACCDetailedPageCostOfCapitalLeveredCostOfEquityValue.getText().toString()));

                WACCDetailedObject.setCostOfDebt(Double.parseDouble(
                        WACCDetailedPageCostOfCapitalCostOfDebtValue.getText().toString()));

                WACCDetailedObject.setWACC(Double.parseDouble(
                        WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapitalValue
                                .getText().toString()));

                WACCDetailedObject.setNumberOfShares(Integer.valueOf(
                        WACCDetailedPageCostOfCapitalNumberOfSharesValue
                                .getText().toString()));


            }
        });


    }
}

