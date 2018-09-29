package com.example.finance.googlesheetsexample;

import android.os.Parcel;
import android.os.Parcelable;

public class WACCDetailedObject{

    private String OperatingIncomeOption;
    private String DepreciationOption;
    private String WACCOption;
    private String TerminalGrowthRateOption;
    private String CompanyName;
    private int BaseYear;
    private int NumberOfForecastPeriods;
    private int BaseRevenue;
    private double AnnualRevenueGrowthPercentage;
    private boolean RevenueGrowthFadeToTerminalGrowth;
    private double CostOfGoodsSoldAsPercentage;

    public double getCash() {
        return Cash;
    }

    public void setCash(double cash) {
        Cash = cash;
    }

    public double getDebt() {
        return Debt;
    }

    public void setDebt(double debt) {
        Debt = debt;
    }

    public double getMarketCapitalization() {
        return MarketCapitalization;
    }

    public void setMarketCapitalization(double marketCapitalization) {
        MarketCapitalization = marketCapitalization;
    }

    public double getEquityBeta() {
        return EquityBeta;
    }

    public void setEquityBeta(double equityBeta) {
        EquityBeta = equityBeta;
    }

    public double getRiskFreeRate() {
        return RiskFreeRate;
    }

    public void setRiskFreeRate(double riskFreeRate) {
        RiskFreeRate = riskFreeRate;
    }

    public double getMarketRiskPremium() {
        return MarketRiskPremium;
    }

    public void setMarketRiskPremium(double marketRiskPremium) {
        MarketRiskPremium = marketRiskPremium;
    }

    public double getLeveredCostOfEquity() {
        return LeveredCostOfEquity;
    }

    public void setLeveredCostOfEquity(double leveredCostOfEquity) {
        LeveredCostOfEquity = leveredCostOfEquity;
    }

    public double getCostOfDebt() {
        return CostOfDebt;
    }

    public void setCostOfDebt(double costOfDebt) {
        CostOfDebt = costOfDebt;
    }

    public double getAverageCostOfCapital() {
        return AverageCostOfCapital;
    }

    public void setAverageCostOfCapital(double averageCostOfCapital) {
        AverageCostOfCapital = averageCostOfCapital;
    }

    public int getNumberOfShares() {
        return NumberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        NumberOfShares = numberOfShares;
    }

    public double getTerminalROIC() {
        return TerminalROIC;
    }

    public void setTerminalROIC(double terminalROIC) {
        TerminalROIC = terminalROIC;
    }

    public double getTerminalReinvestmentRate() {
        return TerminalReinvestmentRate;
    }

    public void setTerminalReinvestmentRate(double terminalReinvestmentRate) {
        TerminalReinvestmentRate = terminalReinvestmentRate;
    }

    public double getTerminalGrowthRate() {
        return TerminalGrowthRate;
    }

    public void setTerminalGrowthRate(double terminalGrowthRate) {
        TerminalGrowthRate = terminalGrowthRate;
    }

    public double getTerminalWACC() {
        return TerminalWACC;
    }

    public void setTerminalWACC(double terminalWACC) {
        TerminalWACC = terminalWACC;
    }

    private double Cash;
    private double Debt;
    private double MarketCapitalization;
    private double EquityBeta;
    private double RiskFreeRate;
    private double MarketRiskPremium;
    private double LeveredCostOfEquity;
    private double CostOfDebt;
    private double AverageCostOfCapital;
    private int NumberOfShares;
    private double TerminalROIC;
    private double TerminalReinvestmentRate;
    private double TerminalGrowthRate;
    private double TerminalWACC;



    public boolean isRevenueGrowthFadeToTerminalGrowth() {
        return RevenueGrowthFadeToTerminalGrowth;
    }

    public double getSGAValue() {
        return SGAValue;
    }

    public void setSGAValue(double SGAValue) {
        this.SGAValue = SGAValue;
    }

    public double getInitialEBIT() {
        return InitialEBIT;
    }

