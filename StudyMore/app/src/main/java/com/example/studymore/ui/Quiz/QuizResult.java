package com.example.studymore.ui.Quiz;

public class QuizResult {
    private int attemptNumber;
    private int score;

    public QuizResult(){

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
