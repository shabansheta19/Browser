package com.example.shaban.browser;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ArrayList<HistoryDataModel> historyDataModels;
    ListView listView;
    private static HistoryCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listView = (ListView) findViewById(R.id.history_list_view);
        historyDataModels = new ArrayList<>();
        adapter = new HistoryCustomAdapter(historyDataModels, (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE));

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HistoryDataModel historyDataModel = historyDataModels.get(position);
                WebViewActivity.msg = historyDataModel.getUri();
                Intent intent = new Intent(getApplicationContext(),WebViewActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
