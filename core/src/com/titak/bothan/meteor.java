package com.titak.bothan;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

/**
 * Created by gamew on 24.12.2016.
 */

public class meteor extends obje {
    public Circle circ;
    Sprite spr;
    float aci, hedefX, hedefY;

    meteor(float x, float y,int rand) {
        super(x, y);
        this.hedefX = hedefX; this.hedefY = hedefY;
        img = AssetLoader.meteors[rand];
        /*if(rand == 1){
            new meteor((float) Game.oyuncu.x + 1950, (float) Math.random() * 1080, Game.oyuncu.x, Game.oyuncu.y);
        }*/

        spr = new Sprite(img);
        spr.setPosition(x,y);
        circ = new Circle(x,y,img.getHeight()/2);

        Game.objeler.add(this);

        speed=1;
    }

    @Override
    void render(SpriteBatch batch) {spr.draw(batch);}

    void update(){
        spr.rotate(5);
        x -= speed;
        //y += Math.sin(Math.toRadians(aci))*speed;
        spr.setPosition(x,y);
        circ.setPosition(x,y);
    }

}
