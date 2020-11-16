package com.wolfsea.recyclerviewdemo.defineview;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.lang.ref.WeakReference;

/**
 * @author liuliheng
 * @desc 子RV
 * @time 2020/11/13  0:10
 **/
public class ChildRecyclerView extends RecyclerView {

    private static final String TAG = "ChildRecyclerView";
    private boolean mScrolled = true;


    public ChildRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public ChildRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ChildRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.addOnScrollListener(new ChildRVScrollListener(this));
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        //请求父View放行事件
        getParent().requestDisallowInterceptTouchEvent(mScrolled);
        return super.dispatchTouchEvent(event);
    }

    public void setScrolled(boolean mScrolled) {
        this.mScrolled = mScrolled;
    }

    /**
     *@desc 滚动监听器
     *@author:liuliheng
     *@time: 2020/11/13 8:15
    **/
    private static class ChildRVScrollListener extends RecyclerView.OnScrollListener {

        private final WeakReference<ChildRecyclerView> weakReference;

        public ChildRVScrollListener(ChildRecyclerView childRecyclerView) {
            this.weakReference = new WeakReference<>(childRecyclerView);
        }

        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {

            super.onScrollStateChanged(recyclerView, newState);

            boolean weakReferenceIsNull = weakReferenceIsNull();
            if (weakReferenceIsNull) {
                return;
            }

            GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            boolean layoutManagerIsNull = layoutManager == null;
            if (layoutManagerIsNull) {
                return;
            }

            //处于不滚动状态
            boolean mIsIdleState = newState == RecyclerView.SCROLL_STATE_IDLE;
            if (mIsIdleState) {

                ChildRecyclerView childRecyclerView = weakReference.get();

                int firstVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition();
                int lastVisibleItem = layoutManager.findLastCompletelyVisibleItemPosition();
                int totalItemCount = layoutManager.getItemCount();

                boolean mIsInBottom = lastVisibleItem == (totalItemCount - 1);
                if (mIsInBottom) {

                    Log.d(TAG, "mIsInBottom->true");
                    childRecyclerView.mScrolled = false;
                }

                boolean mIsInTop = firstVisibleItem == 0;
                if (mIsInTop) {

                    Log.d(TAG, "mIsInTop->true");
                    childRecyclerView.mScrolled = false;
                }

            }
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {

            super.onScrolled(recyclerView, dx, dy);

            boolean weakReferenceIsNull = weakReferenceIsNull();
            if (weakReferenceIsNull) {
                return;
            }

            //dx用来判断横向滚动方向,dy用来判断纵向滚动方向. dx > 0 则表示向右滚动,否则向左滚动.dy原理类似
            //Log.d(TAG, "dy->" + dy);
            ChildRecyclerView childRecyclerView = weakReference.get();
            childRecyclerView.mScrolled = true;
        }

        /**
         *@desc 持有外部类的引用是否为空
         *@author:liuliheng
         *@time: 2020/11/13 8:39
        **/
        private boolean weakReferenceIsNull() {
            return weakReference == null || weakReference.get() == null;
        }
    }

}
