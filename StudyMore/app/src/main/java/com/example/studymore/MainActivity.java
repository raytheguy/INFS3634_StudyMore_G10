package com.example.studymore;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studymore.ActivityDB.ActivityAdapter;
import com.example.studymore.ActivityDB.ActivityDatabase;

public class MainActivity extends AppCompatActivity {

    public ImageButton settingsButton;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_activity);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ActivityAdapter activityAdapter = new ActivityAdapter();

        activityAdapter.setData(ActivityDatabase.getAllActivity());
        recyclerView.setAdapter(activityAdapter);


    }
}
