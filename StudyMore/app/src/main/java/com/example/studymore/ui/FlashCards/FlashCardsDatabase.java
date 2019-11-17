package com.example.studymore.ui.FlashCards;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FlashCards.class}, version = 1)  // Replace "Book.class" with whatever your Book entity class is.
public abstract class FlashCardsDatabase extends RoomDatabase {
    public abstract FlashCardsDao flashCardsDao();          // Replace BookDao with whatever you name your DAO

    private static FlashCardsDatabase instance;
    public static FlashCardsDatabase getInstance(Context context) {

        if(instance == null) {
            instance = Room.databaseBuilder(context, FlashCardsDatabase.class, "fcDb")
                    .allowMainThreadQueries()   // <== IMPORTANT TO NOTE:
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