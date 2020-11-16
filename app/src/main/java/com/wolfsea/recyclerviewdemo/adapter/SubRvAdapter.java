package com.wolfsea.recyclerviewdemo.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.wolfsea.recyclerviewdemo.R;
import com.wolfsea.recyclerviewdemo.defineview.WHSameTextView;

import java.util.List;

/**
 * @author liuliheng
 * @desc 子RV适配器
 * @time 2020/11/12  21:21
 **/
public class SubRvAdapter extends RecyclerView.Adapter<SubRvAdapter.SubViewHolder> {

    private final List<String> subList;

    public SubRvAdapter(List<String> subList) {
        this.subList = subList;
    }

    @NonNull
    @Override
    public SubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rootItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_rv_item, parent, false);
        return new SubViewHolder(rootItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SubViewHolder holder, int position) {

        String letter = subList.get(position);
        holder.square_tv.setText(letter);
    }

    @Override
    public int getItemCount() {

        return subList == null ? 0 : subList.size();
    }

    public static class SubViewHolder extends RecyclerView.ViewHolder {

        protected WHSameTextView square_tv;

        public SubViewHolder(@NonNull View itemView) {

            super(itemView);
            square_tv = itemView.findViewById(R.id.square_tv);
        }
    }

}

