package com.beltonp.androidgame.fantasygame;

import com.beltonp.androidgame.framework.Game;
import com.beltonp.androidgame.framework.Screen;

public class GameScreen extends Screen {
	enum GameState {
        Ready,
        Running,
        Paused,
        GameOver
    }
	
    public GameScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
    }

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
