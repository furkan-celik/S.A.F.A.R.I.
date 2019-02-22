package com.titak.bothan;

import com.badlogic.gdx.math.Circle;

/**
 * Created by gamew on 30.12.2016.
 */

public class bomb extends powerUp {

    bomb(float x, float y) {
        super(x, y);
        img = AssetLoader.pUps[2];
        circ = new Circle(x,y,img.getWidth()/2);
        circ.setPosition(x,y);

        Game.powerups.add(this);
    }

    void run(){
        Game.objeler.clear();
        Game.objeler.add(Game.oyuncu);
    }

}
