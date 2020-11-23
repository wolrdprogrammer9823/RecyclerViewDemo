package com.wolfsea.recyclerviewdemo.defineview;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * @author liuliheng
 * @desc 自定义ConstraintLayout
 * @time 2020/11/23  16:45
 **/
public class DefineConstraintLayout extends ConstraintLayout {

    private static final String TAG = "DefineConstraintLayout";

    public DefineConstraintLayout(@NonNull Context context) {
        super(context);
    }

    public DefineConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DefineConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //false事件直接传递到Activity中,true消费当前事件,super.dispatchTouchEvent(MotionEvent ev)事件
        //传递给onInterceptTouchEvent(MotionEvent ev)
        Log.d(TAG, this.getClass().getSimpleName() + "->public boolean dispatchTouchEvent(MotionEvent event)");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //false/super.onInterceptTouchEvent(ev) 表示不拦截事件,事件传递到子View中;事件不会走到onTouchEvent(MotionEvent event)
        //只有true的时候才会走
        Log.d(TAG, this.getClass().getSimpleName() + "->public boolean onInterceptTouchEvent(MotionEvent event)");
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, this.getClass().getSimpleName() + "->public boolean onTouchEvent(MotionEvent event)");
        performClick();
        //true消费事件,super.onTouchEvent(MotionEvent event)/false直接传递到Activity中
        return false;
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

}
