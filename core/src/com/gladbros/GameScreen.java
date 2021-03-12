package com.gladbros;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.gladbros.Objects.Button;
import com.gladbros.Objects.Meteor;
import com.gladbros.Objects.Robot;
import com.gladbros.TextFields.Score;
import com.gladbros.TextFields.Timer;

import java.io.*;

public class GameScreen implements Screen {

    MenuScreen game;
    SpriteBatch batch;
    Background background;
    Robot robot;
    Meteor meteor;
    Frames frames;
    Timer timer;
    Score score;
    public Music musicGame;
    boolean gameIsOver;
    Texture gameOver;
    int highScore;
    String userName = "anonymous";
    Stage stage;
    Button buttonRestart;
    BitmapFont result;

    public GameScreen(MenuScreen game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        buttonRestart = new Button("Restart",280,370,200,58);
        stage.addActor(buttonRestart.getButton());
        batch = new SpriteBatch();
        background = new Background();
        robot = new Robot();
        meteor = new Meteor();
        frames = new Frames();
        timer = new Timer();
        score = new Score();
        musicGame = Gdx.audio.newMusic(Gdx.files.internal("music\\Ashes_Remain-End_of_me.mp3"));
        musicGame.setLooping(true);
        gameIsOver = false;
        gameOver = new Texture("GameOver.jpg");
        result = new BitmapFont();
        result.setColor(Color.BLACK);
    }

    @Override
    public void render(float delta) {

        musicGame.setVolume(0.05f);
        musicGame.play();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if(!gameIsOver){
            update();
            background.render(batch);
            robot.render(batch);
            meteor.render(batch);
            timer.render(batch);
            score.render(batch);
            frames.render(batch);
        }
        else {
            batch.draw(gameOver,0,0);
            GlyphLayout value = new GlyphLayout();
            String data = (userName + ", your HighScore: " + highScore);
            value.setText(result,data);
            result.draw(batch, value,300,320);
            stage.act();
            stage.draw();
            musicGame.stop();
        }
        batch.end();

    }
    public void update(){
        background.update(batch);
        robot.update(batch);
        meteor.update(batch);
        //Physics of the obstacles and main
        for(int i =0;i < Meteor.pos.length; i++){
            if(((((robot.pos.x>=Meteor.pos[i].x) && (robot.pos.x<=(Meteor.pos[i].x+82)))) ||
                    ((robot.pos.x<=Meteor.pos[i].x) && (Meteor.pos[i].x<=(robot.pos.x+70))))
                    && (((robot.pos.y>=Meteor.pos[i].y) && ((Meteor.pos[i].y+82)>=robot.pos.y))
                    ||((robot.pos.y<= Meteor.pos[i].y)&& ((robot.pos.y+70)>=Meteor.pos[i].y))))
            {
                gameIsOver = true;
                highScore = Score.currentScore;
                saveData();
            }
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public void saveData() {
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("core\\assets\\HighScores.txt",true));
            bufferedWriter.write("" + highScore+"\n");
            System.out.println(highScore);
            bufferedWriter.close();
        }catch (Exception e){}
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
