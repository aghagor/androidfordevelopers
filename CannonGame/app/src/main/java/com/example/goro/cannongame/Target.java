package com.example.goro.cannongame;

/**
 * Created by Goro on 08.04.2017.
 */

public class Target extends GameElement {
    private int hitReward;

    public Target(CannonView view, int color,  int x, int y, int width, int lenght, float velocityY, int hitReward) {
        super(view, color, CannonView.TARGET_SOUND_ID, x, y, width, lenght, velocityY);
        this.hitReward = hitReward;
    }

    public int getHitReward() {
        return hitReward;
    }
}
