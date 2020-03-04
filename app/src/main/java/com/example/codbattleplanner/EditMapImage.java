package com.example.codbattleplanner;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


/**
 * Code written by Kevin Sandy
 * https://github.com/SpaceJunkee
 */
public class EditMapImage extends AppCompatActivity implements View.OnClickListener {

    //Create new object of PaintImageView
    private PaintImageView paintImageView;

    //Instance Variables
    //Find ImageButtons, Buttons, Textview and declare and initialise dot size increment values
    private ImageButton saveMapButton, resetButton;
    private Button redColourButton, purpleColourButton, greenColourButton, dotSizePlus, dotSizeMinus;
    private TextView displayDotSize;
    private static final int DOT_SIZE_INCREMENT = 10;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_edit_gallery);
        initializeVariables();

        checkIntent();

    }

    private void initializeVariables() {
        //Find buttons and associate with variables
        resetButton = findViewById(R.id.resetButton);
        redColourButton = findViewById(R.id.redButton);
        purpleColourButton = findViewById(R.id.purpleButton);
        greenColourButton = findViewById(R.id.greenButton);
        dotSizePlus = findViewById(R.id.dotPlusButton);
        dotSizeMinus = findViewById(R.id.dotMinusButton);

        //Set on click listeners
        resetButton.setOnClickListener(this);
        redColourButton.setOnClickListener(this);
        purpleColourButton.setOnClickListener(this);
        greenColourButton.setOnClickListener(this);
        dotSizePlus.setOnClickListener(this);
        dotSizeMinus.setOnClickListener(this);

        paintImageView = findViewById(R.id.mapEditScreen);

        //Update textview dotSize with the current size of dot by increments
        displayDotSize = findViewById(R.id.dotSize);
        displayDotSize.setText(paintImageView.getDotSize());
    }

    //This will check to see if the intent extras exist and if they do get the extra
    private void checkIntent(){
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("name_url")){

            String imageUrl = getIntent().getStringExtra("image_url");
            String nameUrl = getIntent().getStringExtra("name_url");

            setMapImage(imageUrl, nameUrl);

        }
    }

    Matrix matrix = new Matrix();

    private void setMapImage(final String imageUrl, String nameUrl){

        //Set the Text view
        TextView name  = findViewById(R.id.mapNameEditor);
        name.setText(nameUrl);


        //Set the Image
        final PaintImageView imageView = findViewById(R.id.mapEditScreen);
        Picasso.get().load(imageUrl).fit().centerInside().into(imageView,new Callback.EmptyCallback() {
            //Will center image in middle of imageview with scale type matrix.
            @Override
            public void onSuccess() {
                Drawable d = imageView.getDrawable();

                RectF imageRectF = new RectF(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
                RectF viewRectF = new RectF(0, 0, imageView.getWidth(), imageView.getHeight());
                matrix.setRectToRect(imageRectF, viewRectF, Matrix.ScaleToFit.CENTER);
                imageView.setImageMatrix(matrix);
            }
        });

    }

    //Gets called everytime a button is pressed
    @Override
    public void onClick(View view) {
        //Find which button was pressed

        switch(view.getId()){
            case R.id.redButton: paintImageView.setPenColour(Color.parseColor("#F82323"));
                paintImageView.getPenColour();
                Toast.makeText(this, "RED",Toast.LENGTH_SHORT).show();
                break;
            case R.id.purpleButton: paintImageView.setPenColour(Color.parseColor("#7C4DFF"));
                paintImageView.getPenColour();
                Toast.makeText(this, "PURPLE",Toast.LENGTH_SHORT).show();
                break;
            case R.id.greenButton: paintImageView.setPenColour(Color.parseColor("#00C853"));
                paintImageView.getPenColour();
                Toast.makeText(this, "GREEN",Toast.LENGTH_SHORT).show();
                break;
            case R.id.dotPlusButton: paintImageView.changeDotSize(+DOT_SIZE_INCREMENT);
                displayDotSize.setText(paintImageView.getDotSize());
                break;
            case R.id.dotMinusButton: paintImageView.changeDotSize(-DOT_SIZE_INCREMENT);
                displayDotSize.setText(paintImageView.getDotSize());
                break;
            case R.id.resetButton: paintImageView.resetPaint();
                displayDotSize.setText(paintImageView.getDotSize());
                Toast.makeText(this, "RESET",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
