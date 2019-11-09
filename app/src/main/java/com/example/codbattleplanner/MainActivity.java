package com.example.codbattleplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        initializeImageBitmaps();
    }

    //Gets images and names from the web and stores them in ArrayList
    private void initializeImageBitmaps(){
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

