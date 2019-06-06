package com.zaz.app.animationproject.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zaz.app.animationproject.R;

/**
 * 这个是用来测试不使用declare-styleable 直接定义
 */
public class MyView extends View {

    int[] mAttr = {R.attr.attrText};
    String text;
    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,mAttr);
        //数组的下标
        text = typedArray.getString(0);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (text!=null){
            Paint paint = new Paint();
            canvas.drawText(text,10,10,paint);
        }
    }
}
