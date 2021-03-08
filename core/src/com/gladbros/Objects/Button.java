package com.gladbros.Objects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.gladbros.MenuScreen;

public class Button {
    ImageButton.ImageButtonStyle connectToHost;
    public static ImageButton gameMenuButton;
    String button;
    int posX, poxY;

    public Button(String button, int posx, int posy) {
        this.button = button;
        this.posX = posx;
        this.poxY = posy;
    }


    public String getButton(String button) {
        if(button.equals("buttonStart")){
            button = "button_start.jpg";
        }
        else  if(button.equals("buttonHangar")){
            button = "button_hangar.jpg";
        }
        else if(button.equals("buttonHighScores"))
        {
            button = "button_high-scores.jpg";
        }
        return button;
    }

    public void render()
    {
        //TextureAtlas mainMenuAtlas = Assets.manager.get()
        Skin buttonSkin = new Skin(Gdx.files.internal(button));

        connectToHost = new ImageButton.ImageButtonStyle();

        connectToHost.up = buttonSkin.getDrawable(this.getButton(button));
        connectToHost.over = buttonSkin.getDrawable(this.getButton(button));
        connectToHost.down = buttonSkin.getDrawable(this.getButton(button));

        gameMenuButton = new ImageButton(connectToHost);
        gameMenuButton.setSize(258,58);
        gameMenuButton.setPosition(posX,poxY);
        gameMenuButton.addListener(new ClickListener());
    }



}
