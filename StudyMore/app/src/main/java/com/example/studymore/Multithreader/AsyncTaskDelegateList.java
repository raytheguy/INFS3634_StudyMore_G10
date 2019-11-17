package com.example.studymore.Multithreader;

import com.example.studymore.ui.FlashCards.FlashCards;

import java.util.ArrayList;

public interface AsyncTaskDelegateList {
    void handleTaskResult(ArrayList<FlashCards> result);
}
