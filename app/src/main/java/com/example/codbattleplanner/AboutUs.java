package com.example.codbattleplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class AboutUs extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        final EditText aboutUsParagraph = findViewById(R.id.aboutusParagraphText);
            aboutUsParagraph.setText("We are a big bunch of gimps. \nThis app is a load of shite.\nGive us money");


    }
}
