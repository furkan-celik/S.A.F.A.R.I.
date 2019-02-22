package com.titak.bothan;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

/**
 * Created by gamew on 24.12.2016.
 */

public class obje{
    float x,y;
    Texture img;
    Circle circ;
    int speed;

    obje(float x, float y){
        this.x = x;
        this.y = y;
    }

    void render(SpriteBatch batch) {batch.draw(img,x,y);}

    void update(){

    }
}
