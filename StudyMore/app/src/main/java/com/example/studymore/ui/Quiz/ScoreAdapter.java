package com.example.studymore.ui.Quiz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studymore.R;

import java.util.ArrayList;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>{
        private ArrayList<QuizResult> quizResultsToAdapt;

        public void setData(ArrayList<QuizResult> quizResultsToAdapt) {
            this.quizResultsToAdapt = quizResultsToAdapt;
        }

        @NonNull
        @Override
        public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view =
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.score_display, parent, false);

            ScoreViewHolder scoreViewHolder = new ScoreViewHolder(view);
            return scoreViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ScoreAdapter.ScoreViewHolder holder, int position) {

            final QuizResult scoreAtPosition = quizResultsToAdapt.get(position);

            holder.attemptNumber.setText("Attempt: "+scoreAtPosition.getAttemptNumber());
            holder.score.setText(scoreAtPosition.getScore()+"/10");

        }

        @Override
        public int getItemCount() {
            return quizResultsToAdapt.size();
        }

        // ViewHolder represents one item, but doesn't have data when it's first constructed.
        // We assign the data in onBindViewHolder.
        public static class ScoreViewHolder extends RecyclerView.ViewHolder {
            public View view;
            public TextView attemptNumber;
            public TextView score;

            // This constructor is used in onCreateViewHolder
            public ScoreViewHolder(View v) {
                super(v);  // runs the constructor for the ViewHolder superclass
                view = v;
                attemptNumber = v.findViewById(R.id.attempNumber);
                score = v.findViewById(R.id.score);
            }
        }
    }
