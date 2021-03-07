package com.gladbros;

import com.badlogic.gdx.Game;

public class RobbyDemo extends Game {

	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}
}
