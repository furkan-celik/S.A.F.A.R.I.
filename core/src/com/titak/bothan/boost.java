package com.titak.bothan;

import com.badlogic.gdx.math.Circle;

/**
 * Created by gamew on 29.12.2016.
 */

public class boost extends powerUp {

    boost(float x, float y) {
        super(x, y);
        img = AssetLoader.pUps[1];
        circ = new Circle(x,y,img.getWidth()/2);
        circ.setPosition(x,y);

        Game.powerups.add(this);
    }

    void run(){
        Game.boostMode = true;
        Game.invisibility = true;
        System.out.println("hız");
        Game.oyuncu.bor += 400;
        Game.oyuncu.speed = 70;
    }
}
