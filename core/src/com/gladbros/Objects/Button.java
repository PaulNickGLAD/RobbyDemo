package com.gladbros.Objects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Button {
    public static TextButton gameMenuButton;
    public static String buttonName;
    int posX, poxY;

    public Button(String button, int posx, int posy) {
        this.buttonName = button;
        this.posX = posx;
        this.poxY = posy;
        Skin mySkin = new Skin(Gdx.files.internal("metal\\skin\\metal-ui.json"));
        gameMenuButton = new TextButton(button,mySkin);
        gameMenuButton.setSize(258, 58);
        gameMenuButton.setPosition(posX, poxY);
        gameMenuButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }
}
