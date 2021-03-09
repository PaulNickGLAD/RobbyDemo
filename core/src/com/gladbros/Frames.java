package com.gladbros;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Frames {

    Frames(){
        txTop = new Texture("top.jpg");
        txBottom = new Texture("bottom.jpg");
        txLeft = new Texture("left.jpg");
        txRight = new Texture("right.jpg");
        posTop = new Vector2(0,435);
        posBottom = new Vector2(0,0);
        posLeft = new Vector2(0,15);
        posRight = new Vector2(785,15);
    }

    Texture txTop,txBottom, txLeft, txRight;
    Vector2 posTop, posBottom, posLeft, posRight;

    public void render(SpriteBatch batch) {
        batch.draw(txTop,posTop.x,posTop.y);
        batch.draw(txBottom,posBottom.x,posBottom.y);
        batch.draw(txLeft,posLeft.x,posLeft.y);
        batch.draw(txRight,posRight.x,posRight.y);
    }
}
