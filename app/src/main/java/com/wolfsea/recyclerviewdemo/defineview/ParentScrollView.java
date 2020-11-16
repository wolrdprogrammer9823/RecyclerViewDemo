package com.wolfsea.recyclerviewdemo.defineview;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import androidx.appcompat.widget.LinearLayoutCompat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuliheng
 * @desc 父ScrollView
 * @time 2020/11/16  23:14
 **/
public class ParentScrollView extends ScrollView {

    private static final String TAG = "ParentScrollView";

    private int oldDownY = 0;

    private final List<ChildScrollView> childScrollViewList = new ArrayList<>();

    public ParentScrollView(Context context) {
        super(context);
    }

    public ParentScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParentScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        final int ACTION = event.getAction();
        switch (ACTION) {
            case MotionEvent.ACTION_DOWN: {

                oldDownY = (int) event.getY();

                childScrollViewList.clear();
                break;
            }
            case MotionEvent.ACTION_UP: {

                int newDownY = (int) event.getY();
                boolean moved = Math.abs(newDownY - oldDownY) != 0;
                Log.d(TAG, "moved:" + moved);
                if (moved) {

                    findScrollView();
                    notifyDisallowRequestInterceptTouchEvent();
                }
                break;
            }
            default:
                break;
        }

        return super.dispatchTouchEvent(event);
    }

    /**
     *@desc 找到所有的ChildScrollView
     *@author:liuliheng
     *@time: 2020/11/16 23:37
    **/
    private void findScrollView() {

        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) this.getChildAt(0);

        final int CHILD_COUNT = linearLayoutCompat.getChildCount();

        for (int i = 0; i < CHILD_COUNT; i++) {

            View view = linearLayoutCompat.getChildAt(i);
            boolean mIsChildScrollView = view instanceof ChildScrollView;
            if (mIsChildScrollView) {

                ChildScrollView childScrollView = (ChildScrollView) view;
                childScrollViewList.add(childScrollView);
            }
        }

    }

    /**
     *@desc 通知ChildScrollView拦截事件
     *@author:liuliheng
     *@time: 2020/11/16 23:39
    **/
    private void notifyDisallowRequestInterceptTouchEvent() {
        for (ChildScrollView childScrollView : childScrollViewList) {
            childScrollView.setScrolled(true);
        }
    }

}
