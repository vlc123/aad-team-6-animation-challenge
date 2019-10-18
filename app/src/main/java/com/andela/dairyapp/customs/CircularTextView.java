package com.andela.dairyapp.customs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;

public class CircularTextView extends AppCompatTextView {
    private float strokeW;
    int strokeC, solidC;

    public CircularTextView(Context context) {
        super(context);
    }

    public CircularTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircularTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        @SuppressLint("DrawAllocation") Paint cPaint = new Paint();
        cPaint.setColor(solidC);
        cPaint.setFlags(Paint.ANTI_ALIAS_FLAG);

        @SuppressLint("DrawAllocation") Paint strokePaint = new Paint();
        strokePaint.setColor(strokeC);
        strokePaint.setFlags(Paint.ANTI_ALIAS_FLAG);

        int h = this.getHeight();
        int w = this.getWidth();

        int diameter = ((h > w ) ? h : w);
        int radius = diameter / 2;

        this.setHeight(diameter);
        this.setWidth(diameter);

        canvas.drawCircle(diameter / 2, diameter / 2, radius, strokePaint);
        canvas.drawCircle(diameter / 2, diameter / 2, radius - strokeW, cPaint);

        super.onDraw(canvas);
    }

    public void setStrokeWith(int dp){
        float scale = getContext().getResources().getDisplayMetrics().density;
        strokeW = dp*scale;
    }

    public void setStrokeColor(String color){
        strokeC = Color.parseColor(color);
    }
    public void setSolidColor(int color){
        solidC = color;
    }
}
