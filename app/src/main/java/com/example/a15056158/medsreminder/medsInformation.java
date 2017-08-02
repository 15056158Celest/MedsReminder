package com.example.a15056158.medsreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class medsInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meds_information);

        Intent intent = getIntent();
        String[] info = intent.getStringArrayExtra("info");
        String name = intent.getStringExtra("Name");
        String dosage = intent.getStringExtra("Dosage");
        String time = intent.getStringExtra("Time");
        String remarks = intent.getStringExtra("Remarks");
        String selectedRadioValue = intent.getStringExtra("radioGroup1Selected");



        TextView tv1 = (TextView) findViewById(R.id.textView1);
        tv1.setText("Medication Name: " + name);

        TextView tv2 = (TextView) findViewById(R.id.textView2);
        tv2.setText("Medication Dosage: " + dosage);


        TextView tv3 = (TextView) findViewById(R.id.textView3);
        tv3.setText("Medication Time: " + time);



        TextView tv4 = (TextView) findViewById(R.id.textView4);
        tv4.setText("Medication To Be Taken: " + selectedRadioValue);

        TextView tv5 = (TextView) findViewById(R.id.textView5);
        tv5.setText("Remarks: " + remarks);

    }
}
