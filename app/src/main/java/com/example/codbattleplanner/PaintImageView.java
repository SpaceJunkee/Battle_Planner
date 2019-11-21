package com.example.codbattleplanner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * Code written by Kevin Sandy
 * https://github.com/SpaceJunkee
 */
public class PaintImageView extends AppCompatImageView implements View.OnTouchListener {
    //set a default max and min dot size so user can change size of drawing line
    private final int DEFAULT_DOT_SIZE = 10;
    private final int MAX_DOT_SIZE = 100;
    private final int MIN_DOT_SIZE = 5;
    private int dotSize;

    private int defaultDotSize = 10;
    private int penColour;
    private final int DEFAULT_COLOUR = Color.RED;

    private Path path;
    private Paint paint;

    private float pointX, pointY;

    public PaintImageView(Context context) {
        super(context);
        this.initVariables();
    }

    public PaintImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.initVariables();
    }

    public PaintImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initVariables();
    }

    public void setPenColour(int penColour) {
        this.penColour = penColour;
    }

    public int getPenColour() {
        return penColour;
    }

    private void initVariables() {
        dotSize = defaultDotSize;
        penColour = DEFAULT_COLOUR;
        path = new Path();
        paint = new Paint();
        paint.setColor(penColour);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        this.setOnTouchListener(this);
        pointX = pointY = (float) 0.0;
    }

    public String getDotSize(){
        return String.valueOf(dotSize);
    }

    public void changeDotSize(int increment){
        this.dotSize += increment;
        this.dotSize = Math.max(dotSize,MIN_DOT_SIZE);
        this.dotSize = Math.min(dotSize,MAX_DOT_SIZE);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        pointX = motionEvent.getX();
        pointY = motionEvent.getY();

        switch(motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                this.path.moveTo(pointX,pointY);
                break;
                case MotionEvent.ACTION_MOVE:
                    this.path.lineTo(pointX,pointY);
                    break;
                    case MotionEvent.ACTION_UP:
                        break;
        }

        this.invalidate();

        return true;
    }
}
