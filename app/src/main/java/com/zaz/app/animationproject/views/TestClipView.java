package com.zaz.app.animationproject.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zaz.app.animationproject.R;

public class TestClipView extends View {
    Context context;
    Paint paint;
    public TestClipView(Context context) {
        super(context);
        this.context = context;
    }

    public TestClipView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        paint = new Paint();
    }

    public TestClipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //剪切
        Rect rect = new Rect(120,120,260,260);
        canvas.clipRect(rect);

        Path path = new Path();
        path.addCircle(rect.right,rect.bottom,80, Path.Direction.CCW);
        canvas.clipPath(path, Region.Op.UNION);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.th);
        canvas.drawBitmap(bitmap,30,30,paint);
    }
}
