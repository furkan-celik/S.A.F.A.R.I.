package com.titak.bothan;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

/**
 * Created by gamew on 24.12.2016.
 */

public class coin extends powerUp {
    int x,y,sayac;
    Sprite spr;

    coin(float x, float y) {
        super(x, y);
        img = AssetLoader.coin[0];
        spr = new Sprite(img);
        //spr.setPosition(x,y);
        circ = new Circle(x,y,img.getHeight()/2);
        circ.setPosition(x,y);

        Game.powerups.add(this);
    }

    /*@Override
    void render(SpriteBatch batch) {spr.draw(batch);}
*/
    void update(){
        sayac++;
        if(sayac <= 10){
            img = AssetLoader.coin[0];
            //spr.setTexture(img);
            //spr.setPosition(x,y);
        }else if(10 < sayac && sayac <= 20){
            img = AssetLoader.coin[1];
            //spr.setTexture(img);
            //spr.setPosition(x,y);
        }else if(20 < sayac && sayac <= 30){
            img = AssetLoader.coin[2];
            //spr.setTexture(img);
            //spr.setPosition(x,y);
        }else if(30 < sayac && sayac <= 40){
            img = AssetLoader.coin[3];
            //spr.setTexture(img);
            //spr.setPosition(x,y);
            sayac = 0;
        }
    }

    void run(){
        player.coin++;
    }

}
