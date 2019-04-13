package ua.home_studying.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ColoredPoint extends View {

    int color;
    float radius;
    Paint paint;

    public ColoredPoint(Context context) {
        super(context);
    }

    public ColoredPoint(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);

    }

    public ColoredPoint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);

    }

    public ColoredPoint(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArrayWrapper.readTypedArray(context, attrs, R.styleable.ColoredPoint, this::readArray);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);
    }

    private void readArray(TypedArray typedArray) {
        color = typedArray.getColor(R.styleable.ColoredPoint_cp_color, Color.RED);
        radius = typedArray.getDimension(R.styleable.ColoredPoint_cp_radius, 25f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, radius, paint);
    }
}
