package com.wolfsea.recyclerviewdemo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.wolfsea.recyclerviewdemo.adapter.RootRvAdapter;
import com.wolfsea.recyclerviewdemo.defineview.ChildRecyclerView;
import com.wolfsea.recyclerviewdemo.util.DataSetFactory;

import java.util.List;

public class ScrollViewBuildInRecyclerViewActivity extends AppCompatActivity {

    @Override
    public void onContentChanged() {

        super.onContentChanged();
        childRecyclerView = findViewById(R.id.child_rv);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_build_in_recycler_view);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        childRecyclerView.setLayoutManager(linearLayoutManager);

        List<String> titles = DataSetFactory.createTitles();
//        List<List<String>> lettersList = DataSetFactory.createLettersList();

//        Log.d(TAG, titles.toString());
//
//        for (int i = 0; i < lettersList.size(); i++) {
//
//            Log.d(TAG, lettersList.get(i).toString());
//        }

        rootRvAdapter = new RootRvAdapter(this, titles, null);

        childRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        childRecyclerView.setAdapter(rootRvAdapter);
    }

    private RecyclerView childRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RootRvAdapter rootRvAdapter;
}