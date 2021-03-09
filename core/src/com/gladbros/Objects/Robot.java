package com.gladbros.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Robot {
    Texture texture;
    public static Vector2 pos;

    public Robot(){
        texture = new Texture("Robby.jpg");
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
