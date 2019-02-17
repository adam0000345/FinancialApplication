package com.example.finance.googlesheetsexample;

import android.app.Application;

public class FinanceModelSingleton {
    private static double data;
    public static double getData() {return data;}
    public static void setData(Double data) {FinanceModelSingleton.data = data;}

}
