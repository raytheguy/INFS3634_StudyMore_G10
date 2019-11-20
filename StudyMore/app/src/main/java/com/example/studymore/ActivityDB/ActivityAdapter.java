package com.example.studymore.ActivityDB;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studymore.EncyclopediaActivity;
import com.example.studymore.FactsActivity;
import com.example.studymore.FlashCardActivity;
import com.example.studymore.R;
import com.example.studymore.VideoActivity;

import java.util.ArrayList;

public class ActivityAdapter  extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {
    // class variable that holds the data that we want to adapt
    private ArrayList<Activity> activitiesToAdapt;
    Intent intent;

    public void setData(ArrayList<Activity> activitiesToAdapt) {
        // This is basically a Setter that we use to give data to the adapter
        this.activitiesToAdapt = activitiesToAdapt;
        }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // First create a View from the layout file. It'll probably be a ViewGroup like
        // ConstraintLayout that contains more Views inside it.
        // This view now represents your entire one item.
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.mainpage_featurelist, parent, false);

        // Then create an instance of your custom ViewHolder with the View you got from inflating
        // the layout.
        ActivityViewHolder articleViewHolder = new ActivityViewHolder(view);
        return articleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        // Compare what we have in this method, to what we used to have in MainActivity

        // 'position' is the index of the ViewHolder currently being bound (note VIEWHOLDER). So
        // if position is 0, then we are binding the first ViewHolder in the list. This means the
        // corresponding data object will be at index 0 of our data ArrayList.
        final Activity activityAtPosition = activitiesToAdapt.get(position);

        holder.nameTextView.setText(activityAtPosition.getActivityName());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                if(activityAtPosition.getActivityName().equals("Cat and Dog Facts")){
                    intent = new Intent(context, FactsActivity.class);}
                else if(activityAtPosition.getActivityName().equals("Cat and Dog Breeds")){
                    intent = new Intent(context, EncyclopediaActivity.class);}
                else if(activityAtPosition.getActivityName().equals("Flash Cards")){
                    intent = new Intent(context, FlashCardActivity.class);}
//                else if(activityAtPosition.getActivityName()=="Quiz"){
//                    intent = new Intent(context, QuizActivity.class);}
                else if(activityAtPosition.getActivityName().equals("Learning Videos")){
                    intent = new Intent(context, VideoActivity.class);}
//                else if(activityAtPosition.getActivityName()=="Quiz Scores"){
//                    intent = new Intent(context, QuizScoreActivity.class);}
                else {
                    intent = new Intent(context, FlashCardActivity.class);
                }
                context.startActivity(intent);
            }
        });

        holder.iconImageView.setImageResource(activityAtPosition.getImageDrawableId());
    }

    @Override
    public int getItemCount() {
        return activitiesToAdapt.size();
    }

    // ViewHolder represents one item, but doesn't have data when it's first constructed.
    // We assign the data in onBindViewHolder.
    public static class ActivityViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView nameTextView;
        public ImageView iconImageView;

        // This constructor is used in onCreateViewHolder
        public ActivityViewHolder(View v) {
            super(v);  // runs the constructor for the ViewHolder superclass
            view = v;
            nameTextView = v.findViewById(R.id.featureName);
            iconImageView = v.findViewById(R.id.featureIcon);
        }
    }
}