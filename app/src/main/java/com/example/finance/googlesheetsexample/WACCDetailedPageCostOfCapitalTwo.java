package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
//test


public class WACCDetailedPageCostOfCapitalTwo extends NavBarAndTitle {


    private TextView WACCDetailedPageCostOfCapitalMarketRiskPremium;
    private TextView WACCDetailedPageCostOfCapitalLeveredCostOfEquity;
    private TextView WACCDetailedPageCostOfCapitalCostOfDebt;
    private TextView WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapital;
    private TextView WACCDetailedPageCostOfCapitalNumberOfShares;


    private TextView WACCDetailedPageCostOfCapitalMarketRiskPremiumValue;
    private TextView WACCDetailedPageCostOfCapitalLeveredCostOfEquityValue;
    private TextView WACCDetailedPageCostOfCapitalCostOfDebtValue;
    private TextView WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapitalValue;
    private TextView WACCDetailedPageCostOfCapitalNumberOfSharesValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getLayoutInflater().inflate(R.layout.waccdetailedpagecostofcapitaltwo, frameLayout);



        //Market risk premium (MRP: %)

        WACCDetailedPageCostOfCapitalMarketRiskPremium = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalMarketRiskPremium);
        WACCDetailedPageCostOfCapitalMarketRiskPremium.setText("Market risk premium \n(MRP: %)");

        WACCDetailedPageCostOfCapitalMarketRiskPremium
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalTwo.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
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
                if(!hasFocus) {
                    //SAVE THE DATA

                    getWaccDetailedObject().setRiskFreeRate(
                            Double.valueOf(WACCDetailedPageCostOfCapitalMarketRiskPremiumValue
                                    .getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().getCompanyName());
                }
            }
        });

        //Levered cost of equity

        WACCDetailedPageCostOfCapitalLeveredCostOfEquity = (TextView)
                this.findViewById(R.id.WACCDetailedPageCostOfCapitalLeveredCostOfEquity);
        WACCDetailedPageCostOfCapitalLeveredCostOfEquity.setText("Levered cost of equity \n(rE: %)");

        WACCDetailedPageCostOfCapitalLeveredCostOfEquity
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalTwo.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
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
                if(!hasFocus) {
                    //SAVE THE DATA

                    getWaccDetailedObject().setRiskFreeRate(
                            Double.valueOf(WACCDetailedPageCostOfCapitalLeveredCostOfEquityValue
                                    .getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().getCompanyName());
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
                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalTwo.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
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
                if(!hasFocus) {
                    //SAVE THE DATA

                    getWaccDetailedObject().setRiskFreeRate(
                            Double.valueOf(WACCDetailedPageCostOfCapitalCostOfDebtValue
                                    .getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().getCompanyName());
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
                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalTwo.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
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
                if(!hasFocus) {
                    //SAVE THE DATA

                    getWaccDetailedObject().setRiskFreeRate(
                            Double.valueOf(WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapitalValue
                                    .getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().getCompanyName());
                }
            }
        });

        //Number of shares (millions)
        WACCDetailedPageCostOfCapitalNumberOfShares = (TextView)
                this.findViewById(R.id. WACCDetailedPageCostOfCapitalNumberOfShares);
        WACCDetailedPageCostOfCapitalNumberOfShares.setText("Number of shares \n(millions)");

        WACCDetailedPageCostOfCapitalNumberOfShares
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Logic
                        Intent intent = new Intent(WACCDetailedPageCostOfCapitalTwo.this, PopUpWindow.class);
                        intent.putExtra("flagExcelViewer", "false");
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
                if(!hasFocus) {
                    //SAVE THE DATA

                    getWaccDetailedObject().setRiskFreeRate(
                            Double.valueOf(WACCDetailedPageCostOfCapitalNumberOfSharesValue
                                    .getText().toString()));
                    //Log.d("TEST", getWaccDetailedObject().getCompanyName());
                }
            }
        });

    }
}

