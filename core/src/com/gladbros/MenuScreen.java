package com.gladbros;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.gladbros.Objects.Button;

public class MenuScreen implements Screen {
    public final Game game;
    SpriteBatch batch;
    Texture img;
    public static Stage stage;
    Button button;


    public MenuScreen(Game game) {
        this.game = game;
    }


    @Override
    public void show() {

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        img = new Texture("mainmenu.jpg");
        //button = new Button("start_button", 20,20);
        Skin mySkin = new Skin(Gdx.files.internal("glassy-ui.json"));
        ImageButton imageButton = new ImageButton(mySkin);
        stage.addActor(imageButton);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        /**
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            game.setScreen(new GameScreen(this));
        }**/
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
    }
}