    public void setInitialEBIT(double initialEBIT) {
        InitialEBIT = initialEBIT;
    }

    public double getLastYearEBIT() {
        return LastYearEBIT;
    }

    public void setLastYearEBIT(double lastYearEBIT) {
        LastYearEBIT = lastYearEBIT;
    }

    public double getCapitalExpenditure() {
        return CapitalExpenditure;
    }

    public void setCapitalExpenditure(double capitalExpenditure) {
        CapitalExpenditure = capitalExpenditure;
    }

    public double getOperatingNWC() {
        return OperatingNWC;
    }

    public void setOperatingNWC(double operatingNWC) {
        OperatingNWC = operatingNWC;
    }

    public int getStraightLineDepreciationYears() {
        return StraightLineDepreciationYears;
    }

    public void setStraightLineDepreciationYears(int straightLineDepreciationYears) {
        StraightLineDepreciationYears = straightLineDepreciationYears;
    }

    public double getTaxRate() {
        return TaxRate;
    }

    public void setTaxRate(double taxRate) {
        TaxRate = taxRate;
    }

    public double getBaseYearDepreciation() {
        return BaseYearDepreciation;
    }

    public void setBaseYearDepreciation(double baseYearDepreciation) {
        BaseYearDepreciation = baseYearDepreciation;
    }

    private double SGAValue;
    private double InitialEBIT;
    private double LastYearEBIT;
    private double CapitalExpenditure;
    private double OperatingNWC;
    private int StraightLineDepreciationYears;
    private double TaxRate;
    private double BaseYearDepreciation;


    public String getDepreciationOption() {
        return DepreciationOption;
    }

    public void setDepreciationOption(String depreciationOption) {
        DepreciationOption = depreciationOption;
    }

    public String getOperatingIncomeOption() {
        return OperatingIncomeOption;
    }

    public void setOperatingIncomeOption(String operatingIncomeOption) {
        DepreciationOption = operatingIncomeOption;
    }


    public String getWACCOption(){
        return WACCOption;
    }

    public void setWACCOption(String WACCOption) {
        DepreciationOption = WACCOption;
    }


    public String getTerminalGrowthRateOption(){
        return TerminalGrowthRateOption;
    }

    public void setTerminalGrowthRateOption(String terminalGrowthRateOption) {
        DepreciationOption = terminalGrowthRateOption;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public int getBaseYear() {
        return BaseYear;
    }

    public void setBaseYear(int baseYear) {
        BaseYear = baseYear;
    }


    public int getNumberOfForecastPeriods() {
        return NumberOfForecastPeriods;
    }

    public void setNumberOfForecastPeriods(int numberOfForecastPeriods) {
        NumberOfForecastPeriods = numberOfForecastPeriods;
    }

    public int getBaseRevenue() {
        return BaseRevenue;
    }

    public void setBaseRevenue(int baseRevenue) {
        BaseRevenue = baseRevenue;
    }

    public double getAnnualRevenueGrowthPercentage() {
        return AnnualRevenueGrowthPercentage;
    }

    public void setAnnualRevenueGrowthPercentage(double annualRevenueGrowthPercentage) {
        AnnualRevenueGrowthPercentage = annualRevenueGrowthPercentage;
    }

    public boolean getRevenueGrowthFadeToTerminalGrowth() {
        return RevenueGrowthFadeToTerminalGrowth;
    }

    public void setRevenueGrowthFadeToTerminalGrowth(boolean revenueGrowthFadeToTerminalGrowth) {
        RevenueGrowthFadeToTerminalGrowth = revenueGrowthFadeToTerminalGrowth;
    }


    public double getCostOfGoodsSoldAsPercentage() {
        return CostOfGoodsSoldAsPercentage;
    }

    public void setCostOfGoodsSoldAsPercentage(double costOfGoodsSoldAsPercentage) {
        CostOfGoodsSoldAsPercentage = costOfGoodsSoldAsPercentage;
    }




}
