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
    Button buttonReturn, buttonModelRobby, buttonModelRoboticI,buttonModelBattleShip;
    public static int choice = 1;

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        img = new Texture("Hangar.jpg");
        buttonReturn = new Button("Return",100,20,80,40);
        stage.addActor(buttonReturn.getButton());
        buttonModelRobby = new Button("modelRobby",80,250,100,40);
        stage.addActor(buttonModelRobby.getButton());
        buttonModelRoboticI = new Button("modelRoboticI",80,200,100,40);
        stage.addActor(buttonModelRoboticI.getButton());
        buttonModelBattleShip = new Button("modelBattleship",80,150,100,40);
        stage.addActor(buttonModelBattleShip.getButton());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        switch (choice){

            case 1: { batch.draw(new Texture("modelRobbyB.jpg"),320,30); }
            break;

            case 2: { batch.draw(new Texture("modelRoboticIB.jpg"),320,20); }
            break;

            case 3: { batch.draw(new Texture("modelBattleshipB.jpg"),320,30); }
            break;
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
