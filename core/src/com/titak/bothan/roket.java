package com.titak.bothan;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

/**
 * Created by gamew on 24.12.2016.
 */

public class roket extends obje {
    Sprite spr;
    Circle circ;

    roket(float x, float y) {
        super(x, y);
        img = AssetLoader.rocket;
        spr = new Sprite(img);
        spr.setPosition(x,y);
        circ = new Circle(x,y,img.getWidth()/2);

        Game.objeler.add(this);

        speed = 30;
    }

    @Override
    void render(SpriteBatch batch){spr.draw(batch);}

    void update(){
        x -= speed;
        spr.setPosition(x,y);
        circ.setPosition(x,y);
    }

}
