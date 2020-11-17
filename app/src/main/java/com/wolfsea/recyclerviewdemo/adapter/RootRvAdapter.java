package com.wolfsea.recyclerviewdemo.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.wolfsea.recyclerviewdemo.R;
import com.wolfsea.recyclerviewdemo.defineview.ChildRecyclerView;
import com.wolfsea.recyclerviewdemo.defineview.EvenItemDecoration;
import java.util.List;

/**
 * @author liuliheng
 * @desc 主RV适配器
 * @time 2020/11/12  21:21
 **/
public class RootRvAdapter extends RecyclerView.Adapter<RootRvAdapter.RootViewHolder> {

    private final Context context;

    private final List<String> rootList;
    private final List<List<String>> subList;

    public RootRvAdapter(Context context, List<String> rootList, List<List<String>> subList) {

        this.context = context;

        this.rootList = rootList;
        this.subList = subList;
    }

    @NonNull
    @Override
    public RootViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rootItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.root_rv_item, parent, false);
        return new RootViewHolder(rootItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RootViewHolder holder, int position) {

        String title = rootList.get(position);
        holder.titleIv.setText(title);

        boolean subListNotNull = subList != null;
        if (subListNotNull) {

            List<String> letterList = subList.get(position);
            holder.subRv.setLayoutManager(new GridLayoutManager(context, 3));
            holder.subRv.addItemDecoration(new EvenItemDecoration(10, 3));
            holder.subRv.setAdapter(new SubRvAdapter(letterList));
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {

        return rootList == null ? 0 : rootList.size();
    }

    public static class RootViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView titleIv;
        //protected RecyclerView subRv;
        public ChildRecyclerView subRv;

        public RootViewHolder(@NonNull View itemView) {

            super(itemView);

            titleIv = itemView.findViewById(R.id.title_iv);
            subRv = itemView.findViewById(R.id.sub_rv);
        }
    }

}

