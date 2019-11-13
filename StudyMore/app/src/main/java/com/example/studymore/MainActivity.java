package com.example.studymore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public ImageButton settingsButton;

    //create all the
    //recyclerview unsuitable for this situation
    //everything is static
    public TextView text1;
    public ConstraintLayout box1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingsButton = findViewById(R.id.settingsClog);
        settingsButton.setImageResource(R.drawable.settingsclog);

        //set Box 1
        box1 = findViewById(R.id.featureone);
        text1 = box1.findViewById(R.id.featureName);
        text1.setText("Encyclopedia");

        //set Box 2

        //set Box 3

        //set Box 4

        //set Box 5

        //set Box 6

    }


}
