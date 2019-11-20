package com.example.codbattleplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

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


        //Find savebutton
        ImageButton saveMapButton = findViewById(R.id.saveEditImagebutton);

        saveMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
            }
        });

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
        PaintImageView imageView = findViewById(R.id.mapEditScreen);
        Picasso.get().load(imageUrl).into(imageView);


    }
}
