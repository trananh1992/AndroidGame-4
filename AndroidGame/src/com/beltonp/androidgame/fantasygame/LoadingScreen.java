package com.beltonp.androidgame.fantasygame;

import com.beltonp.androidgame.framework.Game;
import com.beltonp.androidgame.framework.Graphics;
import com.beltonp.androidgame.framework.Graphics.PixmapFormat;
import com.beltonp.androidgame.framework.Screen;

public class LoadingScreen extends Screen{

	public LoadingScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("background-white.png", PixmapFormat.RGB565);
        Assets.play = g.newPixmap("play.png", PixmapFormat.ARGB4444);
        Assets.warrior = g.newPixmap("Warrior.png", PixmapFormat.ARGB4444);
        Assets.attack = g.newPixmap("attack.png", PixmapFormat.ARGB4444);
        Assets.numbers = g.newPixmap("numbers.png", PixmapFormat.ARGB4444);
        Assets.ogre = g.newPixmap("ogre.png", PixmapFormat.ARGB4444);
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
