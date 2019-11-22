package com.example.studymore.ui.Quiz;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {QuizResult.class}, version = 1)
public abstract class ScoreDatabase extends RoomDatabase {
    public abstract QuizScoreDao quizScoreDao();

    private static ScoreDatabase instance;
    public static ScoreDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context, ScoreDatabase.class, "nytDb")
//                    .allowMainThreadQueries()   // <== IMPORTANT TO NOTE:
                    //     This is NOT correct to do in a completed app.
                    //     Next week we will fix it, but for now this
                    //     line is necessary for the app to work.
                    //     This line will basically allow the database
                    //     queries to freeze the app.
                    .build();
        }
        return instance;
    }



}
