package com.titak.bothan;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

/**
 * Created by gamew on 25.12.2016.
 */

public class enemy extends obje {
    Sprite spr;
    float aci;
    int sayac=0,enlvl;

    enemy(float x, float y, int enlvl) {
        super(x, y);
        this.enlvl = enlvl;
        img = AssetLoader.enemys[enlvl];
        spr = new Sprite(img);
        spr.setPosition(x,y);
        circ = new Circle(x,y,img.getWidth()/2);
        circ.setPosition(x,y);
        aci = (float) Math.atan2(Game.oyuncu.y - y, Game.oyuncu.x - x);

        Game.objeler.add(this);

        speed=10;
    }

    @Override
    void render(SpriteBatch batch){ spr.draw(batch); }

    void update(){
        aci = (float) Math.atan2(Game.oyuncu.y - y, Game.oyuncu.x - x);
        x -= Math.cos(Math.toRadians(aci))*speed;
        y -= Math.sin(Math.toRadians(aci))*speed;
        switch (enlvl){
            case 1:
                sayac++;
                if(sayac>40){
                    new lazer(x - img.getWidth() - 20,y + img.getHeight() / 2, x - 1920, y,1);
                    System.out.println("test");
                    sayac = 0;
                }
                break;
            case 2:
                sayac++;
                if(sayac>20){
                    new lazer(x - img.getWidth() - 20,y + img.getHeight() / 2, x - 1920, y,1);
                    System.out.println("test");
                    sayac = 0;
                }
                break;
            case 3:
                sayac++;
                if(sayac>10){
                    new lazer(x - img.getWidth() - 20,y + img.getHeight() / 2, x - 1920, y,1);
                    System.out.println("test");
                    sayac = 0;
                }
                break;
        }
        spr.setPosition(x,y);
        circ.setPosition(x,y);
    }

}
