package com.titak.bothan;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

/**
 * Created by gamew on 25.12.2016.
 */

public class fire extends powerUp {
    Sprite spr;

    fire(float x, float y, int type) {
        super(x, y);
        img = AssetLoader.pUps[type];
        spr = new Sprite(img);
        spr.setPosition(x,y);
        circ = new Circle(x,y,img.getWidth()/3);
        circ.setPosition(x,y);

        Game.powerups.add(this);
    }

    @Override
    void render(SpriteBatch batch) { spr.draw(batch); }

    void run(){
        Game.oyuncu.weapon = 1;
    }

}
