package com.wolfsea.recyclerviewdemo.defineview;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author liuliheng
 * @desc  RV的item间距分割
 * @time 2020/11/12  22:48
 **/
public class EvenItemDecoration extends RecyclerView.ItemDecoration {

    private int space;
    private int column;

    public EvenItemDecoration(int space,int column) {
        this.space = space;
        this.column = column;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        // 每个span分配的间隔大小
        int spanSpace = space * (column + 1) / column;
        // 列索引
        int colIndex = position % column;
        // 列左、右间隙
        outRect.left = space * (colIndex + 1) - spanSpace * colIndex;
        outRect.right = spanSpace * (colIndex + 1) - space * (colIndex + 1);
        // 行间距
        if (position >= column) {
            outRect.top = space;
        }
    }
}
