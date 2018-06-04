package com.example.kathrinegibson.watercare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import com.google.gson.Gson;

import static android.content.ContentValues.TAG;
import static com.example.kathrinegibson.watercare.MainActivity.editor_string;
import static com.example.kathrinegibson.watercare.MainActivity.userAddedPlants;


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
                Intent returnIntent = new Intent();
                setResult(RESULT_CANCELED, returnIntent);
                finish();
            }
        });

        Button addButton = findViewById(R.id.add_plant_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userInput = findViewById(R.id.editText1);
                plantName = userInput.getText().toString();
                if(!plantName.equals("") && (newPlantType != PlantType.Default)){
                    Plant newPlant = new Plant(newPlantType);
                    newPlant.changePlantName(plantName);
                    userAddedPlants.add(newPlant);
                    saveData();
                }
                setResult(RESULT_OK);
                finish();
            }
        });

        Spinner spinner = findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(this);

        // Creating adapter for spinner
        ArrayAdapter<PlantType> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, PlantType.values());

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(userAddedPlants);

        editor.putString(editor_string, json);
        editor.apply();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        newPlantType = PlantType.values()[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
