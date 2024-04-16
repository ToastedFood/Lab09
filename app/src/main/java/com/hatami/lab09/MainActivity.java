package com.hatami.lab09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    DrawView draw;
    private float[] lastXY = new float[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        draw = findViewById(R.id.draw);
        draw.setOnTouchListener(touchListener);
        draw.setOnClickListener(clickListener);

    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN) {
                lastXY[0] = motionEvent.getX();
                lastXY[1] = motionEvent.getY();
            }
            return false;
        }
    };

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            float x = lastXY[0];
            float y = lastXY[1];
            draw.addSprite(x, y);
        }
    };

}