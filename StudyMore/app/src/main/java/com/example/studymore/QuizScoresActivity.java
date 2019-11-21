package com.example.studymore;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studymore.ui.Quiz.ScoreAdapter;

import static com.example.studymore.MainActivity.quizResultArrayList;

public class QuizScoresActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_scores);

        recyclerView = findViewById(R.id.quizScore_rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ScoreAdapter scoreAdapter = new ScoreAdapter();

        scoreAdapter.setData(quizResultArrayList);
        recyclerView.setAdapter(scoreAdapter);

    }
}
