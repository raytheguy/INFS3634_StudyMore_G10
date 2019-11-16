package com.example.studymore;

import android.os.Bundle;

import com.example.studymore.ui.FlashCards.FlashCards;
import com.example.studymore.ui.FlashCards.FlashCardsRecycleViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

public class FlashCardActivity extends AppCompatActivity {

    ArrayList<FlashCards> newFlash = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card);

        //add samples
        addSample();
        initRecyclerView();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This Button is supposed to let you add flash cards!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addSample(){
        newFlash.add(new FlashCards(1, "Something 1", "Answer 1"));
        newFlash.add(new FlashCards(2, "Something 2", "Answer 2"));
        newFlash.add(new FlashCards(3, "Something 3", "Answer 3"));
        newFlash.add(new FlashCards(4, "Something 4", "Answer 4"));
        newFlash.add(new FlashCards(5, "Something 5", "Answer 5"));
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
