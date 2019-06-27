package com.zaz.app.animationproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zaz.app.animationproject.views.TestCoordinateView;

public class Main2Activity extends AppCompatActivity {

    Button btn_testCanvasAndPaint;
    Button btn_testInvalidate;
    Button btn_testCoordinate;
    Button btn_testClip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_testClip = (Button)findViewById(R.id.btn_testClip);
        btn_testClip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Main2Activity.this,TestClipActivity.class);
                    startActivity(intent);
                }
            }
        );
        btn_testCoordinate = (Button)findViewById(R.id.btn_testCoordinate);
        btn_testCoordinate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,TestCoordinateActivity.class);
                startActivity(intent);
            }
        });
        btn_testInvalidate = (Button)findViewById(R.id.btn_testInvalidate);
        btn_testInvalidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,TextInvalidateActivity.class);
                startActivity(intent);
            }
        });
        btn_testCanvasAndPaint = (Button)findViewById(R.id.btn_testCanvasAndPaint);
        btn_testCanvasAndPaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,TestCanvasAndPaintActivity.class);
                startActivity(intent);
            }
        });
    }
}
