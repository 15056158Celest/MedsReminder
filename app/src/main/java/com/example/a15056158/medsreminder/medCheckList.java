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

import java.util.ArrayList;

public class medCheckList extends AppCompatActivity {

    Button btnAdds;
    ListView lvs;
    ArrayList<String> als;
    ArrayAdapter aas;
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_check_list);

        btnAdds = (Button) findViewById(R.id.buttonAdds);
        lvs = (ListView) findViewById(R.id.lvMeds);
        etName = (EditText) findViewById(R.id.etName);



        als = new ArrayList<String>();
        als.add("Panadol");




        aas = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, als);
        lvs.setAdapter(aas);


        lvs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String selected = als.get(position);

                Intent newActivity = new Intent(medCheckList.this, medCheck2.class);
                newActivity.putExtra("check", selected);
                startActivity(newActivity);

            }
        });


        btnAdds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Meds = etName.getText().toString();
                als.add(Meds);
                aas.notifyDataSetChanged();

            }
        });
    }
}
