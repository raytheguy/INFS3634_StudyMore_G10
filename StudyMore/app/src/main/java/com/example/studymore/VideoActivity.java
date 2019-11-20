package com.example.studymore;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Vector;

import com.example.studymore.ui.Cat.CatFragment;
import com.example.studymore.ui.Dog.DogFragment;
import com.example.studymore.ui.Video.CatVideoFragment;
import com.example.studymore.ui.Video.CatVideoTypeFragment;
import com.example.studymore.ui.Video.DogVideoFragment;
import com.example.studymore.ui.Video.DogVideoTypeFragment;
import com.example.studymore.ui.Video.VideoAdapter;
import com.example.studymore.ui.Video.YoutubeVideos;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VideoActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Vector<YoutubeVideos> youtubeVideos = new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos_new);
//
//        recyclerView = (RecyclerView) findViewById(R.id.recycleVideos);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager( new LinearLayoutManager(this));
//
//        youtubeVideos.add( new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/yxsP0KyOlgs\" frameborder=\"0\" allowfullscreen></iframe>") );
//        youtubeVideos.add( new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/s6p4FYveKKk\" frameborder=\"0\" allowfullscreen></iframe>") );
//        youtubeVideos.add( new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/5EEkSU0Ti3k\" frameborder=\"0\" allowfullscreen></iframe>") );
//        youtubeVideos.add( new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/1d4vjZnlybw\" frameborder=\"0\" allowfullscreen></iframe>") );
//        youtubeVideos.add( new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ZaqrTb54Xmc\" frameborder=\"0\" allowfullscreen></iframe>") );
//
//        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);
//
//        recyclerView.setAdapter(videoAdapter);
        //have a default fragment (when app loads)

        //create the bottom navigation bar
        BottomNavigationView bottomNavView = findViewById(R.id.nav_view_video);
        bottomNavView.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_cont_main_video,
                    new CatVideoTypeFragment()).commit();
        }

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.navigation_cats:
                            selectedFragment = new CatVideoTypeFragment();
                            break;
                        case R.id.navigation_dogs:
                            selectedFragment = new DogVideoTypeFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_cont_main_video,
                            selectedFragment).commit();
                    return true;
                }
            };
}
