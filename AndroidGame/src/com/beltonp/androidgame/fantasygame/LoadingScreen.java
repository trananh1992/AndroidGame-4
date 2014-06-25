package com.beltonp.androidgame.fantasygame;

import android.util.Log;

import com.beltonp.androidgame.framework.Game;
import com.beltonp.androidgame.framework.Graphics;
import com.beltonp.androidgame.framework.Graphics.PixmapFormat;
import com.beltonp.androidgame.framework.Screen;

public class LoadingScreen extends Screen{

	public LoadingScreen(Game game) {
		super(game);
		Log.i("PHIL", "after super(game) in LoadingScreen class");
	}

	@Override
	public void update(float deltaTime) {
		// TODO Add code here.
		Log.i("PHIL", "begining of update of LoadingScreen class");
		Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("background.png", PixmapFormat.RGB565);
        Assets.mainMenu = g.newPixmap("mainmenu.png", PixmapFormat.ARGB4444);
        game.setScreen(new MainMenuScreen(game));
	}

	@Override
	public void present(float deltaTime) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
