package com.example.finance.googlesheetsexample;

import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class WACCDetailedPageResults extends FirstScreenToShowMenu {

    private double CurrentYearRevenue;
    private double TaxRate;
    private double CostOfGoodsSold;
    private double CostOfGoodsSoldPercentage;
    private double GrossProfit;
    private double SellingGeneralAdministrativeExpensesAsPercentageOfRevenue;
    private double InitialEBITPercentageOfRevenue;
    private double LastPeriodEBITPercentageOfRevenue;
    private double CapitalExpenditurePercentageOfRevenue;
    private double CustomEBIT;
    private double SGACostPercentage;
    private double SGACost;
    private double StraightLineDepreciationNumberOfYears;
    private double BaseYearDepreciation;
    private double ChangeInNonCashWorkingCapital;
    private double YearEarlierWorkingCapital;
    private double CurrentYearWorkingCapital;
    private double FreeCashFlow;
    private double WACC;
    private double DiscountFactor;
    private double Presentvalue;


    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MainAdapter mAdapter;
    private Map<Integer, HashMap<String, String>> data;


    private TextView WACCDetailedResultsYearNumber;
    private TextView WACCDetailedResultsRevenueNumber;
    private TextView WACCDetailedResultsCostOfGoodsNumber;
    private TextView WACCDetailedResultsSGANumber;
    private TextView WACCDetailedResultsEBITNumber;
    private TextView WACCDetailedResultsDepreciationNumber;
    private TextView WACCDetailedResultsOperatingCashFlowNumber;
    private TextView WACCDetailedResultsCashExpenditureNumber;
    private TextView WACCDetailedResultsChangeInNetWorkingCapitalNumber;
    private TextView WACCDetailedResultsFreeCashFlowNumber;
    private TextView WACCDetailedResultsWACCNumber;
    private TextView WACCDetailedResultsDiscountFactorNumber;
    private TextView WACCDetailedResultsPVNumber;


    //decided to use card views instead of layout views
    //because on every year, I wanted to leave the option
    //to post comments or remarks to justify possible growth
    //projections on any given year


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String text = WACCDetailedObject.getOperatingIncomeOption();
        String text1 = WACCDetailedObject.getDepreciationOption();
        String text2 = WACCDetailedObject.getWACCOption();
        String text3 = WACCDetailedObject.getTerminalGrowthRateOption();

        getLayoutInflater().inflate(R.layout.waccdetailedpageresults, frameLayout);

        data = new HashMap<Integer, HashMap<String,String>>();

        //USED FOR TESTING PURPOSES ONLY!!
        WACCDetailedObject.setNumberOfForecastPeriods(4);

        for (int i = 0; i < WACCDetailedObject.getNumberOfForecastPeriods(); i++) {

            data.put(i, innerDataGenerator("WACCDetailedResultsYearNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsRevenueNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsCostOfGoodsNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedPageResultsSGACostNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsEBITNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsDepreciationNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsOperatingCashFlowNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsCashExpenditureNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsChangeInNetWorkingCapitalNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsFreeCashFlowNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsWACCNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsDiscountFactorNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsWACCNumber", ""));
            data.put(i, innerDataGenerator("WACCDetailedResultsPVVNumber", ""));

            Log.d("TESTER", data.get(0).toString());

        }


        //http://pages.stern.nyu.edu/~adamodar/New_Home_Page/AccPrimer/accstate.htm

        //http://people.stern.nyu.edu/adamodar/pdfiles/eqnotes/valenhdcf.pdf8









        for (int currentyear = 0; currentyear < WACCDetailedObject.getNumberOfForecastPeriods();
             currentyear++) {


            //set current year
            //TextView WACCDetailedResultsYearNumber =
            //        this.findViewById(R.id.WACCDetailedResultsYearNumber);
            //WACCDetailedResultsYearNumber.setText(String.valueOf(currentyear));

            data.get(currentyear).put("WACCDetailedResultsYearNumber",
                    "Year " + String.valueOf(currentyear));

            TaxRate = WACCDetailedObject.getTaxRate();



            //Free Cash Flows To Firm Calculation
            //EBIT(1-t) - (Capital Expenditures- Depreciation) - Change in non-cash working capital=

            //Free Cash Flow to Firm (FCFF)

            //Cash Flows To Equity Investors
            //Net income - (Capital Expenditures - Depreciation) - Change in non-cash
            //Working Capital - (Principal Repaid - New Debt Issues) - Preferred Dividend
            //-new Debt Issues = Free Cash Flow to Equity

            if (currentyear == 0) {

                CurrentYearRevenue = WACCDetailedObject.getCurrentYearRevenue();
                //if we are just starting forecast, just use CurrentYearRevenue value
                //Revenue

                data.get(currentyear).
                        put("WACCDetailedResultsRevenueNumber", String.valueOf(CurrentYearRevenue));
            } else {
                CurrentYearRevenue = ((Double.parseDouble(data.get(currentyear-1)
                        .get("WACCDetailedResultsRevenueNumber")))
                        * (WACCDetailedObject.getAnnualRevenueGrowthPercentage() * .01) +
                        (Double.parseDouble(data.get(currentyear-1)
                                .get("WACCDetailedResultsRevenueNumber"))));

                WACCDetailedObject.setCurrentYearRevenue(CurrentYearRevenue);



                data.get(currentyear).
                        put("WACCDetailedResultsRevenueNumber",
                                String.valueOf(CurrentYearRevenue));
            }

            CapitalExpenditurePercentageOfRevenue =
                    WACCDetailedObject.getCapitalExpenditure();

            //Calculate Cash Expenditure
            data.get(currentyear).put("WACCDetailedResultsCashExpenditureNumber",
                    String.format("%.2f", CurrentYearRevenue * CapitalExpenditurePercentageOfRevenue * .01));

            //Working capital, also known as net working capital, is the difference between a company’s current assets,
            // like cash, accounts receivable (customers’ unpaid bills) and inventories of raw materials and finished
            // goods, and its current liabilities, like accounts payable.

            //Working Capital = Current Assets - Current Liabilities


            //If CGS and SGA are inputted use to calculate EBIT, yearly SGA (R&D), and COGS,
            // otherwise, just use
            //the Ebit provided
            if (WACCDetailedObject.getOperatingIncomeOption().
                    equals("Will input percent CGS and percent SGA"))
            {
                Log.i("Operating Income Option", WACCDetailedObject.getOperatingIncomeOption());


                //Operating Profit Margin = Operating Income / Sales Revenue
                //EBIT in period t = Revenues in period t * Expected operating margin in period t
                //Thus, if you expect operating margins to change over time, you should not use the fundamental
                // growth equation developed in the last section as your base growth rate. Instead, you should forecast
                // revenues and margins over time, and estimate the operating income as the product of the two.
                //in case COG changes over time, this is helpful
                CostOfGoodsSoldPercentage =
                        WACCDetailedObject.getCostOfGoodsSoldAsPercentage();


                //Cost Of Goods Sold
                CostOfGoodsSold = CurrentYearRevenue * CostOfGoodsSoldPercentage;

                //Calculate Gross Profit
                //Gross Profit = Revenue - COGS
                GrossProfit = CurrentYearRevenue - CostOfGoodsSold;



                //get the current Cost of Goods percentage and times it against the current year
                //revenue, display this number

                data.get(currentyear).put("WACCDetailedResultsCostOfGoodsNumber",
                        String.valueOf(CostOfGoodsSold));


                //SG&A is an initialism used in accounting to refer to
                // Selling, General and Administrative Expenses
                //, this includes Research and Development costs

                SGACostPercentage =
                        WACCDetailedObject.getSGAValue();


                //Cost of SG&A
                SGACost = CurrentYearRevenue * SGACostPercentage;



                //get the current Cost of Goods percentage and times it against the current year
                //revenue, display this number

                data.get(currentyear).put("WACCDetailedPageResultsSGACostNumber",
                        String.valueOf(SGACost));

                //calculate initial EBIT and final EBIT here
                //EBIT = Revenue - Cost of Goods Sold - Selling, General, & Admin Expense
                //if depreciation charges are not included in CGS and SGA, then it would need to
                //be additionally subtracted
                data.get(currentyear).put("WACCDetailedResultsEBITNumber",
                        String.valueOf(CurrentYearRevenue - CostOfGoodsSold - SGACost));


            }






            //HANDLE THE TERMINAL PERIOD HERE
            if (currentyear == (WACCDetailedObject.getNumberOfForecastPeriods()-1)
                    && WACCDetailedObject.getDepreciationOption()
                    != "Will assume Depreciation = Capex") {

                //allows you to predict what the final EBIT would be in the last period, left to default at
                //InitialEBIT

                LastPeriodEBITPercentageOfRevenue =
                        WACCDetailedObject.getLastYearEBIT();

                data.get(currentyear).put("WACCDetailedResultsEBITNumber",
                        String.valueOf(CurrentYearRevenue * LastPeriodEBITPercentageOfRevenue));


            } else if (WACCDetailedObject.getDepreciationOption()
                    == "Will assume Depreciation = Capex" &&
            WACCDetailedObject.getOperatingIncomeOption() ==
                    "Will input percent CGS and percent SGA") {



                CustomEBIT = GrossProfit
                        - (SGACost + (CurrentYearRevenue * CapitalExpenditurePercentageOfRevenue));

                //EBIT (Operating Income)

                data.get(currentyear).put("WACCDetailedResultsEBITNumber",
                        String.valueOf(CustomEBIT));

            }  else if (WACCDetailedObject.getDepreciationOption()
                    == "Will use straight line rule" &&
                    WACCDetailedObject.getOperatingIncomeOption() ==
                            "Will input percent CGS and percent SGA"
                    ) {



                StraightLineDepreciationNumberOfYears
                        = WACCDetailedObject
                        .getStraightLineDepreciationYears();

                BaseYearDepreciation
                        = WACCDetailedObject
                        .getBaseYearDepreciation();

                //Depreciation

                data.get(currentyear).put("WACCDetailedResultsDepreciationNumber",
                        String.valueOf(BaseYearDepreciation));

                //OperatingIncome (EBIT) = Gross Income -
                //(Operating Expenses + Depreciation & Amortization); if Straight-line approach is used
                CustomEBIT = GrossProfit - (SGACost
                        + (BaseYearDepreciation / StraightLineDepreciationNumberOfYears));

                //EBIT (Operating Income)

                data.get(currentyear).put("WACCDetailedResultsEBITNumber",
                        String.valueOf(CustomEBIT));

            }


            //FOCUS HERE FOR NOW
            else if (WACCDetailedObject.getOperatingIncomeOption()
                    == "Will input percent EBIT (Operating Margin)"
                    && WACCDetailedObject.getDepreciationOption()
                    == "Will use straight line rule") {

                //use above

                //given multiple year input, different forecasted revenue numbers, different operating NWC calculated
                //as a result, different changes in non-cash working capital is calculated
                ChangeInNonCashWorkingCapital =
                        CurrentYearWorkingCapital - YearEarlierWorkingCapital;




                StraightLineDepreciationNumberOfYears
                        = WACCDetailedObject
                        .getStraightLineDepreciationYears();

                BaseYearDepreciation
                        = WACCDetailedObject
                        .getBaseYearDepreciation();

                //Depreciation

                //Year T Depreciation as:
                //DT = DT-1(last year Depreciation) + [CapexT/N] where CapexT is the
                //Capital expenditure for Year T, and N is the assume average depreciable
                //life of assets (e.g. 3), if the number of forecast periods exceeds N, the model
                //fades Depreciation charges to account for the fact that capital
                //expenditure incurred in early periods and will get fully depreciated,
                //account for the fact that its book value fades to zero



                if (currentyear == 0) {
                    double CurrentYearDepreciation = BaseYearDepreciation;
                    data.get(currentyear).put("WACCDetailedResultsDepreciationNumber",
                            String.valueOf(BaseYearDepreciation));
                } else{

                    //Operating Income Calculation
                    InitialEBITPercentageOfRevenue =
                            WACCDetailedObject.getInitialEBIT();

                    //EBIT (Operating Income),
                    // Expected growth rate = Reinvestment Rate * ROIC

                    // pre-tax measure of operating profitability:
                    // Pre-tax Operating Margin = EBIT / Sales (Revenue)

                    //EBIT in period t = Revenues in period t * Expected operating margin in period t

                    //EBIT in period0 = 100mill * 5%, = 5 million

                    //Expected growth rate in operating income = Return on Capital * Reinvestment Rate + Efficiency growth
                    // (as a result of changing return on capital)

                    //INITIAL EBIT PERCENTAGE OF REVENUE IS OPERATING MARGIN FOR YEAR 1 of the valuation

                    //take the initial ebit and subtract it by the last period ebit, e.g. 25 percent - 20 percent
                    //it will get you 5 percent, take that amount and divide it by the amount of forecasted years
                    //subtract every year's ebit by .005 (.05/10 years) and every year multiply that ebit by that
                    //year's revenue, so year 0 will be nothing, year 1 will be 24.5%, year 2 will be 24% and so on

                    //calculate the ebit difference here
                    double EBITDifference = .01 * (WACCDetailedObject.getInitialEBIT() - WACCDetailedObject.getLastYearEBIT());

                    //numbers from .20 to .25, will be -.05

                    //calculate the ebit multiple here
                    double EBITAmount = (EBITDifference/WACCDetailedObject.getNumberOfForecastPeriods()) * currentyear;

                    //if initial ebit is greater than last year ebit, subtract
                    if (WACCDetailedObject.getInitialEBIT() > WACCDetailedObject.getLastYearEBIT()) {

                        double EBITMultiple = (.01 * WACCDetailedObject.getInitialEBIT()) - EBITAmount;

                        double EBITForTheYear = WACCDetailedObject.getCurrentYearRevenue() *
                                EBITMultiple;

                        data.get(currentyear).put("WACCDetailedResultsEBITNumber",
                                String.format("%.2f", EBITForTheYear));




                        //if initial ebit is less than last year ebit, add
                    }else{

                        double EBITMultiple = (.01 * WACCDetailedObject.getInitialEBIT()) + EBITAmount;

                        double EBITForTheYear = WACCDetailedObject.getCurrentYearRevenue() *
                                EBITMultiple;

                        data.get(currentyear).put("WACCDetailedResultsEBITNumber",
                                String.format("%.2f", EBITForTheYear));

                        FreeCashFlow = EBITForTheYear * (1 - TaxRate)
                                - ((CurrentYearRevenue * CapitalExpenditurePercentageOfRevenue) -
                                BaseYearDepreciation / StraightLineDepreciationNumberOfYears
                        ) - ChangeInNonCashWorkingCapital;

                    }


                    //if the current year is less than or equal the avg number of depreciation years
                    //DepT = [DepT–1] + [(1/N)CapexT]

                    //otherwise, [DepT–1] + [(1/N)CapexT] – [DepT–N] for the years T > N
                    //where T is the number of proforma periods, and N is the average depreciable life

                    if (currentyear <= StraightLineDepreciationNumberOfYears) {
                        double CurrentYearDepreciation = Double.valueOf(data.get(currentyear - 1)
                                .get("WACCDetailedResultsDepreciationNumber")) +
                                (
                                        ((double) ((CurrentYearRevenue * CapitalExpenditurePercentageOfRevenue) /
                                                StraightLineDepreciationNumberOfYears))
                                );
                        data.get(currentyear).put("WACCDetailedResultsDepreciationNumber",
                                String.format("%.2f", CurrentYearDepreciation));
                    } else {
                        double CurrentYearDepreciation = Double.valueOf(data.get(currentyear - 1)
                                .get("WACCDetailedResultsDepreciationNumber")) +
                                (
                                        ((double) ((CurrentYearRevenue * CapitalExpenditurePercentageOfRevenue) /
                                                StraightLineDepreciationNumberOfYears))
                                ) - (Double.valueOf(data.get(currentyear - StraightLineDepreciationNumberOfYears)
                                .get("WACCDetailedResultsDepreciationNumber")));


                        data.get(currentyear).put("WACCDetailedResultsDepreciationNumber",
                                String.format("%.2f", CurrentYearDepreciation));


                    }
                }

                ////assumption EBIT is provided, depreciation = straightline
                if ((WACCDetailedObject.getOperatingIncomeOption()
                        == "Will input percent EBIT (Operating Margin)"
                        && WACCDetailedObject.getDepreciationOption()
                        == "Will use straight line rule") && (currentyear > 0)){

                    FreeCashFlow = (InitialEBITPercentageOfRevenue * CurrentYearRevenue)
                            * (1 - TaxRate)
                            - ((CurrentYearRevenue * CapitalExpenditurePercentageOfRevenue) -
                            BaseYearDepreciation / StraightLineDepreciationNumberOfYears
                    ) - ChangeInNonCashWorkingCapital;

                    //Free Cash Flow (FCFF)

                    data.get(currentyear).put("WACCDetailedResultsFreeCashFlowNumber",
                            String.format("%.2f", FreeCashFlow));


                }






            }





            //Set Change in Net Working Capital Here
            data.get(currentyear).put("WACCDetailedResultsChangeInNetWorkingCapitalNumber",
                    String.valueOf(ChangeInNonCashWorkingCapital));



            //Free Cash Flows To Firm Calculation
            //Free Cash Flow to Firm (FCFF)
            //EBIT(1-t) - (Capital Expenditures- Depreciation)
            // //- Change in non-cash working capital
            //assumption EBIT is provided, depreciation = capex
            if (WACCDetailedObject
                    .getDepreciationOption() == "Will assume Depreciation = Capex"
                    &&
                    WACCDetailedObject.getOperatingIncomeOption()
                            == "Will input percent EBIT (Operating Margin)") {
                FreeCashFlow = InitialEBITPercentageOfRevenue * (1 - TaxRate)
                        - (CapitalExpenditurePercentageOfRevenue - BaseYearDepreciation
                ) - ChangeInNonCashWorkingCapital;

                //Free Cash Flow (FCFF)

                data.get(currentyear).put("WACCDetailedResultsFreeCashFlowNumber",
                        String.valueOf(FreeCashFlow));
            }








            ////assumption EBIT is not provided, CustomEBIT, depreciation = capex
            if (WACCDetailedObject.getOperatingIncomeOption()
                    == "Will input percent EBIT (Operating Margin)"
                    && WACCDetailedObject
                    .getDepreciationOption()
                    == "Will input percent CGS and percent SGA") {

                //calculate EBIT here
                FreeCashFlow = CustomEBIT * (1 - TaxRate)
                        - ((CurrentYearRevenue * CapitalExpenditurePercentageOfRevenue) -
                        BaseYearDepreciation
                ) - ChangeInNonCashWorkingCapital;

                //Free Cash Flow (FCFF)

                data.get(currentyear).put("WACCDetailedResultsFreeCashFlowNumber",
                        String.valueOf(FreeCashFlow));
            }






            //Operating Cash Flow, this is Free Cash Flow (FCFF) + cash or capital expenditure
            //Free Cash Flows To Firm Calculation
            //Free Cash Flow to Firm (FCFF)
            //EBIT(1-t) - (Capital Expenditures- Depreciation)
            // //- Change in non-cash working capital

            data.get(currentyear).put("WACCDetailedResultsOperatingCashFlowNumber",
                    String.valueOf(FreeCashFlow +
                            (CurrentYearRevenue * CapitalExpenditurePercentageOfRevenue)));

            //WACC Calculation
            //https://www.investopedia.com/terms/w/wacc.asp
            data.get(currentyear).put("WACCDetailedResultsWACCNumber",
                    String.valueOf(WACCDetailedObject.getWACC()));

            //Discount Factor Calculation
            if (currentyear > 0) {
                //Factor = 1 / (1 x (1 + Discount Rate) ^ Period Number)
                //Write info tap
                //Calculating what discount rate to use in your discounted cash flow calculation is no easy choice.
                // It's as much art as it is science. The weighted average cost of capital is one of
                // the better concrete methods and a great place to start, but even that won't give you
                // the perfect discount rate for every situation.
                //
                //Understanding that our discount rate is an educated guess and not a scientific
                // certainty, we can still move forward with the calculation and obtain an estimate
                // of this company's value. If our analysis estimates that the company is worth
                // more than the stock currently trades, that means the stock could be undervalued
                // and worth buying. If our estimation shows the stock is worth less than its stock
                // currently trades, then it may be overvalued and a bad value investment.

                //testing


                Log.v("testerx", String.valueOf(WACCDetailedObject.getWACC()));
                DiscountFactor = (1.0 / Math.pow(1.0 + (WACCDetailedObject.getWACC() *.01), (double) currentyear));

                data.get(currentyear).put("WACCDetailedResultsDiscountFactorNumber",
                        String.format("%.2f", DiscountFactor));

                //Discount future cash flows to their present values
                //Presentvalue = Expected Cash Flow ÷ (1+Discount Rate)^Number of periods
                Presentvalue = FreeCashFlow /
                        (1.0+Math.pow(WACCDetailedObject.getWACC(), (double)
                                WACCDetailedObject.getNumberOfForecastPeriods()));

                data.get(currentyear).put("WACCDetailedResultsPVNumber",
                        String.format("%.2f", Presentvalue));
            }

        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MainAdapter(data);
        mRecyclerView.setAdapter(mAdapter);


    }

    protected HashMap<String, String> innerDataGenerator(String key, String value) {
        final HashMap<String, String> innerdata = new HashMap<String, String>();
        innerdata.put(key,value);

        return innerdata;
    }


}
