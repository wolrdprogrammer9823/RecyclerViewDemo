package com.wolfsea.recyclerviewdemo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;

import com.wolfsea.recyclerviewdemo.adapter.SampleRvAdapter;
import com.wolfsea.recyclerviewdemo.defineview.NestRecyclerView;
import com.wolfsea.recyclerviewdemo.util.DataSetFactory;
import java.util.List;

public class RecyclerViewBuildScrollViewActivity extends AppCompatActivity {

    @Override
    public void onContentChanged() {

        super.onContentChanged();
        recyclerView = findViewById(R.id.rv_build_in_sv_rv);

        Log.d(TAG, "onContentChanged()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_build_scroll_view);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        List<String> titles = DataSetFactory.createTitles();
        sampleRvAdapter = new SampleRvAdapter(titles);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setType(1);
        recyclerView.setAdapter(sampleRvAdapter);

        Log.d(TAG, "onCreate(Bundle savedInstanceState)");
    }

    private static final String TAG = "RecyclerViewBuild";

    private NestRecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SampleRvAdapter sampleRvAdapter;
}