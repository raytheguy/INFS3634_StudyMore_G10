package com.example.studymore;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studymore.Multithreader.AsyncTaskDelegateScoreList;
import com.example.studymore.Multithreader.GetScoreAsyncTask;
import com.example.studymore.ui.Quiz.QuizResult;
import com.example.studymore.ui.Quiz.ScoreAdapter;
import com.example.studymore.ui.Quiz.ScoreDatabase;

import java.util.ArrayList;


public class QuizScoresActivity extends AppCompatActivity implements AsyncTaskDelegateScoreList {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    Context mContext;
    ArrayList<QuizResult> quizResults;
    ScoreAdapter scoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_scores);

        mContext = this;
        quizResults = new ArrayList<>();

        recyclerView = findViewById(R.id.quizScore_rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Get the results from database
        ScoreDatabase sdb = ScoreDatabase.getInstance(mContext);
        GetScoreAsyncTask getScoreAsyncTask = new GetScoreAsyncTask();
        getScoreAsyncTask.setScoreDatabase(sdb);
        getScoreAsyncTask.setDelegate(this);
        getScoreAsyncTask.execute();

        scoreAdapter = new ScoreAdapter();

    }

    @Override
    public void handleTaskResult(ArrayList<QuizResult> result) {
        quizResults = result;
        scoreAdapter.setData(quizResults, mContext);
        recyclerView.setAdapter(scoreAdapter);
    }

}
