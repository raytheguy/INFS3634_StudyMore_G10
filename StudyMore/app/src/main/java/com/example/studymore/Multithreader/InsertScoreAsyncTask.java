package com.example.studymore.Multithreader;

import android.os.AsyncTask;

import com.example.studymore.ui.Quiz.QuizResult;
import com.example.studymore.ui.Quiz.ScoreDatabase;

public class InsertScoreAsyncTask extends AsyncTask<QuizResult, Integer, String> {
    private AsyncTaskDelegateString delegate;
    private ScoreDatabase scoreDatabase;
    private int attemptNumber;
    private int score;

    public void setDelegate(AsyncTaskDelegateString delegate) {
        this.delegate = delegate;
    }

    public void setScoreDatabase(ScoreDatabase scoreDatabase) {
        this.scoreDatabase = scoreDatabase;
    }

    public void setAttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    protected String doInBackground(QuizResult... quizResults) {
        //get the size of the database
        int attemptNumber = scoreDatabase.quizScoreDao().getResults().size() + 1;

        scoreDatabase.quizScoreDao().insert(new QuizResult(attemptNumber, score));
        return "Inserted Score to Database";
    }

    @Override
    protected void onPostExecute(String result) {
        // Once doInBackground is completed, this method will run.
        // The "result" comes from doInBackground.

        // TODO: Call the delegate's method with the results
        delegate.handleTaskResult(result);
    }
}
