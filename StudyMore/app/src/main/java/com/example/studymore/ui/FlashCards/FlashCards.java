package com.example.studymore.ui.FlashCards;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FlashCards {

    //maybe change cardId to UUID to reduce chance of conflict
    @PrimaryKey
    int cardId;
    String front;
    String back;

    public int getCardId() {
        return cardId;
    }

    public FlashCards(int cardId, String front, String back) {
        this.cardId = cardId;
        this.front = front;
        this.back = back;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }
}
