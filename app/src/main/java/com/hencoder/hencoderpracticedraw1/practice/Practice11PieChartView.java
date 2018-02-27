package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Arrays;

public class Practice11PieChartView extends View {
    private Paint mPaint = new Paint();

    private static String[] sTextArray = {"Froyo", "GB", "ICS", "JB", "Kitkat", "L", "M"};
    private static int[] sColorArray = {Color.BLACK, Color.MAGENTA,
            Color.GRAY, Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW};
    private static double[] sDegreeArray;
    private static double sDegreeDiv = 2;
    private static RectF sRectF = new RectF(250, 100, 750, 600);

    static {
        int[] heightArray = {1, 10, 15, 170, 300, 350, 150};
        final double sum = Arrays.stream(heightArray).sum();
        double remainDegree = 360 - sDegreeDiv * (heightArray.length - 1);
        sDegreeArray = Arrays.stream(heightArray)
                .mapToDouble(x -> x / sum)
                .map(x -> x * remainDegree)
                .toArray();
    }

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        mPaint.setAntiAlias(true);
        int offset = 20;
        double startAngle = 0;
        for (int i = 0; i < sTextArray.length; i++) {
            mPaint.setColor(sColorArray[i]);
            if (i == 5) canvas.translate(-offset, -offset);
            canvas.drawArc(sRectF, (float) startAngle, (float) sDegreeArray[i], true, mPaint);
            if (i == 5) canvas.translate(offset, offset);
            startAngle = startAngle + sDegreeArray[i] + sDegreeDiv;
        }
    }
}
