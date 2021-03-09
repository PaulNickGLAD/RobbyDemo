package com.gladbros.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.gladbros.HangarScreen;

public class Robot {
    Texture texture;
    public static Vector2 pos;

    public Robot(){
        switch (HangarScreen.choice){
            case 1: {texture = new Texture("Robby.jpg");}
            break;
            case 2: {texture = new Texture("modelRoboticI.jpg");}
            break;
            case 3: {texture = new Texture("modelBattleship.jpg");}
            break;
        }
        pos = new Vector2(20,270);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, pos.x, pos.y);
    }

    public void update(SpriteBatch batch)
    {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (pos.y< 360){ pos.y+=5; }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (pos.y>20){ pos.y-=5; }
        }
    }
}
