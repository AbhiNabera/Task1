package com.example.abhinabera.task1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, roll;
    Button submit;
    CheckBox tronix, web, app, algo;
    Spinner dept;
    int item;
    String [] department = {"Department", "Chemical", "Civil", "Computer Science", "Electrical and Electronics", "Electroncis and Communication", "Instrumentation and Control", "Mechanical", "Metallurgy and Materials", "Production"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        roll = (EditText) findViewById(R.id.roll);
        submit = (Button) findViewById(R.id.submit);
        tronix = (CheckBox)findViewById(R.id.tronix);
        web = (CheckBox) findViewById(R.id.web);
        app = (CheckBox) findViewById(R.id.app);
        algo = (CheckBox) findViewById(R.id.algo);
        dept = (Spinner) findViewById(R.id.department);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, department);
        dept.setAdapter(adapter);
        dept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
                item = arg0.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nam = name.getText().toString();
                if(nam.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please enter your name.", Toast.LENGTH_SHORT).show();
                }

                String rol = roll.getText().toString();
                if(rol.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please enter your roll number.", Toast.LENGTH_SHORT).show();
                }

                if(item == 0)
                {
                    Toast.makeText(MainActivity.this, "Please enter your department.", Toast.LENGTH_SHORT).show();
                }
                if(!tronix.isChecked() && !web.isChecked() && !app.isChecked() && !algo.isChecked())
                {
                    Toast.makeText(MainActivity.this, "Please select any one of the profiles.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(MainActivity.this, Response.class);
                    i.putExtra("name", nam);
                    startActivity(i);
                }

            }
        });
    }

}
