package com.example.studymore.ui.FlashCards;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import static android.icu.text.MessagePattern.ArgType.SELECT;

@androidx.room.Dao
public interface FlashCardsDao {
    //get all the flashcards back
    @Query("SELECT * FROM FlashCards")
    List<FlashCards> getCards();

    //insert updated version if it exists already
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(FlashCards flashCards);
}

