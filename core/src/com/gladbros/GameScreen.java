package com.gladbros;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gladbros.Objects.Meteor;
import com.gladbros.Objects.Robot;
import com.gladbros.TextFields.Score;
import com.gladbros.TextFields.Timer;

public class GameScreen implements Screen {

    private MenuScreen game;
    SpriteBatch batch;
    Background background;
    Robot robot;
    Meteor meteor;
    Frames frames;
    Timer timer;
    Score score;
    Music musicGame;
    boolean gameIsOver;

    public GameScreen(MenuScreen game) {
        this.game = game;
    }


    @Override
    public void show() {
        batch = new SpriteBatch();
        background = new Background();
        robot = new Robot();
        meteor = new Meteor();
        frames = new Frames();
        timer = new Timer();
        score = new Score();
        musicGame = Gdx.audio.newMusic(Gdx.files.internal("Ashes_Remain-End_of_me.mp3"));
        musicGame.setLooping(true);
        gameIsOver=false;
    }

    @Override
    public void render(float delta) {
        update();
        musicGame.setVolume(0.05f);
        musicGame.play();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.render(batch);

        robot.render(batch);
        meteor.render(batch);
        frames.render(batch);
        timer.render(batch);
        score.render(batch);
        batch.end();
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            gameIsOver = true;

        }
    }
    public void update(){
        background.update(batch);
        robot.update(batch);
        meteor.update(batch);
    }

    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
    @Override
    public void dispose() {
        batch.dispose();
        //img.dispose();
    }
}
