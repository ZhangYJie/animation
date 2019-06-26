package com.zaz.app.animationproject.views;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class TestInvalidateView extends View {
    /**
     * 小球的水平位置
     */
    private int x;
    /**
     * 小球的垂直位置，固定为 100
     */
    private static final int Y = 90;
    /**
     * 小球的半径
     */
    private static final int RADIUS = 30;
    /**小球的颜色*/
    /**
     * 移动的方向  true 代表x轴的正向移动 false 代表x轴的负向移动
     */
    private boolean direction;
    Paint paint;

    public TestInvalidateView(Context context) {
        super(context);
    }

    public TestInvalidateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setTextSize(20);
        //初始化画笔，参数表示去锯齿
        x = RADIUS;
    }

    public TestInvalidateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //根据 x、y 的坐标值画一个小球
        canvas.drawCircle(x, Y, RADIUS, paint);
        //改变 x 坐标的值，调用 invalidate()方法后，
        //小球将因 x 的值发生改变而产生移动的效果
        int width = this.getMeasuredWidth();//获取组件的宽度
        if (x <= RADIUS) {
            direction = true;
        }
        if (x >= width - RADIUS) {
            direction = false;
        }
        Log.e("direction的值",String.valueOf(direction));
        x = direction ? x + 5 : x - 5;
        //绘制随机数
        canvas.drawRect(200, 50, 340, 80, paint);
        canvas.drawText(String.valueOf((int) (Math.random() * 10) + 1), 10, 10, paint);
    }
}
