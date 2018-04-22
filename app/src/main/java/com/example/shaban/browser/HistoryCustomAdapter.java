package com.example.shaban.browser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shaban on 3/6/2018.
 */

public class HistoryCustomAdapter extends BaseAdapter {
    private ArrayList<HistoryDataModel> items;
    private int counter;
    private static LayoutInflater inflater=null;

    public HistoryCustomAdapter(ArrayList i, LayoutInflater inflater) {
        items=i;
        counter = i.size();
        this.inflater = inflater;
    }

    private static class ViewHolder {
        private TextView title;
        private TextView uri;
    }

    @Override
    public int getCount() {
        return counter;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void addItem(Object item) {
        items.add((HistoryDataModel) item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;
        if(convertView==null){

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            view = inflater.inflate(R.layout.history_row_layout, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) view.findViewById(R.id.row_title);
            viewHolder.uri=(TextView)view.findViewById(R.id.row_uri);

            /************  Set holder with LayoutInflater ************/
            view.setTag( viewHolder );
        }
        else
            viewHolder=(ViewHolder)view.getTag();

        if(items.size()<=0)
        {
            viewHolder.title.setText("No Data");

        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            HistoryDataModel tempValues=null;
            tempValues = (HistoryDataModel) items.get( position );

            /************  Set Model values in Holder elements ***********/

            viewHolder.title.setText( tempValues.getTitle() );
            viewHolder.uri.setText( tempValues.getUri() );

        }
        return view;
    }
}
