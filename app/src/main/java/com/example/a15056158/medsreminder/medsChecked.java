package com.example.a15056158.medsreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class medsChecked extends AppCompatActivity {

    ArrayList<String> alList;
    ArrayAdapter aaList;
    ListView lvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meds_checked);

        Intent intent = this.getIntent();
        String selectedRadioValue = intent.getStringExtra("list");


        ListView lstitems = (ListView) this.findViewById(R.id.lvMeds);


        aaList = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, alList);
        lvList.setAdapter(aaList);


    }
}
