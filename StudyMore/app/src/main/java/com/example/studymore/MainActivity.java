package com.example.studymore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    public ImageButton settingsButton;

    //create all the boxes with the features
    //recyclerView will be inefficient in this situation as
    //it will make it too complicated i.e. need a switch statement in the recyclerView
    //to see which ID has been clicked, to see which explicit intent to make (which fragment/activity)
    //also need a database with the imageIds, name of the feature etc.
    //everything is static

    //box 1
    public TextView text1;
    public ImageView imageView1;
    public ConstraintLayout box1;
    //box 2
    public TextView text2;
    public ImageView imageView2;
    public ConstraintLayout box2;

    //box 3
    public TextView text3;
    public ImageView imageView3;
    public ConstraintLayout box3;

    //box 4
    public TextView text4;
    public ImageView imageView4;
    public ConstraintLayout box4;

    //box 5
    public TextView text5;
    public ImageView imageView5;
    public ConstraintLayout box5;

    //box 6
    public TextView text6;
    public ImageView imageView6;
    public ConstraintLayout box6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingsButton = findViewById(R.id.settingsClog);
        settingsButton.setImageResource(R.drawable.settingsclog);

        //set Box 1
        //Daily Cat Facts
        //API: https://app.swaggerhub.com/apis-docs/whiterabbit8/meowfacts/1.0.0#/public/queryFacts
        //https://meowfacts.herokuapp.com/
        box1 = findViewById(R.id.featureone);
        text1 = box1.findViewById(R.id.featureName);
        text1.setText("Cat and Dog Facts");
        //onClick Listener when the 'holder' or constraintLayout is clicked
        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View myView) {
                Intent intentBtn = new Intent(myView.getContext(), FactsActivity.class);
                startActivity(intentBtn);
            }
        });


        //set Box 2
        //Encyclopedia with Animals and Their Facts (Have search function is API supports)
        box2 = findViewById(R.id.featuretwo);
        text2 = box2.findViewById(R.id.featureName);
        text2.setText("Encyclopedia");
        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View myView) {
                Intent intentBtn = new Intent(myView.getContext(), Encyclopedia.class);
                startActivity(intentBtn);
            }
        });

        //set Box 3
        //Flash cards that display questions and answers
        box3 = findViewById(R.id.featurethree);
        text3 = box3.findViewById(R.id.featureName);
        text3.setText("Flash Cards");

        //set Box 4
        box4 = findViewById(R.id.featurefour);
        text4 = box4.findViewById(R.id.featureName);
        text4.setText("Quiz");

        //set Box 5
        box5 = findViewById(R.id.featurefour);
        text5 = box5.findViewById(R.id.featureName);
        text5.setText("Videos");

        //set Box 6
        box6 = findViewById(R.id.featurefive);
        text6 = box6.findViewById(R.id.featureName);
        text6.setText("Quiz Scores");


    }


}
