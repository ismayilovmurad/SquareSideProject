package com.martiandeveloper.squareside;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.view.View;

import androidx.annotation.Nullable;

public final class MyView extends View {

    private Paint paint;
    private float sideLength;

    public MyView(@Nullable Context context) {
        super(context);
    }

    public MyView(@Nullable Context context, float sideLength) {
        super(context);

        this.sideLength = sideLength;

        paint = new Paint();
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(8);
        paint.setColor(Color.BLUE);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        @SuppressLint("DrawAllocation") Rect rect = new Rect(0, 0, (int) this.sideLength, (int) this.sideLength);
        rect.offset((int) ((float) (this.getWidth() / 2) - this.sideLength / (float) 2), (int) ((float) (this.getHeight() / 2) - this.sideLength / (float) 2));
        canvas.drawRect(rect, paint);
    }

}
