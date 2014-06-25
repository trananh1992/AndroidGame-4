package com.beltonp.androidgame.fantasygame;

import android.util.Log;

import com.beltonp.androidgame.framework.Screen;
import com.beltonp.androidgame.framework.impl.AndroidGame;

public class FantasyGame extends AndroidGame{

	@Override
	public Screen getStartScreen() {
		Log.i("PHIL", "loaded FantasyGame Class");
		return new LoadingScreen(this); 
	}
}
