package com.zaz.app.animationproject.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.zaz.app.animationproject.R;

/**
 * 自定义view 测试自定义属性
 */
public class CustomAttrView extends View {
    /**
     * 画笔
     */
    Paint mPaint;

    String textStr;

    public CustomAttrView(Context context) {
        this(context,null);
    }

    /**
     *
     * @param context
     * @param attrs 可以获取布局文件中定义的所有属性的key和value  但是通过他获得的值 可能变为@+数字  而TypeArray 帮助我们把这些都解析了，给我们的就是最终值
     */
    public CustomAttrView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        //TypedArray 简单来说就是自定义集合的一个索引，可以通过这个对象找到你自定义的那些属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomAttrView);
        //属性格式为  R.styleable.样式名_属性名

        //获取颜色
        int textColor = typedArray.getColor(R.styleable.CustomAttrView_attrColor, Color.BLACK);

        textStr = typedArray.getString(R.styleable.CustomAttrView_attrString);

        mPaint.setColor(textColor);

        testAttributeSet(attrs);

        Log.e("测试TypedArray", "textStr = "+textStr+"\ttextColor = "+textColor);
        //回收typeArray 调用此方法后不能再使用这个对象了
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (textStr!=null){
            canvas.drawText(textStr,10,10,mPaint);
        }
    }

    /**
     * 测试一下 看看attributeSet获取到的值是什么
     * @param attrs
     */
    public void testAttributeSet(AttributeSet attrs){
      int attrCount =  attrs.getAttributeCount();
      for (int i = 0;i<attrCount;i++){
          String name = attrs.getAttributeName(i);
          String value = attrs.getAttributeValue(i);
          Log.e("测试AttributeSet", "name = "+name+"\tvalue = "+value);
      }
    }


}
