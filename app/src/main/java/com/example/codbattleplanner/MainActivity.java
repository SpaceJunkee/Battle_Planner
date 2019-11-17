package com.example.codbattleplanner;

/**
 * Code written by Kevin Sandy
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
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnElementListener {

    //ArrayLists that hold map names and image urls to be passed to recyclerViewAdapter
    private List<String> mapNames = new ArrayList<>();
    private List<String> mapImageUrls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        ImageButton savedMapsButton = findViewById(R.id.savedMapsButton);
        ImageButton aboutUsButton = findViewById(R.id.aboutUs);

        //Spinners
        final Spinner modeSelectSpinner = findViewById(R.id.modeSelect);
        final Spinner gameSelectSpinner = findViewById(R.id.gameSelect);

        //Create array of items to display for each of the spinners
        final String[] emptySpinner = {"Select a mode"};
        final String[] gameNames = {"Select a game","Call of Duty", "Counter Strike GO","Rainbow Six Siege"};

        //Call of duty spinner names
        final String[] modeNamesCOD = {"Select a mode", "Gunfight", "Domination", "Search & Destroy", "Headquarters", "Team DeathMatch", "Cyber Attack", "Ground War", "Free-For-All",
        "Team Deathmatch 10v10", "Domination 10v10"};

        //Counter Strike GO spinner names
        final String[] modeNamesCSGO = {"Select a mode", "Competitive",};

        //Rainbow Six Siege spinner names
        final String[] modeNamesRainbowSix = {"Select a mode", "Secure Area", "Hostage", "Bomb"};


        //Create an adapter to show how items are displayed for GAMES
        ArrayAdapter<String> adapterGame = new ArrayAdapter<>(this, R.layout.spinner_gameselect, gameNames);
        gameSelectSpinner.setAdapter(adapterGame);//spinner adapter set to game

        //Adapter to show how items are displayed for CALL OF DUTY modes
        final ArrayAdapter<String> adapterCOD = new ArrayAdapter<>(this, R.layout.spinner_modeelect, modeNamesCOD);

        //Adapter to show how items are displayed for CSGO modes
        final ArrayAdapter<String> adapterCSGO = new ArrayAdapter<>(this,R.layout.spinner_modeelect, modeNamesCSGO);

        //Adapter to show items displayed for RainbowSix siege modes
        final ArrayAdapter<String> adapterRainbowSix = new ArrayAdapter<>(this,R.layout.spinner_modeelect, modeNamesRainbowSix);

        //Empty adapter for emtpying the recyclerview when nothing is selected
        final ArrayAdapter<String> empty = new ArrayAdapter<>(this, R.layout.spinner_modeelect, emptySpinner);

        //Select a game
        gameSelectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerValueGame = gameSelectSpinner.getSelectedItem().toString();

                if(spinnerValueGame == gameNames[0]) {
                    mapNames.clear();
                    mapImageUrls.clear();
                    modeSelectSpinner.setAdapter(empty);
                    initializeRecyclerViewMain();

                }else if(spinnerValueGame == gameNames[1]) {
                    modeSelectSpinner.setAdapter(adapterCOD);//spinner adapter set to cod modes

                }else if(spinnerValueGame == gameNames[2]){
                    modeSelectSpinner.setAdapter(adapterCSGO);//Spinner adapter set to CSGO modes

                }else if(spinnerValueGame == gameNames[3]){
                    modeSelectSpinner.setAdapter(adapterRainbowSix);//Spinner adapter set to Rainbow six modes
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
                    clearImagesAndNamesLists();

                }else if(spinnerValueMode == modeNamesCOD[1]) {
                    clearImagesAndNamesLists();
                    initializeGunfightMapImages();

                }else if(spinnerValueMode == modeNamesCOD[2]){
                    clearImagesAndNamesLists();
                    initializeDominationMapImages();

                }else if(spinnerValueMode == modeNamesCOD[3]){
                    clearImagesAndNamesLists();
                    initializeSearchAndDestroyMapImages();
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

    }//onCreate Method

    //Method to clear both ArrayLists and repopulate new lists
    public void clearImagesAndNamesLists(){
        mapNames.clear();
        mapImageUrls.clear();
        initializeRecyclerViewMain();
    }

    //Create object of CallOfDutyMaps to initialize map images and names
    CallOfDutyMaps codMaps = new CallOfDutyMaps();

    //populates mapnames and imageurl lists with image urls and string names
    private void initializeGunfightMapImages(){

        for(int i = 0; i < codMaps.returnGunFightImagesAndNames().length; i++){
            mapImageUrls.add(codMaps.returnGunFightImagesAndNames()[i][0]);
            mapNames.add(codMaps.returnGunFightImagesAndNames()[i][1]);
        }

        //Call initializeRecyclerView Method to populate RecyclerView
        initializeRecyclerViewMain();
    }

    private void initializeDominationMapImages(){
        for(int i = 0; i < codMaps.returnDominationImagesAndNames().length; i++){
            mapImageUrls.add(codMaps.returnDominationImagesAndNames()[i][0]);
            mapNames.add(codMaps.returnDominationImagesAndNames()[i][1]);
        }

        initializeRecyclerViewMain();
    }

    private void initializeSearchAndDestroyMapImages(){
        for(int i = 0; i < codMaps.returnSearchAndDestroyImagesAndNames().length; i++){
            mapImageUrls.add(codMaps.returnSearchAndDestroyImagesAndNames()[i][0]);
            mapNames.add(codMaps.returnSearchAndDestroyImagesAndNames()[i][1]);
        }

        initializeRecyclerViewMain();
    }

    //Create object of CounterStrikeGOMaps to initialize map images and names
    CounterStrikeGOMaps cSGOMaps = new CounterStrikeGOMaps();

    private void initializeCompetitiveMapImages(){
        for(int i = 0; i < cSGOMaps.returnCompetitiveImagesAndNames().length; i++){
            mapImageUrls.add(cSGOMaps.returnCompetitiveImagesAndNames()[i][0]);
            mapNames.add(cSGOMaps.returnCompetitiveImagesAndNames()[i][1]);
        }

        initializeRecyclerViewMain();
    }

    private void initializeRecyclerViewMain(){
         RecyclerView recyclerView = findViewById(R.id.mapsReyclerList);
         RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mapNames, mapImageUrls, this);
         recyclerView.setAdapter(adapter);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onElementClick(int position) {
        Intent intent = new Intent(this,EditMapImage.class);
        intent.putExtra("image_url", mapImageUrls.get(position));
        intent.putExtra("name_url", mapNames.get(position));
        this.startActivity(intent);
    }
}

