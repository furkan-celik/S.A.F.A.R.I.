package com.titak.bothan;

import com.badlogic.gdx.*;
import com.badlogic.gdx.math.Circle;

/**
 * Created by gamew on 24.12.2016.
 */

public class bor extends powerUp {

    bor(float x, float y) {
        super(x, y);
        img = AssetLoader.bor;

        circ = new Circle(x,y,img.getHeight()/2);
        circ.setPosition(x,y);

        Game.powerups.add(this);
    }

    void run(){
        player.bor = 2000;
    }

}
