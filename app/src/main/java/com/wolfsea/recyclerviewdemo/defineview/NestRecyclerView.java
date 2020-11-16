package com.wolfsea.recyclerviewdemo.defineview;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.wolfsea.recyclerviewdemo.adapter.RootRvAdapter;
import com.wolfsea.recyclerviewdemo.adapter.SampleRvAdapter;

import java.lang.ref.WeakReference;

/**
 * @author liuliheng
 * @desc 解决嵌套滑动冲突的RecyclerView
 * @time 2020/11/12  20:14
 **/
public class NestRecyclerView extends RecyclerView implements RecyclerView.OnItemTouchListener {

    private static final String TAG = "NestRecyclerView";

    private int type;

    private boolean mScrolled = false;
    private ChildRecyclerView childRecyclerView;
    private ChildScrollView childScrollView;

    public NestRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public NestRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public NestRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        addOnScrollListener(new NestRVScrollListener(this));
        addOnItemTouchListener(this);
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent event) {

        View itemView = rv.findChildViewUnder(event.getX(), event.getY());
        boolean itemViewNotNull = itemView != null;
        if (itemViewNotNull) {

            if (type == 0) {

                RootRvAdapter.RootViewHolder viewHolder
                        = (RootRvAdapter.RootViewHolder) rv.getChildViewHolder(itemView);
                childRecyclerView = viewHolder.subRv;
            } else if (type == 1) {

                SampleRvAdapter.SampleViewHolder viewHolder
                        = (SampleRvAdapter.SampleViewHolder) rv.getChildViewHolder(itemView);
                childScrollView = viewHolder.childScrollView;
            }
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent event) {}
    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {}

    /**
     *@desc 滚动监听器
     *@author:liuliheng
     *@time: 2020/11/13 8:15
     **/
    private static class NestRVScrollListener extends RecyclerView.OnScrollListener {

        private final WeakReference<NestRecyclerView> weakReference;

        public NestRVScrollListener(NestRecyclerView nestRecyclerView) {
            this.weakReference = new WeakReference<>(nestRecyclerView);
        }

        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {

            super.onScrollStateChanged(recyclerView, newState);

            boolean weakReferenceIsNull = weakReferenceIsNull();
            if (weakReferenceIsNull) {
                return;
            }

            //处于不滚动状态
            boolean mIsIdleState = newState == RecyclerView.SCROLL_STATE_IDLE;
            NestRecyclerView nestedScrollView = weakReference.get();

            boolean condition = mIsIdleState && nestedScrollView.mScrolled;
            int type = nestedScrollView.type;

            if (type == 0) {

                boolean childRvNotNull = nestedScrollView.childRecyclerView != null;
                condition = condition && childRvNotNull;
                if (condition) {

                    nestedScrollView.childRecyclerView.setScrolled(true);
                }
            } else if (type == 1) {

                boolean childSvNotNull = nestedScrollView.childScrollView != null;
                condition = condition && childSvNotNull;

                if (condition) {

                    nestedScrollView.childScrollView.setScrolled(true);
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

            NestRecyclerView nestedScrollView = weakReference.get();
            nestedScrollView.mScrolled = dy != 0;
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

    public void setType(int type) {
        this.type = type;
    }
}
