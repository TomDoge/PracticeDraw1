package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {
    private Paint mPaint = new Paint();
    private Path mPath = new Path();
    private RectF mRectF = new RectF();

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        float rad = 100;
        float centerX = 500, centerY = 300, footerY = centerY + rad * 2.5f;
        int sweep = 210;
        mPath.moveTo(centerX, centerY);

        mRectF.set(centerX, centerY - rad, centerX + 2 * rad, centerY + rad);
        mPath.addArc(mRectF, 180, sweep);
        mPath.lineTo(centerX, footerY);

        mRectF.set(centerX - rad * 2, centerY - rad, centerX, centerY + rad);
        mPath.addArc(mRectF, 0, -sweep);
        mPath.lineTo(centerX, footerY);

        canvas.drawPath(mPath, mPaint);
    }
}
