package com.amhsn.taskatw.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.amhsn.taskatw.R;
import com.amhsn.taskatw.adapter.PostAdapter;
import com.amhsn.taskatw.data.json.Hit;
import com.amhsn.taskatw.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PostView {

    //vars
    private static final String TAG = MainActivity.class.getSimpleName();
    private List<PostModel> listOfPosts = new ArrayList<>();
    private PostAdapter adapter;

    //widgets
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: onStarted.");

        // call of method
        setupRecyclerView();

        // create object from PostPresenter
        PostPresenter postPresenter = new PostPresenter(this, this);
        postPresenter.setupCallAPI();

    }

    private void setupRecyclerView() {
        Log.d(TAG, "setupRecyclerView: initializing RecyclerView");
        recyclerView = findViewById(R.id.mainActivity_recVw_container);
        adapter = new PostAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void setList(List<Hit> list) {
        adapter.setList(list);
        recyclerView.setAdapter(adapter);
    }
}
