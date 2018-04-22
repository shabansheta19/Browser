package com.example.shaban.browser;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by shaban on 3/13/2018.
 */

public class DownLoadCustomAdapter extends BaseAdapter {
    private ArrayList<DownLoadDataModel> items;
    private int counter;
    private static LayoutInflater inflater=null;
    private Activity activity;
    private Resources res;
    private int index;
    private DownLoadCustomAdapter downLoadCustomAdapter;
    private static ProgressBar progressBar;

    private static class ViewHolder {
        private TextView fileName;
        private TextView progressBarValue;
        private ProgressBar progressBar;
        private ImageButton pauseResumeBtn;
    }
    private DownLoadCustomAdapter.ViewHolder viewHolder = new DownLoadCustomAdapter.ViewHolder();

    public DownLoadCustomAdapter(ArrayList i,Activity activity,LayoutInflater inflater,Resources res) {
        items=i;
        counter = i.size();
        this.inflater = inflater;
        this.activity = activity;
        this.res = res;
        downLoadCustomAdapter = this;
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
        return position;
    }

    public void addItem(DownLoadDataModel item) {
        items.add(item);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view = convertView;
        index = position;
        if(convertView==null){

            /****** Inflate download_row_layout.xml file for each row ( Defined below ) *******/
            view = inflater.inflate(R.layout.download_row_layout, null);

            /****** View Holder Object to contain download_row_layout.xml file elements ******/

            viewHolder.fileName = (TextView) view.findViewById(R.id.downloadFileName);
            viewHolder.progressBarValue=(TextView)view.findViewById(R.id.downloadPercentage);
            viewHolder.progressBar=(ProgressBar) view.findViewById(R.id.downloadProgressBar);
            viewHolder.pauseResumeBtn = (ImageButton)view.findViewById(R.id.downloadPauseResumeBtn);
            progressBar = viewHolder.progressBar;

            /************  Set holder with LayoutInflater ************/
            view.setTag( viewHolder );
        }
        else
            viewHolder=(DownLoadCustomAdapter.ViewHolder)view.getTag();

        /************  Set Model values in Holder elements ***********/

        viewHolder.fileName.setText(items.get( position ).getDownloadFileName());
        viewHolder.progressBarValue.setText(items.get( position ).getProgressBarValue() + "%");
        viewHolder.progressBar.setProgress(items.get( position ).getProgressBarValue());

        return view;
    }
}
