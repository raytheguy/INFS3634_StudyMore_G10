package com.example.studymore.Multithreader;

import android.os.AsyncTask;

import com.example.studymore.ui.FlashCards.FlashCardsDatabase;
import com.example.studymore.ui.Quiz.QuizResult;
import com.example.studymore.ui.Quiz.ScoreDatabase;

public class DeleteAllScoresAsyncTask extends AsyncTask<QuizResult, Integer, String> {
    private AsyncTaskDelegateString delegate;
    private ScoreDatabase database;
    public void setDelegate(AsyncTaskDelegateString delegate) {
        this.delegate = delegate;
    }
    public void setDatabase(ScoreDatabase database) {
        this.database = database;
    }

    @Override
    protected String doInBackground(QuizResult... quizResults) {
        database.quizScoreDao().nukeTable();
        return "Deleted your scores from the Database";
    }

    @Override
    protected void onPostExecute(String result) {
        // Once doInBackground is completed, this method will run.
        // The "result" comes from doInBackground.

        // TODO: Call the delegate's method with the results
        delegate.handleTaskResult(result);
    }

}
