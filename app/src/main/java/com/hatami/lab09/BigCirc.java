package com.hatami.lab09;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class BigCirc extends RectF {

    private int color;
    private int r;

    public BigCirc(float centerX, float centerY, int r) {
        super(centerX - r, centerY - r, centerX + r, centerY + r);
        this.color = Color.rgb(0, 0, 0);
        this.r = r;
    }

    public void draw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawCircle(centerX(), centerY(), width()/2, paint);

    }

    public int getR() {
        return r;
    }
}
