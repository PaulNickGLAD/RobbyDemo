package main.java.com.gladbros.TextFields;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Score {

    public Score() {
        font = new BitmapFont();
        font.setColor(Color.RED);
    }

    static BitmapFont font; //
    static String txt = "SCORE";
    public static int currentScore = 0;

    public void render(SpriteBatch batch) {
        GlyphLayout value1 = new GlyphLayout();
        GlyphLayout value = new GlyphLayout();
        value.setText(font,printScore());
        value1.setText(font,txt);
        font.draw(batch,value1,710,80);
        font.draw(batch,value,725,60);
    }

    public String printScore(){
        currentScore = Timer.seconds * 50 + Timer.minutes * 60 * 50;
        return ""+currentScore;
    }
}