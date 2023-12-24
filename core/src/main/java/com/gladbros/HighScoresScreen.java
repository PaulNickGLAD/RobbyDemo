package main.java.com.gladbros;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import main.java.com.gladbros.Objects.Button;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HighScoresScreen implements Screen {

    public HighScoresScreen(MenuScreen game) {
        this.game = game;
    }

    MenuScreen game;
    SpriteBatch batch;
    Texture img;
    Stage stage;
    Button buttonReturn;
    ArrayList<BitmapFont> bitmapFonts;
    int [] arrayTop = new int[10];


    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        img = new Texture("MainMenu.jpg");
        buttonReturn = new Button("Return",300,50,100,58);
        stage.addActor(buttonReturn.getButton());
        ArrayList <Integer> arrayList = new ArrayList<>();
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("core\\assets\\HighScores.txt"));
            String str;
            while(true) {
                str = bufferedReader.readLine();
                if(str == null)
                {
                    break;
                }
                else {
                    arrayList.add(Integer.parseInt(str));
                }
            }
        } catch (IOException exc){ exc.printStackTrace();}
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        for(int i = 0; i < 10; i++){
            arrayTop[i] = arrayList.get(i);
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        ArrayList<BitmapFont> bitmapFonts = new ArrayList<>(10);
        for (int i =0; i < 10; i++) {
            bitmapFonts.add(new BitmapFont());
        }
        BitmapFont bitmapFont = new BitmapFont();
        bitmapFont.setColor(Color.BLACK);
        bitmapFont.getData().setScale(2, 2);
        bitmapFont.draw(batch,"Best Results", 350, 420);
        for(int i = 0; i < 10; i++){
            bitmapFonts.get(i).setColor(Color.BLACK);
            bitmapFonts.get(i).getData().setScale(2, 2);
            bitmapFonts.get(i).draw(batch,String.valueOf(arrayTop[i]), 380, 380 - (i * 25));
        }
        batch.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
    }

    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
}