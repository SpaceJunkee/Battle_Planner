package com.example.codbattleplanner;

/**
 * Created by Kevin Sandy
 * https://github.com/SpaceJunkee
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Variables
    private ArrayList<String> mapNames = new ArrayList<>();
    private ArrayList<String> mapImageUrls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        Button savedMapsButton = findViewById(R.id.savedMaps);
        Button aboutUsButton = findViewById(R.id.aboutUs);
        final Spinner modeSelectSpinner = findViewById(R.id.modeSelect);

        //Create array of items for the spinner
        final String[] modes = {"Select game mode", "Gunfight", "Domination", "Search & Destroy", "Headquarters", "Team DeathMatch", "Cyber Attack", "Ground War", "Free-For-All",
        "Team Deathmatch 10v10", "Domination 10v10"};

        //Create an adapter to show how items are displayed
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_modeelect, modes);

        //set the spinners adapter to the previously created one.
        modeSelectSpinner.setAdapter(adapter);

        //Change the list items based on which mode is selected in spinner drop down menu
        //Checks to see which element of the array you are on and populates the list with the items in mapsImages and mapNames arrayLists
        modeSelectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerValue = modeSelectSpinner.getSelectedItem().toString();

                if(spinnerValue == modes[0]){
                    mapNames.clear();
                    mapImageUrls.clear();
                    initializeRecyclerView();
                }
                else if(spinnerValue == modes[1]) {
                    mapNames.clear();
                    mapImageUrls.clear();
                    initializeGunfightMapImages();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                mapNames.clear();
                mapImageUrls.clear();
            }
        });

        //Setting savedMapsButton to access new list activity
        savedMapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent savedMapsScreen = new Intent(getApplicationContext(), SavedMapsActivity.class);

                startActivity(savedMapsScreen);
            }
        });

        //Setting about button to access an about page
        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutUsScreen = new Intent(getApplicationContext(), AboutUs.class);

                startActivity(aboutUsScreen);
            }
        });

    }

    //Gets images and names from the web and stores them in ArrayList
    private void initializeGunfightMapImages(){
        mapImageUrls.add("https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg");
        mapNames.add("Gulag Showers");
        mapImageUrls.add("https://gamewith-en.akamaized.net/img/c321afd782bb344ab3fd05704bfc7dd2.jpg");
        mapNames.add("Docks");
        mapImageUrls.add("https://gamewith-en.akamaized.net/img/2c644d3ad10e90930e535079dab4bcbd.jpg");
        mapNames.add("Pine");
        mapImageUrls.add("https://gamewith-en.akamaized.net/img/7eb53a33bd8da80deede893ee6e0e11b.jpg");
        mapNames.add("SpeedBall");
        mapImageUrls.add("https://gamewith-en.akamaized.net/img/3732cd208b62870854dffa99da83233a.jpg");
        mapNames.add("Stack");
        mapImageUrls.add("https://gamewith-en.akamaized.net/img/7886793e001a8b5a2e1322cb2740b726.jpg");
        mapNames.add("Hill");
        mapImageUrls.add("https://gamewith-en.akamaized.net/img/c321afd782bb344ab3fd05704bfc7dd2.jpg");
        mapNames.add("King");

        //Call initializeRecyclerView Method
        initializeRecyclerView();
    }



    private void initializeRecyclerView(){
         RecyclerView recyclerView = findViewById(R.id.mapsReyclerList);
         RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mapNames, mapImageUrls);
         recyclerView.setAdapter(adapter);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}

