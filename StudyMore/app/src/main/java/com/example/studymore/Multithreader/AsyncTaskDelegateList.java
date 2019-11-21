package com.example.studymore.Multithreader;

import com.example.studymore.ui.FlashCards.FlashCards;

import java.util.ArrayList;

//AsyncTask Delegate for ArrayList of FlashCards
public interface AsyncTaskDelegateList {
    void handleTaskResult(ArrayList<FlashCards> result);
}
