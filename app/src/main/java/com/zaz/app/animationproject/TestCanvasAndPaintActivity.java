package com.zaz.app.animationproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class TestCanvasAndPaintActivity extends AppCompatActivity {
    ImageView img_drawBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_canvas_and_paint);
        img_drawBitmap = (ImageView) findViewById(R.id.img_drawBitmap);

        Bitmap bitmap = Bitmap.createBitmap(500,800, Bitmap.Config.ARGB_8888);
        //创建画布
        Canvas canvas = new Canvas(bitmap);
        Bitmap resBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        //创建画笔
        Paint paint = new Paint();
        paint.setStrokeWidth(15);
        paint.setColor(Color.GREEN);
        paint.setStrokeJoin(Paint.Join.ROUND);//拐角处
        paint.setStyle(Paint.Style.STROKE);

        //在原点处开始绘制原始bitmap图片
        canvas.drawBitmap(resBitmap,0,0,paint);

        int width  = resBitmap.getWidth();
        int height = resBitmap.getHeight();

        //相当于分成4份，取出原始图片左上角的一块
        Rect rectSrc = new Rect(0,0,width/2,height/2);
        //在原图片的旁边，将剪切出来的那块放大4倍 即新的图片是原来的图片的两倍 right的这个是要乘3是因为left的值为一个width 生成矩形是right-left才是矩形的宽度
        Rect rectDst = new Rect(width,0,width*3,height*2);

        canvas.drawBitmap(resBitmap,rectSrc,rectDst,paint);
        //绘制点
        canvas.drawPoint(width,height*3,paint);
        //绘制线
        canvas.drawLine(width/2,height*2,width/2,height*3,paint);
        //下面的这几个是在一个中心的，也能说明椭圆依赖于它的外切矩形
        //绘制弧线或者扇形其实就是绘制椭圆的一段，所以也要依赖于椭圆的外切矩形，所以也需要传入代表矩形的Rect对象
        //绘制矩形
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(3);
        //Api 为21的
        //canvas.drawRoundRect(0,height*4,width*4,height*6,3,3,paint);
        //绘制圆角矩形也先创建rect类，然后传入
        canvas.drawRect(width,height*4,width*4,height*6,paint);
        //这个也是Api 为21的
//        canvas.drawOval(width,height*4,width*4,height*6,paint);
        //绘制椭圆
        RectF rectOval = new RectF(width,height*4,width*4,height*6);
        canvas.drawOval(rectOval,paint);
        //绘制扇形，false 代表绘制 弧线
        paint.setColor(Color.RED);
        canvas.drawArc(rectOval,-10,30,true,paint);
        paint.setColor(Color.BLUE);
        canvas.drawArc(rectOval,-10,-30,false,paint);
        img_drawBitmap.setImageBitmap(bitmap);
    }
}
