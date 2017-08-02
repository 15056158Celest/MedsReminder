package com.example.a15056158.medsreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class medsReminder extends AppCompatActivity {

    Button btnSubmit, btnClear;
    EditText etName, etDosage, etTime, etRemarks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meds_reminder);

        btnSubmit = (Button) findViewById(R.id.buttonSubmit);
        btnClear = (Button) findViewById(R.id.buttonClear);
        etTime = (EditText) findViewById(R.id.editTextTime);
        etName = (EditText) findViewById(R.id.editTextName);
        etDosage = (EditText) findViewById(R.id.editTextAmt);
        etRemarks = (EditText) findViewById(R.id.edit_textRemarks);


        Intent intent = getIntent();
        String date = intent.getStringExtra("date");

        TextView tv = (TextView) findViewById(R.id.tvMed);
        tv.setText(date);



        btnSubmit.setOnClickListener(new View.OnClickListener() {

            RadioGroup rg = (RadioGroup) findViewById(R.id.rgb1);

            @Override
            public void onClick(View v) {

                String selectedRadioValue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();

                Intent intent = new Intent(getApplicationContext(), medsInformation.class);
                intent.putExtra("Name", etName.getText().toString());
                intent.putExtra("Dosage", etDosage.getText().toString());
                intent.putExtra("Time", etTime.getText().toString());
                intent.putExtra("Remarks", etRemarks.getText().toString());
                intent.putExtra("radioGroup1Selected", selectedRadioValue);

                startActivity(intent);
            }

        });


        btnClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                etName.setText("");
                etDosage.setText("");
                etTime.setText("");
                etRemarks.setText("");








            }

        });


    }
}
