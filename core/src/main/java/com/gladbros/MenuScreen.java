package main.java.com.gladbros;

import com.badlogic.gdx.Game;
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
import main.java.com.gladbros.Objects.Button;
import main.java.com.gladbros.Objects.Meteor;
import main.java.com.gladbros.TextFields.Score;
import main.java.com.gladbros.TextFields.Timer;

public class MenuScreen implements Screen {

    public MenuScreen(Game game) {
        this.game = game;
        //init variables after recreation
        Score.currentScore = 0;
        Timer.miliseconds = 0;
        Timer.seconds = 0;
        Timer.minutes = 0;
        Meteor.speed = 12;
    }

    public static Game game;
    BitmapFont title;
    SpriteBatch batch;
    Texture img;
    public static Stage stage;
    Button buttonStart,buttonHighScore,buttonHangar,buttonExit;
    public static Music music;
    public static boolean isMusicPlaying = false;

    @Override
    public void show() {
        title = new BitmapFont();
        title.setColor(Color.GRAY);
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        img = new Texture("MainMenu.jpg");
        buttonStart = new Button("Start", 50, 300, 258, 58);
        stage.addActor(buttonStart.getButton());
        buttonHangar = new Button("Hangar", 50, 220, 258, 58);
        stage.addActor(buttonHangar.getButton());
        buttonHighScore = new Button("HighScores", 50, 140, 258, 58);
        stage.addActor(buttonStart.getButton());
        buttonExit = new Button("Exit", 50, 60, 258, 58);
        stage.addActor(buttonExit.getButton());
        music = Gdx.audio.newMusic(Gdx.files.internal("music\\BonnieTyler-HoldingOutForAHero.mp3"));
        music.setLooping(true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if(!isMusicPlaying) {
            music.play();
            music.setVolume(0.5f);
        }
        batch.draw(img, 0, 0);
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(title,"Robby. The Sky Traveller I");
        title.getData().setScale(2, 2);
        title.draw(batch,glyphLayout, 200, 440);
        batch.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
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