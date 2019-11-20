package com.example.studymore;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studymore.ActivityDB.ActivityAdapter;
import com.example.studymore.ActivityDB.ActivityDatabase;

public class MainActivity extends AppCompatActivity {

    public ImageButton settingsButton;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    SharedPreferences prefMain = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.mainConstraint);

        //open an information box if it is the first time opened
        prefMain = getApplicationContext().getSharedPreferences("com.example.studymore.main", 0); // 0 - for private mode
        //if it is the first time, then add a generic flash card
        if (prefMain.getBoolean("firstrunMain", true)) {
            // Do first run stuff here then set 'firstrun' as false
            //Open the Information Box
            showCustomPopupMenu();
            // using the following line to edit/commit prefs (no longer first time, no longer add)
            prefMain.edit().putBoolean("firstrunMain", false).commit();
        }
        //if it is isn't the first time, then continue below

        //set the settings button
        settingsButton = findViewById(R.id.settingsClog);

        //onClick Listener for settings button
        //onClickListener to get new Fact
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View myView) {
                Intent intentBtn = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intentBtn);
            }
        });

        recyclerView = findViewById(R.id.rv_activity);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ActivityAdapter activityAdapter = new ActivityAdapter();

        activityAdapter.setData(ActivityDatabase.getAllActivity());
        recyclerView.setAdapter(activityAdapter);


    }

    private void showCustomPopupMenu()
    {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("First Time");
        builder.setMessage("Welcome to StudyMore - Cats and Dogs! Learn about cats and dogs then test yourself!");
        // add a button
        builder.setPositiveButton("CONTINUE", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
