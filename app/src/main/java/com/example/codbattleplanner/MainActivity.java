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
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Variables
    private List<String> mapNames = new ArrayList<>();
    private List<String> mapImageUrls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        Button savedMapsButton = findViewById(R.id.savedMaps);
        Button aboutUsButton = findViewById(R.id.aboutUs);
        final Spinner modeSelectSpinner = findViewById(R.id.modeSelect);
        final Spinner gameSelectSpinner = findViewById(R.id.gameSelect);

        //Create array of items for the spinner
        final String[] emptySpinner = {"Select a mode"};
        final String[] gameNames = {"Select a game","Call of Duty", "Counter Strike"};
        final String[] modeNamesCOD = {"Select a mode", "Gunfight", "Domination", "Search & Destroy", "Headquarters", "Team DeathMatch", "Cyber Attack", "Ground War", "Free-For-All",
        "Team Deathmatch 10v10", "Domination 10v10"};

        //Create an adapter to show how items are displayed for GAMES
        ArrayAdapter<String> adapterGame = new ArrayAdapter<>(this, R.layout.spinner_gameselect, gameNames);
        gameSelectSpinner.setAdapter(adapterGame);//spinner adapter set to game

        //Create an adapter to show how items are displayed for CALL OF DUTY MODES
        final ArrayAdapter<String> adapterCOD = new ArrayAdapter<>(this, R.layout.spinner_modeelect, modeNamesCOD);

        final ArrayAdapter<String> empty = new ArrayAdapter<>(this, R.layout.spinner_modeelect, emptySpinner);


        gameSelectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerValueGame = gameSelectSpinner.getSelectedItem().toString();

                if(spinnerValueGame == gameNames[0]){
                    mapNames.clear();
                    mapImageUrls.clear();
                    modeSelectSpinner.setAdapter(empty);
                    initializeRecyclerView();
                }
                else if(spinnerValueGame == gameNames[1]) {
                    modeSelectSpinner.setAdapter(adapterCOD);//spinner adapter set to cod modes
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        //Change the list items based on which mode is selected in spinner drop down menu
        //Checks to see which element of the array you are on and populates the list with the items in mapsImages and mapNames arrayLists
        modeSelectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerValueMode = modeSelectSpinner.getSelectedItem().toString();

                if(spinnerValueMode == modeNamesCOD[0]){
                    mapNames.clear();
                    mapImageUrls.clear();
                    initializeRecyclerView();
                }
                else if(spinnerValueMode == modeNamesCOD[1]) {
                    mapNames.clear();
                    mapImageUrls.clear();
                    initializeGunfightMapImages();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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

    CallOfDutyMaps codMaps = new CallOfDutyMaps();

    //Gets images and names from the web and stores them in ArrayList
    private void initializeGunfightMapImages(){

        for(String name : codMaps.returnGunfightNames()){
            mapNames.add(name);
        }

        for(String image : codMaps.returnGunFightImages()){
            mapImageUrls.add(image);
        }

        //Call initializeRecyclerView Method to populate RecyclerView
        initializeRecyclerView();
    }



    private void initializeRecyclerView(){
         RecyclerView recyclerView = findViewById(R.id.mapsReyclerList);
         RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mapNames, mapImageUrls);
         recyclerView.setAdapter(adapter);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}

