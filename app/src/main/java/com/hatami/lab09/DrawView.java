package com.hatami.lab09;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DrawView extends View {
    Sprite sprite;
    Sprite sprite2;

    ArrayList<Sprite> spriteList = new ArrayList<>();

    BigCirc bigCirc;
    Barrier barrier;
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
        spriteList.add(sprite);
        spriteList.add(sprite2);
        bigCirc = new BigCirc(getWidth()/2 , getHeight()/2, 300 );
        barrier = new Barrier(getWidth()/2 - 300, 200, 600, 20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bigCirc.draw(canvas);
        barrier.draw(canvas);
        barrier.update();

        if(RectF.intersects(sprite, sprite2)){
            sprite.reverse();
            sprite2.reverse();
        }
        ArrayList<Integer> intRemove = new ArrayList<>();
        for(int spriteI = 0; spriteI < spriteList.size(); spriteI ++) {
            spriteList.get(spriteI).update();
            spriteList.get(spriteI).draw(canvas);
            if (bigCirc.contains(spriteList.get(spriteI)) && cycle % 1 == 0) {
                float xDist = bigCirc.centerX() - spriteList.get(spriteI).centerX();
                float yDist = bigCirc.centerY() - spriteList.get(spriteI).centerY();
                float dist = (float) Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2)) / 5;
                float angle = (float) Math.atan(yDist / xDist);
                //System.out.println(angle);
                spriteList.get(spriteI).setdX((int) (spriteList.get(spriteI).getdX() + xDist / 10));
                spriteList.get(spriteI).setdY((int) (spriteList.get(spriteI).getdY() + yDist / 10));
                //System.out.println(sprite.getdY());
                if(spriteList.get(spriteI).getdX() == 0 && spriteList.get(spriteI).getdY() == 0){
                    //System.out.println("TERMINAL REACHED");
                    intRemove.add(spriteI);
                }
            }
            if(RectF.intersects(spriteList.get(spriteI), barrier)){
                System.out.println("Bounce");
                spriteList.get(spriteI).reverse();
            }
        }
        for(Integer i : intRemove) {
            spriteList.remove((int)i);
        }
        cycle++;
        invalidate();

    }
    public void addSprite(float x, float y){
        spriteList.add(new Sprite(x, y));
    }
}
