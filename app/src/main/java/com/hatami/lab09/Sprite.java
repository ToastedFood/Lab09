package com.hatami.lab09;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Sprite extends RectF {
    private int dY, dX, color;
    public static int h, w;
    private int cycle = 0;

    public Sprite(float left, float top, float right, float bottom, int dX, int dY, int color) {
        super(left, top, right, bottom);
        this.dX = dX;
        this.dY = dY;
        this.color = color;
    }

    public Sprite(float left, float top, float right, float bottom) {
        this(left, top, right, bottom, 10, 10, Color.BLUE);

    }
    public Sprite(float left, float top){
        this(left, top, left + 100, top + 100, 30, 20, Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
    }

    public Sprite(int dY, int dX, int color) {
        this(1, 1, 100, 100, dY, dX, color);
    }

    public Sprite() {
        this( 30, 20, Color.DKGRAY);
    }

    public void update(){
        offset(dX, dY);
        if(this.right > w && dX > 0){
            //System.out.print("Yes");
            setdX(-dX);
        }
        if(this.left < 0 && dX < 0){
            //System.out.print("Yes");
            setdX(-dX);
        }
        if(this.top < 0 && dY < 0){
            setdY(-dY);
        }
        if(this.bottom > h && dY > 0){
            setdY(-dY);
        }
        /*
        if(cycle%50 == 0) {
            if (dX < 0) {
                dX -= 1;
            } else {
                dX += 1;
            }
            if (dY < 0) {
                dY -= 1;
            } else {
                dY += 1;
            }
        }

         */
        cycle += 1;
    }

    public void draw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawCircle(centerX(), centerY(), width()/2, paint);

    }

    public void reverse(){
        this.dY = -dY;
        this.dX = -dX;
    }

    public int getdY() {
        return dY;
    }

    public void setdY(int dY) {
        this.dY = dY;
    }

    public int getdX() {
        return dX;
    }

    public void setdX(int dX) {
        this.dX = dX;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public static void setH(int h) {
        Sprite.h = h;
    }

    public static void setW(int w) {
        Sprite.w = w;
    }
}
