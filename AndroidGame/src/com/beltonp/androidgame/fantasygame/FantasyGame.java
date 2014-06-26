package com.beltonp.androidgame.fantasygame;

import com.beltonp.androidgame.framework.Screen;
import com.beltonp.androidgame.framework.impl.AndroidGame;

public class FantasyGame extends AndroidGame{

	@Override
	public Screen getStartScreen() {
		return new LoadingScreen(this); 
	}
}
