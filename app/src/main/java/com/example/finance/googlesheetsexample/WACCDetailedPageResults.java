package com.example.finance.googlesheetsexample;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.facebook.drawee.backends.pipeline.Fresco;

public class WACCDetailedPageResults extends NavBarAndTitle {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getLayoutInflater().inflate(R.layout.waccdetailedpageresults, frameLayout);



        //http://pages.stern.nyu.edu/~adamodar/New_Home_Page/AccPrimer/accstate.htm

        //http://people.stern.nyu.edu/adamodar/pdfiles/eqnotes/valenhdcf.pdf8



        //Free Cash Flows To Firm Calculation
        //EBIT(1-t) - (Capital Expenditures- Depreciation) - Change in non-cash working capital=

        //Free Cash Flow to Firm (FCFF)

        //Cash Flows To Equity Investors
        //Net income - (Capital Expenditures - Depreciation) - Change in non-cash
        //Working Capital - (Principal Repaid - New Debt Issues) - Preferred Dividend
        //-new Debt Issues = Free Cash Flow to Equity

        double BaseYearRevenue = 1000;
        double TaxRate = .03;
        //Operating Profit Margin = Operating Income / Sales Revenue
        //EBIT in period t = Revenues in period t * Expected operating margin in period t
        //Thus, if you expect operating margins to change over time, you should not use the fundamental
        // growth equation developed in the last section as your base growth rate. Instead, you should forecast
        // revenues and margins over time, and estimate the operating income as the product of the two.
        double CostOfGoodsSoldAsPercentageOfRevenue = .04;

        //Calculate Gross Profit
        //Gross Profit = Revenue - COGS
        double GrossProfit = BaseYearRevenue - CostOfGoodsSoldAsPercentageOfRevenue;



        //includes Research and Development costs
        double SellingGeneralAdministrativeExpensesAsPercentageOfRevenue = .04;
        //use above
        //Operating Income Calculation


        double InitialEBITPercentageOfRevenue = .03;
        //allows you to predict what the final EBIT would be in the last period, left to default at
        //InitialEBIT
        double LastPeriodEBITPercentageOfRevenue = .03;
        double CapitalExpenditurePercentageOfRevenue = .03;

        //       OperatingIncome (EBIT) = Gross Income -
//                (Operating Expenses + Depreciation & Amortization); if Capex is equal to Depreciation
        double CustomEBIT = GrossProfit - (SellingGeneralAdministrativeExpensesAsPercentageOfRevenue
                + CapitalExpenditurePercentageOfRevenue);

        double StraightLineDepreciationNumberOfYears = 4;



        double BaseYearDepreciation = 200;
        //given multiple year input, different forecasted revenue numbers, different operating NWC calculated
        //as a result, different changes in non-cash working capital is calculated
        double ChangeInNonCashWorkingCapital = 300;

        //       OperatingIncome (EBIT) = Gross Income -
//                (Operating Expenses + Depreciation & Amortization); if Straight-line approach is used
        double CustomEBITTwo = GrossProfit - (SellingGeneralAdministrativeExpensesAsPercentageOfRevenue
                + (BaseYearDepreciation/StraightLineDepreciationNumberOfYears));

        //Free Cash Flows To Firm Calculation
        //Free Cash Flow to Firm (FCFF)
        //EBIT(1-t) - (Capital Expenditures- Depreciation)
        // //- Change in non-cash working capital
        //assumption EBIT is provided, depreciation = capex
        double FreeCashFlowOne = InitialEBITPercentageOfRevenue * (1-TaxRate)
                - (CapitalExpenditurePercentageOfRevenue - BaseYearDepreciation
        )-ChangeInNonCashWorkingCapital;
        ////assumption EBIT is provided, depreciation = straightline
        double FreeCashFlowTwo = InitialEBITPercentageOfRevenue * (1-TaxRate)
                - (CapitalExpenditurePercentageOfRevenue -
                BaseYearDepreciation/StraightLineDepreciationNumberOfYears
        )-ChangeInNonCashWorkingCapital;
        ////assumption EBIT is not provided, CustomEBIT, depreciation = capex
        double FreeCashFlowThree = CustomEBIT * (1-TaxRate)
                - (CapitalExpenditurePercentageOfRevenue -
                BaseYearDepreciation
        )-ChangeInNonCashWorkingCapital;
        ////assumption EBIT is not provided, CustomEBITTwo, depreciation = capex
        double FreeCashFlowFour = CustomEBITTwo * (1-TaxRate)
                - (CapitalExpenditurePercentageOfRevenue -
                BaseYearDepreciation
        )-ChangeInNonCashWorkingCapital;






    }

}
