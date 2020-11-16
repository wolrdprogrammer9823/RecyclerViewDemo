package com.wolfsea.recyclerviewdemo.defineview;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * @author liuliheng
 * @desc 宽高相同的TextView
 * @time 2020/11/14  11:49
 **/
public class WHSameTextView extends AppCompatTextView {

    public WHSameTextView(@NonNull Context context) {
        super(context);
    }

    public WHSameTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WHSameTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
