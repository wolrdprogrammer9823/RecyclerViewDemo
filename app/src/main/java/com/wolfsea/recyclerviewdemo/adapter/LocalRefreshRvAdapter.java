package com.wolfsea.recyclerviewdemo.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.wolfsea.recyclerviewdemo.R;
import com.wolfsea.recyclerviewdemo.bean.LocalRvData;
import java.text.MessageFormat;
import java.util.List;

/**
 * @author liuliheng
 * @desc 局部刷新RV适配器
 * @time 2020/11/17  10:28
 **/
public class LocalRefreshRvAdapter extends RecyclerView.Adapter<LocalRefreshRvAdapter.LocalRefreshHolder> {

    private static final String TAG = "LocalRefreshRvAd";

    private List<LocalRvData> dataSet;

    private final View.OnClickListener onClickListener;
    private final View.OnLongClickListener onLongClickListener;

    private OnItemClickListener onItemClickListener;

    public LocalRefreshRvAdapter() {

        onClickListener = view -> {

            LocalRefreshHolder holder = (LocalRefreshHolder) view.getTag();
            boolean itemClickListenerNotNull = onItemClickListener != null;
            if (itemClickListenerNotNull) {

                int position = holder.getAdapterPosition();
                onItemClickListener.onItemClick(view, holder, position);
            }
        };

        onLongClickListener = view -> {

            LocalRefreshHolder holder = (LocalRefreshHolder) view.getTag();
            boolean itemClickListenerNotNull = onItemClickListener != null;
            if (itemClickListenerNotNull) {

                int position = holder.getAdapterPosition();
                onItemClickListener.onItemLongClick(view, holder, position);
            }

            return true;
        };
    }

    public LocalRefreshRvAdapter(List<LocalRvData> dataSet) {

        this.dataSet = dataSet;

        onClickListener = view -> {

            LocalRefreshHolder holder = (LocalRefreshHolder) view.getTag();
            boolean itemClickListenerNotNull = onItemClickListener != null;
            if (itemClickListenerNotNull) {

                int position = holder.getAdapterPosition();
                onItemClickListener.onItemClick(view, holder, position);
            }
        };

        onLongClickListener = view -> {

            LocalRefreshHolder holder = (LocalRefreshHolder) view.getTag();
            boolean itemClickListenerNotNull = onItemClickListener != null;
            if (itemClickListenerNotNull) {

                int position = holder.getAdapterPosition();
                onItemClickListener.onItemLongClick(view, holder, position);
            }

            return true;
        };
    }

    @NonNull
    @Override
    public LocalRefreshHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.local_refersh_rv_item, parent, false);
        return new LocalRefreshHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalRefreshHolder holder, int position) {

        LocalRvData localRvData = dataSet.get(position);

        String title = localRvData.getTitle();
        String content = localRvData.getContent();

        String format_title = MessageFormat.format("{0}{1}{2}", title, "--->", position + 1);
        holder.localRefreshTitleTv.setText(format_title);
        holder.localRefreshContentTv.setText(content);

        holder.itemView.setTag(holder);

        holder.itemView.setOnClickListener(onClickListener);
        holder.itemView.setOnLongClickListener(onLongClickListener);
    }

    @Override
    public int getItemCount() {
        return dataSet == null ? 0 : dataSet.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     *@desc ViewHolder类
     *@author:liuliheng
     *@time: 2020/11/17 15:26
    **/
    public static class LocalRefreshHolder extends RecyclerView.ViewHolder {

        private final AppCompatTextView localRefreshTitleTv;
        private final AppCompatTextView localRefreshContentTv;

        public LocalRefreshHolder(@NonNull View itemView) {

            super(itemView);

            localRefreshTitleTv = itemView.findViewById(R.id.local_refresh_title_tv);
            localRefreshContentTv = itemView.findViewById(R.id.local_refresh_content_tv);
        }
    }

    /**
     *@desc 点击事件接口
     *@author:liuliheng
     *@time: 2020/11/17 15:29
    **/
    public interface OnItemClickListener {

        void onItemClick(View view, LocalRefreshHolder localRefreshHolder, int position);

        void onItemLongClick(View view, LocalRefreshHolder localRefreshHolder, int position);
    }

    public void setDataSet(List<LocalRvData> dataSet) {
        this.dataSet = dataSet;
    }
}
