package com.example.finance.googlesheetsexample.androidlabs.gsheets1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.finance.googlesheetsexample.R;
import com.example.finance.googlesheetsexample.androidlabs.gsheets1.MyDataModel;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<MyDataModel> {

    List<MyDataModel> modelList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public MyArrayAdapter(Context context, List<MyDataModel> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        modelList = objects;
    }

    @Override
    public MyDataModel getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {

            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        MyDataModel item = getItem(position);

        if (item.getYear() == 0) {
            vh.textViewYear.setText("Terminal Value: " + Integer.toString(item.getYear()));
            vh.textViewCashFlowToEquity.setText(" Terminal CashFlow To Equity: " + Integer.toString(item.getTerminalCashFlowToEquity()));
            vh.textViewDifference.setText("TerminalDifference Between Numbers Before & After: " + Integer.toString(item.getTerminaldifference()));
            vh.textViewCashFlowToFirm.setText("Terminal CashFlow To Firm: " + Integer.toString(item.getTerminalcftofirm()));

        } else {

            vh.textViewYear.setText("Year: " + Integer.toString(item.getYear()));
            vh.textViewCashFlowToEquity.setText("CashFlow To Equity: " + Integer.toString(item.getCashFlowToEquity()));
            vh.textViewDifference.setText("Difference Between Numbers Before & After: " + Integer.toString(item.getDifference()));
            vh.textViewCashFlowToFirm.setText("CashFlow To Firm: " + Integer.toString(item.getCashFlowToFirm()));
        }

        return vh.rootView;
    }

    /**
     * ViewHolder class for layout.<br />
     * <br />
     * Auto-created on 2016-01-05 00:50:26 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private static class ViewHolder {
        public final RelativeLayout rootView;

        public final TextView textViewYear;
        public final TextView textViewCashFlowToEquity;
        public final TextView textViewDifference;
        public final TextView textViewCashFlowToFirm;

        private ViewHolder(RelativeLayout rootView, TextView textViewYear, TextView textViewCashFlowToEquity, TextView textViewDifference, TextView textViewCashFlowToFirm) {


            this.rootView = rootView;
            this.textViewYear = textViewYear;
            this.textViewCashFlowToEquity = textViewCashFlowToEquity;
            this.textViewDifference = textViewDifference;
            this.textViewCashFlowToFirm = textViewCashFlowToFirm;

        }

        public static ViewHolder create(RelativeLayout rootView) {

            //textViewYear and other variables can be reflective of terminal values

            TextView textViewYear = (TextView) rootView.findViewById(R.id.textViewYear);
            TextView textViewCashFlowToEquity = (TextView) rootView.findViewById(R.id.textViewCashFlowToEquity);
            TextView textViewDifference = (TextView) rootView.findViewById(R.id.textViewDifference);
            TextView textViewCashFlowToFirm = (TextView) rootView.findViewById(R.id.textView2CashFlowToFirm);
            return new ViewHolder(rootView, textViewYear, textViewCashFlowToEquity, textViewDifference, textViewCashFlowToFirm);
        }


    }
}