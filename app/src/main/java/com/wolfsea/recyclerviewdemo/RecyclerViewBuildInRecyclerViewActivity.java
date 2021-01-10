package com.wolfsea.recyclerviewdemo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.wolfsea.recyclerviewdemo.adapter.RootRvAdapter;
import com.wolfsea.recyclerviewdemo.defineview.NestRecyclerView;
import com.wolfsea.recyclerviewdemo.util.DataSetFactory;
import java.util.List;

public class RecyclerViewBuildInRecyclerViewActivity extends AppCompatActivity {

    @Override
    public void onContentChanged() {

        super.onContentChanged();
        rootRv = findViewById(R.id.root_rv);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_build_in_recycler_view);

        rootRv.setType(0);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rootRv.setLayoutManager(linearLayoutManager);

        final int itemCount = 3;
        List<String> titles = DataSetFactory.createTitles();
        List<List<String>> lettersList = DataSetFactory.createLettersList();

        rootRvAdapter = new RootRvAdapter(this, titles, lettersList);

        rootRv.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        rootRv.setAdapter(rootRvAdapter);
    }

    private static final String TAG = "MainActivity";

    private NestRecyclerView rootRv;
    private LinearLayoutManager linearLayoutManager;
    private RootRvAdapter rootRvAdapter;

}