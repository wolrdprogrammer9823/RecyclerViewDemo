
package com.wolfsea.recyclerviewdemo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.wolfsea.recyclerviewdemo.adapter.LocalRefreshRvAdapter;
import com.wolfsea.recyclerviewdemo.bean.LocalRvData;
import com.wolfsea.recyclerviewdemo.callback.AdapterDiffCallback;
import com.wolfsea.recyclerviewdemo.shimmer.ShimmerRecyclerView;
import com.wolfsea.recyclerviewdemo.util.DataSetFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecyclerViewLocalRefreshActivity extends AppCompatActivity
                                              implements View.OnClickListener,LocalRefreshRvAdapter.OnItemClickListener {

    @Override
    public void onContentChanged() {

        super.onContentChanged();

        keyEt = findViewById(R.id.key_et);
        valueEt = findViewById(R.id.value_et);
        positionEt = findViewById(R.id.position_et);

        AppCompatButton sureUpdateBtn = findViewById(R.id.sure_update_btn);
        sureUpdateBtn.setOnClickListener(this);

        localRefreshRv = findViewById(R.id.local_refresh_rv);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_local_refresh);

        localRefreshRv.setLayoutManager(layoutManager);
        localRefreshRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));

        localRefreshRvAdapter = new LocalRefreshRvAdapter();
        localRefreshRvAdapter.setOnItemClickListener(this);
        localRefreshRv.setAdapter(localRefreshRvAdapter);
        localRefreshRv.showShimmerAdapter();

        localRefreshRv.postDelayed(() -> {

            oldDataSet = DataSetFactory.getDataSet();
            newDataSet = new ArrayList<>(oldDataSet);
            localRefreshRvAdapter.setDataSet(oldDataSet);
            localRefreshRv.hideShimmerAdapter();

        }, 5000);

    }

    @Override
    public void onClick(View view) {

        final int VIEW_ID = view.getId();
        switch (VIEW_ID) {
            case R.id.sure_update_btn: {

                String key = Objects.requireNonNull(keyEt.getText()).toString().trim();
                String value = Objects.requireNonNull(valueEt.getText()).toString().trim();
                String position = Objects.requireNonNull(positionEt.getText()).toString().trim();

                int index = 0;
                if (position.matches("[\\d+]")) {

                    index = Integer.parseInt(position);
                }

                Log.d(TAG, "key:" + key + ",value:" + value + ",position:" + position);
                LocalRvData localRvData = new LocalRvData(key, value);
                newDataSet.set(index, localRvData);

                //LocalRvData oldLocalRvData = oldDataSet.get(index);
                //Log.d(TAG, oldLocalRvData.toString());

                //LocalRvData newLocalRvData = newDataSet.get(index);
                //Log.d(TAG, newLocalRvData.toString());

                AdapterDiffCallback<LocalRvData> adapterDiffCallback
                        = new AdapterDiffCallback<>(oldDataSet, newDataSet);
                DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(adapterDiffCallback);

                oldDataSet.set(index, localRvData);

                diffResult.dispatchUpdatesTo(localRefreshRvAdapter);
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void onItemClick(View view, LocalRefreshRvAdapter.LocalRefreshHolder localRefreshHolder, int position) {

        LocalRvData localRvData = oldDataSet.get(position);
        Toast.makeText(this, localRvData.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, LocalRefreshRvAdapter.LocalRefreshHolder localRefreshHolder, int position) {

    }

    private static final String TAG = "RVLocalRefreshActivity";

    private AppCompatEditText keyEt;
    private AppCompatEditText valueEt;
    private AppCompatEditText positionEt;

    private ShimmerRecyclerView localRefreshRv;
    private LinearLayoutManager layoutManager;
    private LocalRefreshRvAdapter localRefreshRvAdapter;

    private List<LocalRvData> oldDataSet;
    private List<LocalRvData> newDataSet;
}