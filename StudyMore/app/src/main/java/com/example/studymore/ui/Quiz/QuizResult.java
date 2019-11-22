package com.example.studymore.ui.Quiz;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class QuizResult {
    @PrimaryKey
    @NonNull
    private int attemptNumber;
    private int score;

    @Ignore
    public QuizResult() {
    }

    public QuizResult(int attemptNumber, int score){
        this.attemptNumber = attemptNumber;
        this.score = score;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
