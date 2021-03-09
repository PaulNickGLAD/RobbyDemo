package com.gladbros;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.gladbros.Objects.Button;

public class HangarScreen implements Screen {

    public HangarScreen(MenuScreen game) {
        this.game = game;
    }

    MenuScreen game;
    SpriteBatch batch;
    Texture img;
    Stage stage;
    Button buttonReturn;

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        img = new Texture("Hangar.jpg");
        buttonReturn = new Button("Return",350,50,100,58);
        stage.addActor(buttonReturn.getButton());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
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
