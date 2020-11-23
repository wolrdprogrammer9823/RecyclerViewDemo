package com.wolfsea.recyclerviewdemo.defineview;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * @author liuliheng
 * @desc 自定义ImageView
 * @time 2020/11/23  17:21
 **/
public class DefineImageView extends AppCompatImageView {

    private static final String TAG = "DefineImageView";

    public DefineImageView(@NonNull Context context) {
        super(context);
    }

    public DefineImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DefineImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        Log.d(TAG, this.getClass().getSimpleName() + "->public boolean dispatchTouchEvent(MotionEvent event)");
        //true消费事件;super.dispatchTouchEvent(event)事件传递到public boolean onTouchEvent(MotionEvent event)
        //false事件传递到ViewGroup的onTouchEvent()方法
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        performClick();
        Log.d(TAG, this.getClass().getSimpleName() + "->public boolean onTouchEvent(MotionEvent event)");
        //true消费事件;false/super.onTouchEvent(event)事件传递到ViewGroup的onTouchEvent()方法
        return false;
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }
}
