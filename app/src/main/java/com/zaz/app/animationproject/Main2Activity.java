package com.zaz.app.animationproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button btn_testCanvasAndPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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
