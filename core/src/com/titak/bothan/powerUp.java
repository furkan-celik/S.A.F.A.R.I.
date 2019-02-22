package com.titak.bothan;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

/**
 * Created by gamew on 24.12.2016.
 */

public class powerUp {
    float x,y;
    Texture img;
    public Circle circ;

    powerUp(float x, float y){
        this.x = x;
        this.y = y;
    }

    void render(SpriteBatch batch) {batch.draw(img,x,y);}

    void update() {

    }

    void run(){

    }
}
