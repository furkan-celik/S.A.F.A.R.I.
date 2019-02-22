package com.titak.bothan;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by gamew on 24.12.2016.
 */

public class player extends obje {
    public static int lvl=0,bor=2000,coin=0, weapon=0,puan=0,sayacw=0;
    private int sayac=0,contType;
    public Circle circ;
    Sprite spr;

    player(float x, float y, int contType, int type) {
        super(x, y);
        this.contType = contType;
        img = AssetLoader.player[type];
        spr = new Sprite(img);
        spr.setPosition(x,y);

        circ = new Circle(x,y,img.getHeight()/2);
        circ.setPosition(x,y);

        speed=10 * ((type / 2) + 1);
    }

    @Override
    void render(SpriteBatch batch){spr.draw(batch);}

    void update(){

        if(bor == 0){
            Game.objeler.remove(this);
        }
        bor--;

        x+=speed;
        switch (contType){
            case 0:
                /*if(Gdx.input.isKeyPressed(Input.Keys.UP)){
                    if(y < (1080 - img.getHeight()))
                        y+=10;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                    if(y > 0)
                        y-=10;
                }*/
                /*if(Gdx.input.isTouched()){
                    if(Gdx.input.getX() > 1165 && Gdx.input.getX() < 1250){
                        if(Gdx.input.getY() > 475 && Gdx.input.getY() < 580 && y < (1080 - img.getHeight())){
                            y+=speed;
                        }
                        if(Gdx.input.getY() >= 580 && Gdx.input.getY() < 685 && y > 0){
                            y-=speed;
                        }
                    }
                }*/
                break;
            case 1:
                if(y < (980 - Gdx.input.getY())){
                    y+=10;
                }
                if(y > (720 - Gdx.input.getY())){
                    y-=10;
                }
                break;
        }

        /*if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            System.out.println(Gdx.input.getX());
        }*/

        if(sayac < 30){
            sayac++;
        }

        if(weapon == 1 && sayac >= 30){
            new lazer(x + img.getWidth()/2,y + img.getHeight() / 2 - 10,x + 1920, y, 0);
            sayac = 0;
        }
        if(weapon == 1){
            sayacw++;
            if(sayacw > 500){
                weapon = 0;
                sayacw = 0;
            }
        }

        spr.setPosition(x,y);
        circ.setPosition(x,y);

    }

}
