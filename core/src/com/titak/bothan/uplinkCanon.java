package com.titak.bothan;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by gamew on 24.12.2016.
 */

public class uplinkCanon extends obje {
    Rectangle rect;

    uplinkCanon(float x, float y) {
        super(x, y);
        img = AssetLoader.uplink;
        rect = new Rectangle(x,y,img.getWidth(),img.getHeight());
        rect.setPosition(x,y);

        Game.objeler.add(this);
    }

    void update(){
        if(x > (Game.oyuncu.x - 50))
            x-=(10 * 3);
        else
            x+=10;
    }
}
