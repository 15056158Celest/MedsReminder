package com.example.a15056158.medsreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class medCheck2 extends AppCompatActivity {
    Button btnSubmit;

    RadioGroup rg;
    RadioButton rb;

    int selectedButtonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_check2);

        Intent intent = getIntent();
        String names = intent.getStringExtra("check");

        TextView tvs = (TextView) findViewById(R.id.tvNames);
        tvs.setText(names);


        btnSubmit = (Button)findViewById(R.id.btnSubmit);


        // Getting (sizeOfWeeks = gradeList.size() + 1;) from SecondActivity



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rg =(RadioGroup)findViewById(R.id.radioGroup1);
                // Get the Id of the selected radio button in the RadioGroup
                selectedButtonId  = rg.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                rb = (RadioButton)findViewById(selectedButtonId);
                //Toast.makeText(AddDailyGrades.this, ""+selectedButtonId, Toast.LENGTH_SHORT).show();
                // Create intent & pass in String data
                Intent i = new Intent(medCheck2.this, medsChecked.class);
                i.putExtra("list", rb.getText().toString());
                // Set result to RESULT_OK to indicate normal response and pass in the intent containing the data
                setResult(RESULT_OK, i);
                // Call this when your activity is done and should be closed.
                startActivity(i);
            }
        });
    }
}
