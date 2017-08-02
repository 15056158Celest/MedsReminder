package com.example.a15056158.medsreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class list extends AppCompatActivity {
    Button btnAdd, btnReset;
    ListView lv;
    ArrayList<String> al;
    ArrayAdapter aa;
    EditText etDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnReset = (Button) findViewById(R.id.buttonReset);
        lv = (ListView) findViewById(R.id.lvMeds);
        etDate = (EditText) findViewById(R.id.editTextDate);



        al = new ArrayList<String>();
        al.add("25 May 2017");




        aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String selectedYear = al.get(position);

                Intent newActivity = new Intent(list.this, medsReminder.class);
                newActivity.putExtra("date", selectedYear);
                startActivity(newActivity);

                String selectedName = al.get(position);
                String selectedDate = al.get(position);

                Toast.makeText(list.this, selectedName
                                + " date: " + selectedDate,
                        Toast.LENGTH_LONG).show();



            }
        });




        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Medicine = etDate.getText().toString();
                al.add(Medicine);
                aa.notifyDataSetChanged();

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Medicine = etDate.getText().toString();
                al.remove(Medicine);
                aa.notifyDataSetChanged();
            }
        });
    }
}
