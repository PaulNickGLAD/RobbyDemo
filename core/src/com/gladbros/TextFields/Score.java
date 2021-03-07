package com.gladbros.TextFields;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gladbros.TextFields.*;

public class Score {
    static BitmapFont font; //
    static String txt = "SCORE";
    static int currentScore = 0;

    public Score() {
        //Set color of font -cyan
        font = new BitmapFont();
        font.setColor(Color.RED);
    }

    public void render(SpriteBatch batch) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font,txt);
        GlyphLayout value = new GlyphLayout();
        value.setText(font,printScore());
        font.draw(batch,glyphLayout,710,80);
        font.draw(batch,value,725,60);

    }

    public void update(SpriteBatch batch) { }

    public String printScore(){
        currentScore = Timer.seconds *50 +Timer.minutes*60*50;
        return ""+currentScore;
    }
}
