package com.example.studymore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.studymore.ui.FlashCards.FlashCards;
import com.example.studymore.ui.FlashCards.FlashCardsAdd;
import com.example.studymore.ui.FlashCards.FlashCardsDatabase;
import com.example.studymore.ui.FlashCards.FlashCardsRecycleViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FlashCardActivity extends AppCompatActivity {

    ArrayList<FlashCards> newFlash = new ArrayList<>();
    private FlashCardsDatabase database;
    private TextView noOfFlashCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card);

        //create Database
        Context context = getApplicationContext();
        database = FlashCardsDatabase.getInstance(context);
        newFlash = new ArrayList<FlashCards>(database.flashCardsDao().getCards());

        //add samples
        addSample();
        initRecyclerView();

        //set size of FlashCard size and set to textView
        noOfFlashCards = findViewById(R.id.noOfFlashCardsTextView);
        noOfFlashCards.setText("Number of Flash Cards: " + newFlash.size());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This Button is supposed to let you add flash cards!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intentPlusButton = new Intent(view.getContext(), FlashCardsAdd.class);
                startActivity(intentPlusButton);
            }
        });

    }

    public void addSample(){
        newFlash.add(new FlashCards(UUID.randomUUID().toString(), "Something 1", "Answer 1"));
        newFlash.add(new FlashCards(UUID.randomUUID().toString(), "Something 2", "Answer 2"));
        newFlash.add(new FlashCards(UUID.randomUUID().toString(), "Something 3", "Answer 3"));
        newFlash.add(new FlashCards(UUID.randomUUID().toString(), "Something 4", "Answer 4"));
        newFlash.add(new FlashCards(UUID.randomUUID().toString(), "Something 5", "Answer 5"));
    }

    public void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewFlash);
        recyclerView.setLayoutManager(layoutManager);
        FlashCardsRecycleViewAdapter adapter = new FlashCardsRecycleViewAdapter(this, newFlash);
        recyclerView.setAdapter(adapter);
        System.out.println("Something has been made");
    }

}
