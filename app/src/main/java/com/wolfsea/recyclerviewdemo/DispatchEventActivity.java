package com.wolfsea.recyclerviewdemo;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class DispatchEventActivity extends AppCompatActivity {

    private static final String TAG = "DispatchEventActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch_event);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        //Log.d(TAG, this.getClass().getSimpleName() + "->public boolean dispatchTouchEvent(MotionEvent ev)");
        //true/false直接消费事件,事件不会向下传递;super.dispatchTouchEvent(ev)事件才会向下传递.
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //Log.d(TAG, this.getClass().getSimpleName() + "->public boolean onTouchEvent(MotionEvent ev)");
        //true消费事件;false/super.onTouchEvent(event)事件继续向上传递.
        return super.onTouchEvent(event);
    }
}