package com.example.finance.googlesheetsexample;


import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;

public class WACCDetailedObject {



    // Create the instance
    private static WACCDetailedObject instance;

    private static String OperatingIncomeOption;
    private static String DepreciationOption;
    private static String WACCOption;
    private static String TerminalGrowthRateOption;
    private static String CompanyName;
    private static int BaseYear;
    private static int NumberOfForecastPeriods;
    private static double CurrentYearRevenue;
    private static double AnnualRevenueGrowthPercentage;
    private static boolean RevenueGrowthFadeToTerminalGrowth;
    private static double CostOfGoodsSoldAsPercentage;
    private static double Cash;
    private static double Debt;
    private static double MarketCapitalization;
    private static double EquityBeta;
    private static double RiskFreeRate;
    private static double MarketRiskPremium;
    private static double LeveredCostOfEquity;
    private static double CostOfDebt;
    private static double AverageCostOfCapital;
    private static double NumberOfShares;
    private static double TerminalROIC;
    private static double TerminalReinvestmentRate;
    private static double TerminalGrowthRate;


    private static double WACC;
    private static double TerminalWACC;
    private static double SGAValue;
    private static double InitialEBIT;
    private static double LastYearEBIT;
    private static double CapitalExpenditure;
    private static double OperatingNWC;
    private static int StraightLineDepreciationYears;
    private static double TaxRate;
    private static double BaseYearDepreciation;

    public static WACCDetailedObject getInstance() {
        if (instance == null) {
            synchronized (WACCDetailedObject.class) {
                if (instance == null)
                    instance = new WACCDetailedObject();
            }
        }
        // Return the instance
        return instance;
    }

    public static String getOperatingIncomeOption() {
        return OperatingIncomeOption;
    }

    public static void setOperatingIncomeOption(String operatingIncomeOption) {
        OperatingIncomeOption = operatingIncomeOption;
    }

    public static String getDepreciationOption() {
        return DepreciationOption;
    }

    public static void setDepreciationOption(String depreciationOption) {
        DepreciationOption = depreciationOption;
    }

    public static String getWACCOption() {
        return WACCOption;
    }

    public static void setWACCOption(String WACCOption) {
        WACCDetailedObject.WACCOption = WACCOption;
    }

    public static String getTerminalGrowthRateOption() {
        return TerminalGrowthRateOption;
    }

    public static void setTerminalGrowthRateOption(String terminalGrowthRateOption) {
        TerminalGrowthRateOption = terminalGrowthRateOption;
    }

    public static String getCompanyName() {
        return CompanyName;
    }

    public static void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public static int getBaseYear() {
        return BaseYear;
    }

    public static void setBaseYear(int baseYear) {
        BaseYear = baseYear;
    }

    public static int getNumberOfForecastPeriods() {
        return NumberOfForecastPeriods;
    }

    public static void setNumberOfForecastPeriods(int numberOfForecastPeriods) {
        NumberOfForecastPeriods = numberOfForecastPeriods;
    }

    public static double getCurrentYearRevenue() {
        return CurrentYearRevenue;
    }

    public static void setCurrentYearRevenue(double currentYearRevenue) {
        CurrentYearRevenue = currentYearRevenue;
    }

    public static double getAnnualRevenueGrowthPercentage() {
        return AnnualRevenueGrowthPercentage;
    }

    public static void setAnnualRevenueGrowthPercentage(double annualRevenueGrowthPercentage) {
        AnnualRevenueGrowthPercentage = annualRevenueGrowthPercentage;
    }

    public static boolean isRevenueGrowthFadeToTerminalGrowth() {
        return RevenueGrowthFadeToTerminalGrowth;
    }

    public static void setRevenueGrowthFadeToTerminalGrowth(boolean revenueGrowthFadeToTerminalGrowth) {
        RevenueGrowthFadeToTerminalGrowth = revenueGrowthFadeToTerminalGrowth;
    }

    public static double getCostOfGoodsSoldAsPercentage() {
        return CostOfGoodsSoldAsPercentage;
    }

    public static void setCostOfGoodsSoldAsPercentage(double costOfGoodsSoldAsPercentage) {
        CostOfGoodsSoldAsPercentage = costOfGoodsSoldAsPercentage;
    }

    public static double getCash() {
        return Cash;
    }

