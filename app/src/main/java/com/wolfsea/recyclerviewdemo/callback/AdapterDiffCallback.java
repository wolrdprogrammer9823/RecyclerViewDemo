package com.wolfsea.recyclerviewdemo.callback;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import java.util.List;

/**
 * @author liuliheng
 * @desc  比较两个数据集不同的回调
 * @time 2020/11/17  14:31
 **/
public class AdapterDiffCallback<T> extends DiffUtil.Callback {

    private final List<T> oldDataSet;
    private final List<T> newDataSet;

    public AdapterDiffCallback(List<T> oldDataSet, List<T> newDataSet) {
        this.oldDataSet = oldDataSet;
        this.newDataSet = newDataSet;
    }

    @Override
    public int getOldListSize() {
        return oldDataSet == null ? 0 : oldDataSet.size();
    }

    @Override
    public int getNewListSize() {
        return newDataSet == null ? 0 : oldDataSet.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

        boolean areItemsTheSame =
                oldDataSet.get(oldItemPosition).getClass().equals(newDataSet.get(newItemPosition).getClass());
        return areItemsTheSame;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

        T oldObj = oldDataSet.get(oldItemPosition);
        T newObj = newDataSet.get(newItemPosition);
        boolean areContentsTheSame = newObj.equals(oldObj);
        return areContentsTheSame;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
