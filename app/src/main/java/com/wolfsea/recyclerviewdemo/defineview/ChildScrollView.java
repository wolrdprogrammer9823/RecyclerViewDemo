package com.wolfsea.recyclerviewdemo.defineview;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;
/**
 * @author liuliheng
 * @desc 子SV
 * @time 2020/11/14  11:29
 **/
public class ChildScrollView extends ScrollView {

    private boolean mScrolled = true;

    private int oldDownY = 0;

    private static final String TAG = "ChildScrollView";

    public ChildScrollView(Context context) {
        this(context, null);
    }

    public ChildScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ChildScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        final int ACTION = ev.getAction();
        switch (ACTION) {
            case MotionEvent.ACTION_DOWN: {

                oldDownY = (int) ev.getY();
                break;
            }
            case MotionEvent.ACTION_UP: {

                int newDownY = (int) ev.getY();

                boolean directionToBottom = (newDownY - oldDownY) > 0;

                if (directionToBottom) {
                    //是否滚动到了顶部
                    boolean mIsScrolledToTop =  this.getScrollY() == 0;
                    Log.d(TAG, "mIsScrolledToTop:" + mIsScrolledToTop);
                    if (mIsScrolledToTop) {

                        mScrolled = false;
                    }
                }

                boolean directionToTop = (newDownY - oldDownY) < 0;

                if (directionToTop) {
                    //是否滚动到了底部
                    boolean mIsScrolledToBottom
                            = (this.getChildAt(0).getHeight() - this.getHeight()) == this.getScrollY();
                    Log.d(TAG, "mIsScrolledToBottom:" + mIsScrolledToBottom);
                    if (mIsScrolledToBottom) {

                        mScrolled = false;
                    }
                }

                oldDownY = newDownY;
                break;
            }
            default:
                break;
        }

        getParent().requestDisallowInterceptTouchEvent(mScrolled);
        return super.dispatchTouchEvent(ev);
    }

    public void setScrolled(boolean mScrolled) {
        this.mScrolled = mScrolled;
    }
}
