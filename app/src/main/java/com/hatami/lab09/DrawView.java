package com.hatami.lab09;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    Sprite sprite;
    Sprite sprite2;

    BigCirc bigCirc;
    int cycle = 0;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Sprite.setH(getHeight());
        Sprite.setW(getWidth());
        sprite = new Sprite((float) (Math.random() * (getWidth()-100)), (float) (Math.random() * (getHeight()-100)));
        sprite2 = new Sprite((float) (Math.random() * (getWidth()-100)) , (float) (Math.random() * (getHeight()-100)));
        bigCirc = new BigCirc(getWidth()/2 , getHeight()/2, 300 );

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        sprite.update();
        bigCirc.draw(canvas);
        sprite.draw(canvas);
        sprite2.update();
        sprite2.draw(canvas);

        if(RectF.intersects(sprite, sprite2)){
            sprite.reverse();
            sprite2.reverse();
        }
        if(bigCirc.contains(sprite) && cycle%1 == 0){
            float xDist = bigCirc.centerX() - sprite.centerX();
            float yDist = bigCirc.centerY() - sprite.centerY();
            float dist = (float)Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2))/5;
            float angle = (float)Math.atan(yDist/xDist);
            //System.out.println(angle);
            sprite.setdX((int) (sprite.getdX() + xDist/10));
            sprite.setdY((int) (sprite.getdY() + yDist/10));
            System.out.println(sprite.getdY());
        }
        if(bigCirc.contains(sprite2) && cycle%1 == 0){
            float xDist = bigCirc.centerX() - sprite2.centerX();
            float yDist = bigCirc.centerY() - sprite2.centerY();
            float dist = (float)Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2))/5;
            float angle = (float)Math.atan(yDist/xDist);
            //System.out.println(angle);
            sprite2.setdX((int) (sprite2.getdX() + xDist/20));
            sprite2.setdY((int) (sprite2.getdY() + yDist/20));
            System.out.println(sprite2.getdY());
        }
        cycle++;
        invalidate();

    }
}
