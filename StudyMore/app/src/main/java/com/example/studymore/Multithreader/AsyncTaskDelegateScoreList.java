package com.example.studymore.Multithreader;

import com.example.studymore.ui.Quiz.QuizResult;

import java.util.ArrayList;

public interface AsyncTaskDelegateScoreList {
    void handleTaskResult(ArrayList<QuizResult> result);
}
