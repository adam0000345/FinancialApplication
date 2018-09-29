package com.example.finance.googlesheetsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;


import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WACCDetailedPageTwo extends NavBarAndTitle {


    private TextView WACCDetailedPageTwoTitle;
    private TextView WACCDetailedPageTwoOperatingIncome;
    private Spinner WACCPageTwoOperatingIncomeSpinner;
    private TextView WACCDetailedPageTwoDepreciation;
    private Spinner WACCDetailedPageTwoDepreciationSpinner;
    private TextView WACCDetailedPageTwoWACC;
    private Spinner WACCDetailedPageTwoWACCSpinner;
    private TextView WACCDetailedPageTwoTerminalGrowthRate;
    private Spinner WACCDetailedPageTwoTerminalGrowthRateSpinner;
    private TextView WACCDetailedPageTwoNotes;
    //might have to use spinner adapters

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getLayoutInflater().inflate(R.layout.waccdetailedpagetwo,
                frameLayout);



        WACCDetailedPageTwoOperatingIncome = (TextView) this.findViewById(R.id.WACCDetailedPageTwoOperatingIncome);
        WACCDetailedPageTwoDepreciation = (TextView) this.findViewById(R.id.WACCDetailedPageTwoDepreciation);
        WACCDetailedPageTwoWACC = (TextView) this.findViewById(R.id.WACCDetailedPageTwoWACC);
        WACCDetailedPageTwoTerminalGrowthRate = (TextView) this.findViewById(R.id.WACCDetailedPageTwoTerminalGrowthRate);
        WACCDetailedPageTwoNotes = (TextView) this.findViewById(R.id.WACCDetailedPageTwoNotes);


        addItemsOnSpinner1();
        addItemsOnSpinner2();
        addItemsOnSpinner3();
        addItemsOnSpinner4();




        WACCDetailedPageTwoTitle = (TextView) this.findViewById(R.id.WACCDetailedPageTwoTitle);
        WACCDetailedPageTwoTitle.setText("A Few Key Questions Before You Start" +
                ":Before putting in base-year numbers, think through how you wish " +
                "to input: Operating Income (i.e., EBIT), Depreciation, WACC, and " +
                "Terminal Growth Rate (g). Choose one option under each.");

        WACCDetailedPageTwoNotes = (TextView) this.findViewById(R.id.WACCDetailedPageTwoNotes);
        WACCDetailedPageTwoNotes.setText("* rE = Levered cost of equity; rD = Cost of debt" +
                "; rF = Risk-free rate; ß = Equity beta; " +
                "MRP = Market risk premium." +
                "** If you choose this option, note that you must also " +
                "input rF.");

        WACCDetailedPageTwoOperatingIncome.setText("Operating Income");

        WACCDetailedPageTwoOperatingIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageTwo.this, PopUpWindow.class);
                intent.putExtra("message", "Terminal Value (TV) is the " +
                        "continuing value of the business after the detailed forecast (or, 'proforma' " +
                        ") period ends.  It is calculated using the constant growth model: " +
                        "\n\nTV = FCFFr + (WACCr - g)," +
                        "\n\nwhere FCFFr is the cash flow in the first period after the forecast " +
                        "period ends (if the forecast period is seven years, this year 8), WACCr " +
                        "is the cost of capital in perpetuity after the forecast period, and " +
                        "g is the Terminal Growth Rate (the growth rate in free cash flow in " +
                        "perpetuity)." +
                        "\n\n The enterprise value, EV, is the present value of TV plus the " +
                        "present value of cash flows for each year of the proforma period. " +
                        "\n\n Some analysts use multiples (e.g., EV/EBITDA, EV/Sales) " +
                        "to estimate TV. However, g is implicit (and therefore, hidden) " +
                        "in a multiple, while iti s made explicit in the constant growth model. " +
                        "Moreover, the danger with using multiples is that they undercut " +
                        "the very notion that we are undertaking a discounted cash flow " +
                        "(or intrinsic) valuation, making this instead a hybrid relative valuation.");

                startActivity(intent);

            }

        });

        WACCDetailedPageTwoDepreciation.setText("Depreciation");

        WACCDetailedPageTwoDepreciation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageTwo.this, PopUpWindow.class);
                intent.putExtra("message", "Under the accrual method of " +
                        "accounting, a company's Capex s not deducted as outflow " +
                        " in the year in which it was incurred.  Rather, a " +
                        "Depreciation charge - a fraction of " +
                        "the Capex - is annually deducted. Depreciation " +
                        "is called a 'non-cash' charge since no cash leaves " +
                        "the firm even though it is booked as an 'expense.' " +
                        "\n\nThe most common method used in financial " +
                        "reporting is the 'straight-line' method. " +
                        "Thus, for example, if we spend $100 on an " +
                        "asset with a 5-year depreciable life, $20 " +
                        "is 'deducted' from revenue every year for the " +
                        "next five years as though money left the company, " +
                        " even though it did not (it left when " +
                        "we bought the asset)." +
                        "\n\nThe key to choosing here is to recognize that " +
                        "Depreciation comes from Capex in prior years " +
                        "and the two items are therefore joined at the " +
                        "hip.  The first choice models this explicitly, " +
                        "by augmenting Capex in each year over the " +
                        "depreciable life and adding this Depreciation to " +
                        "the starting year's number.  The alternative " +
                        "choice, Depreciation = Capex is easy to make, " +
                        "but is incompatible with a rapidly-growing firm " +
                        "since it keeps the fixed asset base unchanged while " +
                        "growing revenue and EBIT. It may be a reasonable " +
                        "choice for firms that are mature, or expect " +
                        "to grow from improvements in operating efficiencies " +
                        "(rather than revenue growth).");

                startActivity(intent);

            }

        });

        WACCDetailedPageTwoWACC.setText("WACC*");

        WACCDetailedPageTwoDepreciation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageTwo.this, PopUpWindow.class);
                intent.putExtra("message", "The concept of WACC, " +
                                "cost of capital is explained in the " +
                                "previous page.  We will focus here on how to " +
                                "input it into the model. " +
                                "\n\nThe simplest choice is to enter it " +
                                "directly (you will get to that soon).  You " +
                                "could use the cost of capital for the firm, or that " +
                                "for other firms in the sector to which the firm belongs. " +
                                "(Check the data set of indsutry averages for this " +
                                "estiamte. It is in US dollars.  If you want " +
                                "to convert to a different currency, an approximation " +
                                "is to add the difference in inflation rates between the " +
                                "currency and the US dollar to this WACC). " +
                                "\n\nIn the secoond choice, you have to enter the " +
                                "cost of equtiy (rE) and the cost of debt (rD) for " +
                                "the firm. (For guidance, industry averages for these " +
                                "nubmers are available in the data set.) " +
                                "\n\nIn the third choice, you can use the Capital " +
                                "Asset Pricing Model (CAPM) to estimate rE: " +
                                "\n\nrE = rF + BE x MRP " +
                                "\n\nrF is the risk-free rate in the currency in which " +
                                "cash flows are denominated, BE measures the " +
                                "relative risk of your stock against a market index, and " +
                                "MRP is the market (or 'equity') risk premium, " +
                                "reflecting how risky investors percieve equity as an " +
                                "investment class to be, relative to a risk-free investment.");

                startActivity(intent);

            }

        });


        WACCDetailedPageTwoTerminalGrowthRate.setText("Terminal Growth Rate, g");

        WACCDetailedPageTwoTerminalGrowthRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WACCDetailedPageTwo.this, PopUpWindow.class);
                intent.putExtra("message", "The Terminal Growth Rate, g, " +
                        "is the growth rate you anticipate " +
                        "for this firm in perpetuity.  Since " +
                        "this growth rate goes into a terminal " +
                        "value equation, small changes in the growth " +
                        "rate - all else constant - " +
                        "can translate into large changes in value. " +
                        "  Thus, casually changing the growth rate " +
                        "can lead to potentially large swings in DCF " +
                        "valuation." +
                        "\n\nTo anchor the growth rate, follow two " +
                        "simple rules.  The first, ensure that g " +
                        "does not exceed the growth rate of the " +
                        "economy.  In fact, a further simplication is " +
                        "this: g should not exceed the risk-free rate " +
                        "The second is to ensure that you are " +
                        "setting aside enough as reinvestment to " +
                        "sustain your growth rate.  If the Terminal " +
                        "Reinvestment Rate is RR, and Terminal Return " +
                        "on Invested Capital is ROIC, then: " +
                        "\n\nRR = g + ROIC " +
                        "\n\n You are given three choices to input g. " +
                        "The first allows you to enter whatever " +
                        "growth rate you want  The second sets the " +
                        "terminal growht rate to the risk-free rate. " +
                        "With either of these choices, make sure to " +
                        "follow the appropriate rules above.  If " +
                        "you are concerned about potential " +
                        "inconsistencies, we strongly suggest " +
                        "you follow the third choice, where you " +
                        "input the terminal RR and terminal ROIC.  We " +
                        "would suggest starting with the ROIC, and setting " +
                        "it at roughly the firm's WACC (mature firms " +
                        "do not earn a huge ROIC).  Then choose " +
                        "an RR that will deliver a growth rate below " +
                        "or equal to the risk-free rate. (As an additional " +
                "sanity check, you may wish to compare your chosen RR against " +
                "the implied RR in the last proforma period).");

                startActivity(intent);

            }

        });







    }
    // add items into spinner dynamically
    public void addItemsOnSpinner1() {

        WACCPageTwoOperatingIncomeSpinner =
                (Spinner) findViewById(R.id.WACCPageTwoOperatingIncomeSpinner);


        List<String> list = new ArrayList<String>();
        list.add("Will input percent EBIT (Operating Margin)");
        list.add("Will input percent CGS and percent SGA");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        WACCPageTwoOperatingIncomeSpinner.setAdapter(dataAdapter);


        WACCPageTwoOperatingIncomeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                String text = item.toString();
                getWaccDetailedObject().setOperatingIncomeOption(text);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });


    }

    // add items into spinner dynamically
    public void addItemsOnSpinner2() {

        WACCDetailedPageTwoDepreciationSpinner = (Spinner) findViewById(R.id.WACCDetailedPageTwoDepreciationSpinner);


        List<String> list = new ArrayList<String>();
        list.add("Will use straight line rule");
        list.add("Will assume Depreciation = Capex");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        WACCDetailedPageTwoDepreciationSpinner.setAdapter(dataAdapter);



        WACCDetailedPageTwoDepreciationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                String text = item.toString();
                getWaccDetailedObject().setDepreciationOption(text);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
    }

    // add items into spinner dynamically
    public void addItemsOnSpinner3() {


        WACCDetailedPageTwoWACCSpinner = (Spinner) findViewById(R.id.WACCDetailedPageTwoWACCSpinner);

        List<String> list = new ArrayList<String>();
        list.add("Will input WACC directly");
        list.add("Will input rE, rD*");
        list.add("Will input rF, ß, rD, and MRP*");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        WACCDetailedPageTwoWACCSpinner.setAdapter(dataAdapter);



        WACCDetailedPageTwoWACCSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                String text = item.toString();
                getWaccDetailedObject().setWACCOption(text);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
    }

    // add items into spinner dynamically
    public void addItemsOnSpinner4() {


        WACCDetailedPageTwoTerminalGrowthRateSpinner = (Spinner)
                findViewById(R.id.WACCDetailedPageTwoTerminalGrowthRateSpinner);

        List<String> list = new ArrayList<String>();
        list.add("Will input g directly");
        list.add("Will assume that g=rF**");
        list.add("Will input ROIC and RR for g = (ROIC)(RR)");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        WACCDetailedPageTwoTerminalGrowthRateSpinner.setAdapter(dataAdapter);



        WACCDetailedPageTwoTerminalGrowthRateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                String text = item.toString();
                getWaccDetailedObject().setTerminalGrowthRateOption(text);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
    }

}
