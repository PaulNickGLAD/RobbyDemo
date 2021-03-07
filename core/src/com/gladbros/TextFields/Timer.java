package com.gladbros.TextFields;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.io.IOException;

public class Timer  {
    static BitmapFont font; //
    static String txt = "TIME:";
    public static int miliseconds = 0;
    public static int seconds = 0;
    static int minutes = 0;

    public Timer() {
        //Set color of font -cyan
        font = new BitmapFont();
        font.setColor(Color.RED);
    }


    public void render(SpriteBatch batch) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font,txt);
        GlyphLayout value = new GlyphLayout();
        value.setText(font,printTime());
        font.draw(batch,glyphLayout,710,430);
        font.draw(batch,value,710,410);

    }

    public void update(SpriteBatch batch) { }

    public String printTime(){
        String milisecondsTime = (miliseconds<10)?("0" + miliseconds):(""+miliseconds);
        String secondsTime = (seconds<10)?("0" + seconds):(""+seconds);
        String minutesTime = (minutes<10)?("0" + minutes):(""+minutes);
        miliseconds++;
        {
            if(miliseconds==60){seconds++; miliseconds=0;}
            if (seconds==60){minutes++; seconds=0;}
        }
        return minutesTime + " : " + secondsTime;
    }
}
