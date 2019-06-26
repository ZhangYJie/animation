package com.zaz.app.animationproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zaz.app.animationproject.views.TestInvalidateView;

import java.util.Timer;
import java.util.TimerTask;

public class TextInvalidateActivity extends AppCompatActivity {

    TestInvalidateView textInvalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_invalidate);
        textInvalView  = (TestInvalidateView)findViewById(R.id.textInvalView);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //刷新view 这个是绘制整个view
                textInvalView.postInvalidate();
            }
        },300,50);
    }
}
