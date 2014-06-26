package com.beltonp.androidgame.fantasygame;

import java.util.List;

import android.util.Log;

import com.beltonp.androidgame.framework.Game;
import com.beltonp.androidgame.framework.Graphics;
import com.beltonp.androidgame.framework.Input.TouchEvent;
import com.beltonp.androidgame.framework.Screen;

public class MainMenuScreen extends Screen {

	public MainMenuScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		//Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();       
        
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) 
            {
                if(inBounds(event, 0, 0, 1920, 1080)) 
                {
                	Log.i("PHIL", "Clicked!");
                }
                if(inBounds(event, 769, 700, 382, 88)) 
                {
                	Log.i("PHIL", "Play!");
                	game.setScreen(new GameScreen(game));
                	return;
                }
            }
        }
	}
	
    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1) 
            return true;
        else
            return false;
    }

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		
        g.drawPixmap(Assets.background, 0, 0, 7);
        g.drawPixmap(Assets.play, 769, 700);
        g.drawPixmap(Assets.warrior, 50, 50, 8);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

}
