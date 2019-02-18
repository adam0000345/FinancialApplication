package com.example.finance.googlesheetsexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    //Outer string for year, inner set Key = WACCDetailedResultsValueName,
    // Value = WACCDetailedResultsValue

    private Map<Integer, HashMap<String, String>> mDataset;

    public MainAdapter(Map<Integer, HashMap<String, String>> mDataset) {
        this.mDataset = mDataset;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView WACCDetailedResultsYearNumber;
        public TextView WACCDetailedResultsRevenueNumber;
        public TextView WACCDetailedResultsCostOfGoodsNumber;
        public TextView WACCDetailedPageResultsSGACostNumber;
        public TextView WACCDetailedResultsEBITNumber;
        public TextView WACCDetailedResultsDepreciationNumber;
        public TextView WACCDetailedResultsOperatingCashFlowNumber;
        public TextView WACCDetailedResultsCashExpenditureNumber;
        public TextView WACCDetailedResultsChangeInNetWorkingCapitalNumber;
        public TextView WACCDetailedResultsFreeCashFlowNumber;
        public TextView WACCDetailedResultsWACCNumber;
        public TextView WACCDetailedResultsDiscountFactorNumber;
        public TextView WACCDetailedResultsPVNumber;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

                WACCDetailedResultsYearNumber = (TextView)
                        itemView.findViewById(R.id.WACCDetailedResultsYearNumber);
                WACCDetailedResultsRevenueNumber = (TextView)
                        itemView.findViewById(R.id.WACCDetailedResultsRevenueNumber);
                WACCDetailedResultsCostOfGoodsNumber = (TextView)
                        itemView.findViewById(R.id.WACCDetailedResultsCostOfGoodsNumber);
                WACCDetailedPageResultsSGACostNumber = (TextView)
                        itemView.findViewById(R.id.WACCDetailedPageResultsSGANumber);
                WACCDetailedResultsEBITNumber = (TextView)
                        itemView.findViewById(R.id.WACCDetailedResultsEBITNumber);
                WACCDetailedResultsDepreciationNumber = (TextView)
                        itemView.findViewById(R.id.WACCDetailedResultsDepreciationNumber);
                WACCDetailedResultsOperatingCashFlowNumber = (TextView)
                        itemView.findViewById(R.id.WACCDetailedResultsOperatingCashFlowNumber);
                WACCDetailedResultsCashExpenditureNumber= (TextView)
                        itemView.findViewById(R.id.WACCDetailedResultsCashExpenditureNumber);
                WACCDetailedResultsChangeInNetWorkingCapitalNumber = (TextView)
                        itemView.findViewById(R.id.WACCDetailedResultsChangeInNetWorkingCapitalNumber);
                WACCDetailedResultsFreeCashFlowNumber = (TextView)
                        itemView.findViewById(R.id.WACCDetailedResultsFreeCashFlowNumber);
                WACCDetailedResultsWACCNumber = (TextView)
                        itemView.findViewById(R.id.WACCDetailedResultsWACCNumber);
                WACCDetailedResultsDiscountFactorNumber = (TextView)
                        itemView.findViewById(R.id.WACCDetailedResultsDiscountFactorNumber);
                WACCDetailedResultsPVNumber = (TextView)
                        itemView.findViewById(R.id.WACCDetailedResultsPVNumber);
            }
    }


    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resultscardview, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);


        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder viewHolder, int i) {
        //if (viewHolder.WACCDetailedResultsYearNumber.)
        viewHolder.WACCDetailedResultsYearNumber.setText(mDataset.get(i).get("WACCDetailedResultsYearNumber"));
        viewHolder.WACCDetailedResultsRevenueNumber.setText(mDataset.get(i).get("WACCDetailedResultsRevenueNumber"));
        viewHolder.WACCDetailedResultsCostOfGoodsNumber.setText(mDataset.get(i).get("WACCDetailedResultsCostOfGoodsNumber"));
        viewHolder.WACCDetailedPageResultsSGACostNumber.setText(mDataset.get(i).get("WACCDetailedResultsSGANumber"));
        viewHolder.WACCDetailedResultsEBITNumber.setText(mDataset.get(i).get("WACCDetailedResultsEBITNumber"));
        viewHolder.WACCDetailedResultsDepreciationNumber.setText(mDataset.get(i).get("WACCDetailedResultsDepreciationNumber"));
        viewHolder.WACCDetailedResultsOperatingCashFlowNumber.setText(mDataset.get(i).get("WACCDetailedResultsOperatingCashFlowNumber"));
        viewHolder.WACCDetailedResultsCashExpenditureNumber.setText(mDataset.get(i).get("WACCDetailedResultsCashExpenditureNumber"));
        viewHolder.WACCDetailedResultsChangeInNetWorkingCapitalNumber.setText(mDataset.get(i).get("WACCDetailedResultsChangeInNetWorkingCapitalNumber"));
        viewHolder.WACCDetailedResultsFreeCashFlowNumber.setText(mDataset.get(i).get("WACCDetailedResultsFreeCashFlowNumber"));
        viewHolder.WACCDetailedResultsWACCNumber.setText(mDataset.get(i).get("WACCDetailedResultsWACCNumber"));
        viewHolder.WACCDetailedResultsDiscountFactorNumber.setText(mDataset.get(i).get("WACCDetailedResultsDiscountFactorNumber"));
        viewHolder.WACCDetailedResultsPVNumber.setText(mDataset.get(i).get("WACCDetailedResultsPVNumber"));



    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
