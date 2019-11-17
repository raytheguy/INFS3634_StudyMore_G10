package com.example.studymore.ui.FlashCards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.example.studymore.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.UUID;

public class FlashCardsAdd extends AppCompatActivity {
    private List<FlashCards> bookToPut;
    private EditText frontText;
    private EditText backText;
    private Button addFlashBtn;
    private FlashCardsDatabase fcdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashcard_addnew_layout);

        //link layout to variables
        frontText = findViewById(R.id.flash_front_editText);
        backText = findViewById(R.id.flash_back_editText);
        addFlashBtn = findViewById(R.id.addFlashButton);

        //onClickListener
        addFlashBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToDatabase(view);
            }
        });

    }

    //method to add to database
    public void addToDatabase(View view){
        //get what the user has entered
        fcdb = FlashCardsDatabase.getInstance(getApplicationContext());
        String front = frontText.getText().toString();
        String back = backText.getText().toString();
        UUID randomUUID = UUID.randomUUID();

        if (front != null && back != null && front != "" && back != ""){
            fcdb.flashCardsDao().insert(new FlashCards(randomUUID.toString(), front, back));
            //if successful, display this message
            Snackbar.make(view, "Added Flashcard Successfully! Going back to Flashcards!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            //if successful, go back to flashcards  recycle view activity
            Intent intentPlusButton = new Intent(view.getContext(), FlashCards.class);
            startActivity(intentPlusButton);
        }
        else{
            Snackbar.make(view, "Error! Make sure all fields are filled in!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

}
