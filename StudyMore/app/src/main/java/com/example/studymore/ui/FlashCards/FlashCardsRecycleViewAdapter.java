package com.example.studymore.ui.FlashCards;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.studymore.R;
import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class FlashCardsRecycleViewAdapter extends RecyclerView.Adapter<FlashCardsRecycleViewAdapter.ViewHolder>{

    //Variables to test recycler
    private ArrayList<FlashCards> flashContent;
    private Context mContext;

    public FlashCardsRecycleViewAdapter(Context context, ArrayList<FlashCards> flashContent) {
        this.mContext = context;
        this.flashContent = flashContent;
        System.out.println("FlashCardsRecycleViewAdapter has been called");
        System.out.println("Size of flash content is + " + this.flashContent.size());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.flashcard_recycle_layout, parent, false);
        FlashCardsRecycleViewAdapter.ViewHolder holder = new FlashCardsRecycleViewAdapter.ViewHolder(myView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.flashCardTextView.setText(flashContent.get(position).getFront());
        System.out.println("On bind view holder is called");
        final int cardIdToPut = flashContent.get(position).getCardId();
        final String backText = flashContent.get(position).getBack();
        holder.flashCardConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //need to either go to another activity or try to change text

                onButtonShowPopupWindowClick(v, backText);
            }
        });
    }

    @Override
    public int getItemCount() {
        System.out.println("The size is " + flashContent.size());
        return flashContent.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView flashCardTextView;
        ConstraintLayout flashCardConstraintLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.flashCardTextView = itemView.findViewById(R.id.flashcardTextView);
            this.flashCardConstraintLayout = itemView.findViewById(R.id.flashCardConstraintLayout);
        }
    }

    public void onButtonShowPopupWindowClick(View view, String backOfCard) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        System.out.println("The text passed is " + backOfCard);
        TextView popUpText = popupView.findViewById(R.id.popUpTextView);
        popUpText.setText(backOfCard);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window token
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

}
