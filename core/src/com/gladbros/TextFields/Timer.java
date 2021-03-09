package com.gladbros.TextFields;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Timer  {
    static BitmapFont font; //
    static String txt = "TIME:";
    public static int miliseconds = 0;
    public static int seconds = 0;
    public static int minutes = 0;

    public Timer() {
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

    public String printTime(){
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
