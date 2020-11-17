package com.wolfsea.recyclerviewdemo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirstFrameActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onContentChanged() {

        super.onContentChanged();

        scrollViewBuildInRecyclerViewBtn = findViewById(R.id.scrollview_build_in_recyclerview);
        scrollViewBuildInRecyclerViewBtn.setOnClickListener(this);

        recyclerViewBuildInRecyclerViewBtn = findViewById(R.id.recyclerview_build_in_recyclerview);
        recyclerViewBuildInRecyclerViewBtn.setOnClickListener(this);

        recyclerViewBuildInScrollViewBtn = findViewById(R.id.recyclerview_build_in_scrollview);
        recyclerViewBuildInScrollViewBtn.setOnClickListener(this);

        scrollViewBuildInScrollViewViewBtn = findViewById(R.id.scrollview_build_in_scrollview);
        scrollViewBuildInScrollViewViewBtn.setOnClickListener(this);

        recyclerViewLocalRefreshBtn = findViewById(R.id.recyclerview_local_refresh);
        recyclerViewLocalRefreshBtn.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_frame);

    }

    @Override
    public void onClick(View view) {

        final int VIEW_ID = view.getId();
        switch (VIEW_ID) {
            case R.id.scrollview_build_in_recyclerview: {

                startViewActivity(ScrollViewBuildInRecyclerViewActivity.class);
                break;
            }
            case R.id.recyclerview_build_in_recyclerview: {

                startViewActivity(RecyclerViewBuildInRecyclerViewActivity.class);
                break;
            }
            case R.id.recyclerview_build_in_scrollview: {

                startViewActivity(RecyclerViewBuildScrollViewActivity.class);
                break;
            }
            case R.id.scrollview_build_in_scrollview: {

                startViewActivity(ScrollViewBuildInScrollViewActivity.class);
                break;
            }
            case R.id.recyclerview_local_refresh: {

                startViewActivity(RecyclerViewLocalRefreshActivity.class);
                break;
            }
            default:
                break;
        }
    }

    /**
     *@desc 跳转Activity
     *@author:liuliheng
     *@time: 2020/11/14 9:28
    **/
    private void startViewActivity(Class<? extends AppCompatActivity> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    private AppCompatButton scrollViewBuildInRecyclerViewBtn;

    private AppCompatButton recyclerViewBuildInRecyclerViewBtn;

    private AppCompatButton recyclerViewBuildInScrollViewBtn;

    private AppCompatButton scrollViewBuildInScrollViewViewBtn;

    private AppCompatButton recyclerViewLocalRefreshBtn;
}