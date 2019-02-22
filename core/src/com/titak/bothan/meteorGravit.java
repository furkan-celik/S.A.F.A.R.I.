package com.titak.bothan;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

/**
 * Created by gamew on 24.12.2016.
 */

public class meteorGravit extends obje {
    Sprite spr;
    Circle circ2;

    meteorGravit(float x, float y, int rand) {
        super(x, y);
        img = AssetLoader.meteorsGravit[rand];
        spr = new Sprite(img);
        spr.setPosition(x,y);

        circ = new Circle(x,y,img.getWidth()/2);
        circ.setPosition(x,y);

        circ2 = new Circle(x,y,img.getWidth()*2);
        circ2.setPosition(x,y);

        Game.objeler.add(this);

        speed = 1;
    }

    @Override
    void render(SpriteBatch batch) {spr.draw(batch);}

    void update(){
        spr.rotate(5);
        x -= speed;

        spr.setPosition(x,y);
        circ.setPosition(x,y);
        circ2.setPosition(x,y);
    }

}
