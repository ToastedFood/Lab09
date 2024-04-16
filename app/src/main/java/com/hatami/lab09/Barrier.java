package com.hatami.lab09;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Barrier extends RectF {
    int dy;
    public Barrier(int cx, int cy, int cw, int ch){
        super(cx, cy, cx + cw, cy + ch);

        dy = 10;
    }

    public void draw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(Color.rgb(0, 0, 0));
        canvas.drawRect(this, paint);
    }
    public void update(){
        offset(0, dy);
        if(this.bottom > 1800 && dy > 0){
            dy = -10;
        }
        if(this.top < 200 && dy < 0){
            dy = 10;
        }
    }

}
