package com.example.studymore.ui.Quiz;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface QuizScoreDao {
    @Query("SELECT * FROM QuizResult ORDER BY attemptNumber")
    List<QuizResult> getResults();

    //insert updated version if it exists already
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(QuizResult quizResult);

    //method to delete all quiz results
    @Query("DELETE FROM QuizResult")
    void nukeTable();
}
