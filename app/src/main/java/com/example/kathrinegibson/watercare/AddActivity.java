package com.example.kathrinegibson.watercare;

import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import static android.content.ContentValues.TAG;


public class AddActivity extends Activity implements OnItemSelectedListener {
    PlantType newPlantType = PlantType.Default;
    String plantName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button addButton = findViewById(R.id.add_plant_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Plant newPlant = new Plant(newPlantType);
                EditText userInput = findViewById(R.id.editText1);
                plantName = userInput.getText().toString();
                newPlant.changePlantName(plantName);
                Log.v(TAG, "plant type: " + newPlantType);
                Log.v(TAG, "plant name: " + plantName);
                finish();
            }
        });

        Spinner spinner = findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(this);

        // Creating adapter for spinner
        ArrayAdapter<PlantType> dataAdapter = new ArrayAdapter<PlantType>(this, android.R.layout.simple_spinner_item, PlantType.values());

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        newPlantType = PlantType.values()[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
