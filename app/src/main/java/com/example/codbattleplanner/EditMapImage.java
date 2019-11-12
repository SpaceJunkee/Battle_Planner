package com.example.codbattleplanner;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

/**
 * Code written by Kevin Sandy
 * https://github.com/SpaceJunkee
 */
public class EditMapImage extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_edit_gallery);


        checkIntent();

    }

    //This will check to see if the intent extras exist and if they do get the extra
    private void checkIntent(){
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("name_url")){

            String imageUrl = getIntent().getStringExtra("image_url");
            String nameUrl = getIntent().getStringExtra("name_url");

            setMapImage(imageUrl, nameUrl);
        }
    }

    private void setMapImage(String imageUrl, String nameUrl){

        //Set the Text view
        TextView name  = findViewById(R.id.mapNameEditor);
        name.setText(nameUrl);

        //Set the Image
        ImageView imageView = findViewById(R.id.mapEditScreen);

        Glide.with(this).asBitmap().load(imageUrl).into(imageView);





    }
}
