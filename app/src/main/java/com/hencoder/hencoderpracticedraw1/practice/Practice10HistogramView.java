package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {
    private Paint mPaint = new Paint();
    private RectF mRectF = new RectF();

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        float startX = 200, startY = 500;
        int width = 80, offset = 20;
        int[] heightArray = {1, 10, 15, 170, 300, 350, 150};
        String[] textArray = {"Froyo", "GB", "ICS", "JB", "Kitkat", "L", "M"};
        float lengthX = (width + offset) * heightArray.length + offset;
        float lengthY = 400;

        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(2);
        canvas.drawLine(startX, startY, startX + lengthX, startY, mPaint);
        canvas.drawLine(startX, startY, startX, startY - lengthY, mPaint);

        mPaint.setTextSize(30);
        for (int i = 0; i < heightArray.length; i++) {
            float x1 = startX + (width + offset) * i + offset;
            float y1 = startY - heightArray[i];
            mRectF.set(x1, y1, x1 + width, startY);
            mPaint.setColor(Color.GREEN);
            canvas.drawRect(mRectF, mPaint);
            mPaint.setColor(Color.WHITE);
            //todo 如何获取文字的宽高
            canvas.drawText(textArray[i], x1, startY + 30, mPaint);
        }

        mPaint.setTextSize(40);
        mPaint.setColor(Color.WHITE);
        canvas.drawText("直方图", 500, startY + 100, mPaint);
    }
}
