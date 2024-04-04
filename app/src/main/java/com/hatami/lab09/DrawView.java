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

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        sprite.update();
        sprite.draw(canvas);
        sprite2.update();
        sprite2.draw(canvas);
        if(RectF.intersects(sprite, sprite2)){
            sprite.reverse();
            sprite2.reverse();
        }
        invalidate();

    }
}
