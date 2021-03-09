package com.gladbros.Objects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.gladbros.GameScreen;
import com.gladbros.HangarScreen;
import com.gladbros.HighScoresScreen;
import com.gladbros.MenuScreen;

public class Button {

    private MenuScreen game;
    public static TextButton gameMenuButton;

    public Button(String button, int posX, int posY, int setSizeX, int setSizeY) {
        Skin mySkin = new Skin(Gdx.files.internal("metal\\skin\\metal-ui.json"));
        gameMenuButton = new TextButton(button,mySkin);
        gameMenuButton.setSize(setSizeX, setSizeY);
        gameMenuButton.setPosition(posX, posY);
        switch (button){
            case "Exit":
                {
                    gameMenuButton.addListener(new InputListener() {
                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            System.exit(0);
                            MenuScreen.music.stop();
                        }
                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            return true;
                        }
                    });
                }
                break;

            case "Start":
                {
                    gameMenuButton.addListener(new InputListener() {
                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            MenuScreen.game.setScreen(new GameScreen(game));
                            MenuScreen.music.stop();
                        }
                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            return true;
                        }
                    });
                }
                break;

            case "HighScores":
            {
                gameMenuButton.addListener(new InputListener() {
                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        MenuScreen.game.setScreen(new HighScoresScreen(game));
                        MenuScreen.music.stop();
                    }
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        return true;
                    }
                });


            }

                break;
            case "Return":
            {
                gameMenuButton.addListener(new InputListener() {
                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        MenuScreen.game.setScreen(new MenuScreen(MenuScreen.game));
                        MenuScreen.isMusicPlaying = false;
                    }
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        return true;
                    }
                });
            }
            break;

            case "Restart":
            {
                gameMenuButton.addListener(new InputListener() {
                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        MenuScreen.game.setScreen(new MenuScreen(MenuScreen.game));
                    }
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        return true;
                    }
                });
            }

            break;

            case "Hangar":{
                gameMenuButton.addListener(new InputListener() {
                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        MenuScreen.game.setScreen(new HangarScreen(game));
                        MenuScreen.music.stop();
                    }
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        return true;
                    }
                });
            }
            break;

            case "modelRobby":{
                gameMenuButton.addListener(new InputListener() {
                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        HangarScreen.choice = 1;
                        MenuScreen.music.stop();
                    }
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        return true;
                    }
                });
            }
            break;

            case "modelRoboticI":{
                gameMenuButton.addListener(new InputListener() {
                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        HangarScreen.choice = 2;
                        MenuScreen.music.stop();
                    }
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        return true;
                    }
                });
            }
            break;

            case "modelBattleship":{
                gameMenuButton.addListener(new InputListener() {
                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        HangarScreen.choice=3;
                        MenuScreen.music.stop();
                    }
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        return true;
                    }
                });
            }
            break;
        }
    }

    public TextButton getButton()
    {
        return gameMenuButton;
    }
}
