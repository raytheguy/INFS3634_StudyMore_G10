package com.example.studymore.Multithreader;

import android.content.Context;
import android.os.AsyncTask;

import com.example.studymore.ui.FlashCards.FlashCards;
import com.example.studymore.ui.FlashCards.FlashCardsDatabase;

import java.util.ArrayList;

public class GetFlashCardsAsyncTask extends AsyncTask<FlashCards, Integer, ArrayList<FlashCards>> {
    private AsyncTaskDelegateList delegate;
    private FlashCardsDatabase database;
    private ArrayList<FlashCards> flashCardsList;

    public void setDelegate(AsyncTaskDelegateList delegate) {
        this.delegate = delegate;
    }

    public void setDatabase(FlashCardsDatabase database) {
        this.database = database;
    }


    @Override
    protected ArrayList<FlashCards> doInBackground(FlashCards... flashCards) {
        //creates a new arraylist with all cards from database
        flashCardsList = new ArrayList<>(database.flashCardsDao().getCards());
        return flashCardsList;
    }

    @Override
    protected void onPostExecute(ArrayList<FlashCards> result) {
        //returns the arraylist of cards back to the activity
        delegate.handleTaskResult(result);
    }
}
