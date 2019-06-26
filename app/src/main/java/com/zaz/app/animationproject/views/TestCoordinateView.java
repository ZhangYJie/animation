package com.zaz.app.animationproject.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class TestCoordinateView extends View {
    Paint paint;
    public TestCoordinateView(Context context) {
        super(context);
    }

    public TestCoordinateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setTextSize(20);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);
        //初始化画笔，参数表示去锯齿
    }
    public TestCoordinateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();//这个先保存下之前的现场
        //这个代表没有平移时的坐标轴
        paint.setColor(Color.BLUE);
        canvas.drawLine(0,0,0,80,paint);
        canvas.drawLine(0,0,80,0,paint);
        //平移到（10,10） 这个时候这个点就是原点（0，0）
        canvas.translate(50,50);
        paint.setColor(Color.GREEN);
        //这个代表平移之后的坐标轴
        canvas.drawLine(0,0,0,80,paint);
        canvas.drawLine(0,0,80,0,paint);
        //从这就能看出是坐标轴移动了
        //新起来一行
        canvas.translate(0,100);
        paint.setColor(Color.BLUE);
        //这个代表旋转之前的坐标轴
        canvas.drawLine(0,0,0,80,paint);
        canvas.drawLine(0,0,80,0,paint);
        canvas.rotate(-30);
        paint.setColor(Color.GREEN);
        //这个代表旋转之后的坐标轴
        canvas.drawLine(0,0,0,80,paint);
        canvas.drawLine(0,0,80,0,paint);

        //再新起一个
        canvas.rotate(30);
        canvas.translate(0,200);
        paint.setColor(Color.BLUE);
        //这个代表旋转之前的坐标轴
        canvas.drawLine(0,0,0,80,paint);
        canvas.drawLine(0,0,80,0,paint);
        canvas.drawPoint(40,40,paint);
        paint.setColor(Color.GREEN);
        //这个是以（40,40）为中心 对画布坐标进行旋转
        canvas.rotate(-30,40,40);
        canvas.drawLine(0,0,0,80,paint);
        canvas.drawLine(0,0,80,0,paint);

        //再新起一个
        canvas.rotate(30,40,40);
        canvas.translate(0,200);
        paint.setColor(Color.BLUE);
        canvas.drawLine(0,0,0,80,paint);
        canvas.drawLine(0,0,80,0,paint);



        Rect rect = new Rect(60,60,180,180);

        canvas.drawRect(rect,paint);
        paint.setColor(Color.GREEN);
        canvas.scale(1.2f,1.2f,rect.centerX(),rect.centerY());
        canvas.drawRect(rect,paint);
        canvas.scale(1.2f,1.2f,rect.centerX(),rect.centerY());
        canvas.drawRect(rect,paint);
        paint.setColor(Color.RED);
        //这个是不按照某个中心点进行绘制的  这个图形的绘制基础是以上面的最后一个矩形为参照
//        canvas.scale(1.2f,1.2f);
//        canvas.drawRect(rect,paint);

        canvas.restore();//恢复现场到save()执行之前的状态
        canvas.translate(800,40);
        paint.setColor(Color.BLUE);
        canvas.drawLine(0,0,0,80,paint);
        canvas.drawLine(0,0,80,0,paint);
        canvas.skew(0,1);
        paint.setColor(Color.GREEN);
        canvas.drawLine(0,0,0,80,paint);
        canvas.drawLine(0,0,80,0,paint);
        canvas.drawRect(rect,paint);
    }
}
