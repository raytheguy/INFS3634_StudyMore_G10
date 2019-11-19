package com.example.studymore.Multithreader;

import android.os.AsyncTask;

import com.example.studymore.ui.FlashCards.FlashCards;
import com.example.studymore.ui.FlashCards.FlashCardsDatabase;

import java.util.UUID;

public class InsertFlashCardsAsyncTask extends AsyncTask<FlashCards, Integer, String> {
    private AsyncTaskDelegateString delegate;
    private FlashCardsDatabase database;
    private String front;
    private String back;
    private UUID randomUUID;

    public void setDelegate(AsyncTaskDelegateString delegate)  {
        this.delegate = delegate;
    }

    public void setDatabase(FlashCardsDatabase database) {
        this.database = database;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public void setRandomUUID(UUID randomUUID) {
        this.randomUUID = randomUUID;
    }

    @Override
    protected String doInBackground(FlashCards... flashCards) {
        // insert flash cards of what the user has entered
        //get from activity
        database.flashCardsDao().insert(new FlashCards(randomUUID.toString(), front, back));
        return "Getting FlashCards ";
    }

    @Override
    protected void onPostExecute(String result) {
        //tell the activity that the task has completed
        if (delegate != null) {
            delegate.handleTaskResult(result);
        }
    }
}
