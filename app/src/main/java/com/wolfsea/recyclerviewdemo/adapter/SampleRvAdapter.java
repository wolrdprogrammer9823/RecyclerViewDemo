package com.wolfsea.recyclerviewdemo.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.wolfsea.recyclerviewdemo.R;
import com.wolfsea.recyclerviewdemo.defineview.ChildScrollView;

import java.util.List;

/**
 * @author liuliheng
 * @desc  RV适配器
 * @time 2020/11/14  16:15
 **/
public class SampleRvAdapter extends RecyclerView.Adapter<SampleRvAdapter.SampleViewHolder>{

    private List<String> dataSet;

    public SampleRvAdapter(List<String> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public SampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_build_in_sv_item, parent, false);
        return new SampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder holder, int position) {

        String title = dataSet.get(position);
        holder.titleTv.setText(title);

    }

    @Override
    public int getItemCount() {

        return dataSet == null ? 0 : dataSet.size();
    }

    public static class SampleViewHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView titleTv;
        public ChildScrollView childScrollView;

        public SampleViewHolder(@NonNull View itemView) {

            super(itemView);
            titleTv = itemView.findViewById(R.id.rv_build_in_sv_title);
            childScrollView = itemView.findViewById(R.id.child_sv);
        }
    }

}
