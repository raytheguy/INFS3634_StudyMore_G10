package com.example.studymore;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//activity is for settings such as reset quiz scores and delete flash cards
public class SettingsActivity extends AppCompatActivity {
    Button deleteFlashCards;
    Button deleteScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //link deleteFlashCards to layout
        deleteFlashCards = findViewById(R.id.flashCardDeleteBtn);
        deleteScores = findViewById(R.id.scoreDeleteBtn);

    }
}
