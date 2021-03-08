package com.gladbros;

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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.gladbros.Objects.Button;

public class MenuScreen implements Screen {
    public static Game game;
    BitmapFont title;
    SpriteBatch batch;
    Texture img;
    public static Stage stage;
    Button buttonStart,buttonHighScore,buttonHangar,buttonExit;
    public static Music music;
    public static boolean isMusicPlaying = false;



    public MenuScreen(Game game) {
        this.game = game;
    }


    @Override
    public void show() {
        title = new BitmapFont();
        title.setColor(Color.GRAY);
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        img = new Texture("mainmenu.jpg");
        buttonStart = new Button("Start", 50,300);
        Button.gameMenuButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(MenuScreen.this));
                if (music instanceof Music){
                    music.stop();
                }
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(Button.gameMenuButton);
        buttonHangar = new Button("Hangar", 50,220);
        stage.addActor(Button.gameMenuButton);
        buttonHighScore = new Button("HighScores", 50,140);
        Button.gameMenuButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new HighScoresScreen(MenuScreen.this));
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(Button.gameMenuButton);
        buttonExit = new Button("Exit", 50,60);
        Button.gameMenuButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(Button.gameMenuButton);

        music = Gdx.audio.newMusic(Gdx.files.internal("music\\BonnieTyler-HoldingOutForAHero.mp3"));
        music.setLooping(true);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if(!isMusicPlaying) {

            music.play();}
        batch.draw(img, 0, 0);
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(title,"Robby. The Sky Traveller I");
        title.getData().setScale(2,2);
        title.draw(batch,glyphLayout,200,440);
        batch.end();
        stage.act();
        stage.draw();

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
        img.dispose();
        stage.dispose();
    }
}