    public static void setCash(double cash) {
        Cash = cash;
    }

    public static double getDebt() {
        return Debt;
    }

    public static void setDebt(double debt) {
        Debt = debt;
    }

    public static double getMarketCapitalization() {
        return MarketCapitalization;
    }

    public static void setMarketCapitalization(double marketCapitalization) {
        MarketCapitalization = marketCapitalization;
    }

    public static double getEquityBeta() {
        return EquityBeta;
    }

    public static void setEquityBeta(double equityBeta) {
        EquityBeta = equityBeta;
    }

    public static double getRiskFreeRate() {
        return RiskFreeRate;
    }

    public static void setRiskFreeRate(double riskFreeRate) {
        RiskFreeRate = riskFreeRate;
    }

    public static double getMarketRiskPremium() {
        return MarketRiskPremium;
    }

    public static void setMarketRiskPremium(double marketRiskPremium) {
        MarketRiskPremium = marketRiskPremium;
    }

    public static double getLeveredCostOfEquity() {
        return LeveredCostOfEquity;
    }

    public static void setLeveredCostOfEquity(double leveredCostOfEquity) {
        LeveredCostOfEquity = leveredCostOfEquity;
    }

    public static double getCostOfDebt() {
        return CostOfDebt;
    }

    public static void setCostOfDebt(double costOfDebt) {
        CostOfDebt = costOfDebt;
    }

    public static double getAverageCostOfCapital() {
        return AverageCostOfCapital;
    }

    public static void setAverageCostOfCapital(double averageCostOfCapital) {
        AverageCostOfCapital = averageCostOfCapital;
    }

    public static double getNumberOfShares() {
        return NumberOfShares;
    }

    public static void setNumberOfShares(double numberOfShares) {
        NumberOfShares = numberOfShares;
    }

    public static double getTerminalROIC() {
        return TerminalROIC;
    }

    public static void setTerminalROIC(double terminalROIC) {
        TerminalROIC = terminalROIC;
    }

    public static double getTerminalReinvestmentRate() {
        return TerminalReinvestmentRate;
    }

    public static void setTerminalReinvestmentRate(double terminalReinvestmentRate) {
        TerminalReinvestmentRate = terminalReinvestmentRate;
    }

    public static double getTerminalGrowthRate() {
        return TerminalGrowthRate;
    }

    public static void setTerminalGrowthRate(double terminalGrowthRate) {
        TerminalGrowthRate = terminalGrowthRate;
    }

    public static double getWACC() {
        return WACC;
    }

    public static void setWACC(double wACC) {
        WACC = wACC;
    }

    public static double getTerminalWACC() {
        return TerminalWACC;
    }

    public static void setTerminalWACC(double terminalWACC) {
        TerminalWACC = terminalWACC;
    }

    public static double getSGAValue() {
        return SGAValue;
    }

    public static void setSGAValue(double sGAValue) {
        SGAValue = sGAValue;
    }

    public static double getInitialEBIT() {
        return InitialEBIT;
    }

    public static void setInitialEBIT(double initialEBIT) {
        InitialEBIT = initialEBIT;
    }

    public static double getLastYearEBIT() {
        return LastYearEBIT;
    }

    public static void setLastYearEBIT(double lastYearEBIT) {
        LastYearEBIT = lastYearEBIT;
    }

    public static double getCapitalExpenditure() {
        return CapitalExpenditure;
    }

    public static void setCapitalExpenditure(double capitalExpenditure) {
        CapitalExpenditure = capitalExpenditure;
    }

    public static double getOperatingNWC() {
        return OperatingNWC;
    }

    public static void setOperatingNWC(double operatingNWC) {
        OperatingNWC = operatingNWC;
    }

    public static int getStraightLineDepreciationYears() {
        return StraightLineDepreciationYears;
    }

    public static void setStraightLineDepreciationYears(int straightLineDepreciationYears) {
        StraightLineDepreciationYears = straightLineDepreciationYears;
    }

    public static double getTaxRate() {
        return TaxRate;
    }

    public static void setTaxRate(double taxRate) {
        TaxRate = taxRate;
    }

    public static double getBaseYearDepreciation() {
        return BaseYearDepreciation;
    }

    public static void setBaseYearDepreciation(double baseYearDepreciation) {
        BaseYearDepreciation = baseYearDepreciation;
    }
}
