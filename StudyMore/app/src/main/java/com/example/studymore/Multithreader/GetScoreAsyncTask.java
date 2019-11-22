package com.example.studymore.Multithreader;

import android.os.AsyncTask;

import com.example.studymore.ui.Quiz.QuizResult;
import com.example.studymore.ui.Quiz.ScoreDatabase;

import java.util.ArrayList;

public class GetScoreAsyncTask extends AsyncTask<QuizResult, Integer, ArrayList<QuizResult>> {
    private AsyncTaskDelegateScoreList delegate;
    private ScoreDatabase scoreDatabase;
    private ArrayList<QuizResult> quizResultsList;

    public void setDelegate(AsyncTaskDelegateScoreList delegate) {
        this.delegate = delegate;
    }

    public void setScoreDatabase(ScoreDatabase scoreDatabase) {
        this.scoreDatabase = scoreDatabase;
    }

    public void setFlashCardsList(ArrayList<QuizResult> flashCardsList) {
        this.quizResultsList = flashCardsList;
    }

    @Override
    protected ArrayList<QuizResult> doInBackground(QuizResult... quizResults) {
        //creates a new arraylist with all cards from database
        quizResultsList = new ArrayList<QuizResult>(scoreDatabase.quizScoreDao().getResults());
        return quizResultsList;
    }

    @Override
    protected void onPostExecute(ArrayList<QuizResult> result) {
        //returns the arraylist of cards back to the activity
        delegate.handleTaskResult(result);
    }
}
