package com.example.finance.googlesheetsexample.androidlabs.gsheets1;

//MyDataModel


/**
 * the DataModel is one row of data from the excel sheet, it can be set in the following ways:
 * e.g. "year":3,"cftoequity":275.63,"int(1-t)":99.22000000000003,"cftofirm":374.85 or
 * "terminal value":"terminal value","terminalcftoequity":3946.5,"terminalint(1-t)":"","terminalcftofirm":6000
 */
public class MyDataModel {

    private int year;

    private int cftoequity;

    private int difference;

    private int cftofirm;

    private int terminalcftoequity;

    private int terminaldifference;

    private int terminalcftofirm;

    //to identify that we are looking at the terminal line

    private boolean terminalboolean = false;

    //a setter for difference is not required because this is done in Google Sheets


    public void flipTerminalboolean(){
        terminalboolean = true;
    }

    public boolean getterminal() {
        return terminalboolean;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCashFlowToEquity() {
        return cftoequity;
    }

    public void setCashFlowToEquity(int cftoequity) {
        this.cftoequity = cftoequity;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    public int getCashFlowToFirm() {
        return cftofirm;
    }

    public void setCashFlowToFirm(int cftofirm) {
        this.cftofirm = cftofirm;
    }

    public int getTerminalCashFlowToEquity() {
        return terminalcftoequity;
    }

    public void setTerminalCashFlowToEquity(int terminalCashFlowToEquity) {
        this.terminalcftoequity = terminalCashFlowToEquity;
    }

    public int getTerminaldifference() {
        return terminaldifference;
    }

    public void setTerminaldifference(int terminaldifference) {
        this.terminaldifference = terminaldifference;
    }

    public int getTerminalcftofirm() {
        return terminalcftofirm;
    }

    public void setTerminalCashFlowToFirm(int terminalcftofirm) {
        this.terminalcftofirm = terminalcftofirm;
    }




}
