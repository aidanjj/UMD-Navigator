package com.example.testline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class LineView extends View {
    private Paint paint;
    private float startX;
    private float startY;
    private float endX;
    private float endY;
    private float pixelDensity;
    public LineView(Context context){
        super(context);
        this.pixelDensity = getResources().getDisplayMetrics().density;
        init();
    }
    public LineView(Context context, float startX, float startY, float endX, float endY){
        super(context);
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.pixelDensity = getResources().getDisplayMetrics().density;
        init();
    }
    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED); // Set color to red
        paint.setStrokeWidth(10); // Set stroke width
        // Set other paint attributes as needed
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        float startXPX = startX * pixelDensity;
        float startYPX = startY * pixelDensity;
        float endXPX = endX * pixelDensity;
        float endYPX = endY * pixelDensity;
        canvas.drawLine(startXPX,startYPX,endXPX,endYPX,paint);
    }
}
