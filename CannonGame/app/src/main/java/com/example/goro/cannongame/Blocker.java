package com.example.goro.cannongame;

/**
 * Created by Goro on 08.04.2017.
 */

public class Blocker extends GameElement {
    private int missPenalty;


    public Blocker(CannonView view, int color, int missPenalty, int x, int y, int width, int lenght, float velocityY) {
        super(view, color, CannonView.BLOCKER_SOUND_ID, x, y, width, lenght, velocityY);
        this.missPenalty = missPenalty;
    }

    public int getMissPenalty(){
        return missPenalty;
    }
}
