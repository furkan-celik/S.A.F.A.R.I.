package com.titak.bothan;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

/**
 * Created by gamew on 25.12.2016.
 */

public class lazer extends obje {
    float aci;
    int type;
    Sprite spr;

    lazer(float x, float y, float hedefX, float hedefY, int type) {
        super(x, y);
        this.type = type;
        img = AssetLoader.lasers[type];
        spr = new Sprite(img);
        spr.setPosition(x,y);
        circ = new Circle(x,y,img.getWidth()/2);
        circ.setPosition(x,y);
        aci = (float) Math.atan2(hedefY - y, hedefX - x);

        Game.objeler.add(this);

        speed=20;
    }

    @Override
    void render(SpriteBatch batch) { spr.draw(batch); }

    void update(){
        switch (type){
            case 0:
                x += Math.cos(Math.toRadians(aci))*speed;
                y += Math.sin(Math.toRadians(aci))*speed;
                break;
            case 1:
                x -= Math.cos(Math.toRadians(aci))*speed;
                y -= Math.sin(Math.toRadians(aci))*speed;
                break;
        }
        spr.setPosition(x,y);
        circ.setPosition(x,y);
    }

}
