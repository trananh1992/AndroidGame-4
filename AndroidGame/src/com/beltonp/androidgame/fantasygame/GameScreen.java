package com.beltonp.androidgame.fantasygame;

import java.util.List;

import android.graphics.Color;
import android.util.Log;

import com.beltonp.androidgame.framework.Game;
import com.beltonp.androidgame.framework.Graphics;
import com.beltonp.androidgame.framework.Input.TouchEvent;
import com.beltonp.androidgame.framework.Screen;

public class GameScreen extends Screen {
	enum GameState {
        Ready,
        Running,
        Paused,
        GameOver
    }
	Warrior hero;
	Enemy bob;
	
    public GameScreen(Game game) {
		super(game);
		hero = new Warrior();
		bob = new Enemy();
    }

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		
		int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) 
            {
                if(inBounds(event, 670, 800, 581, 89)) 
                {
                	Log.i("PHIL", "Attack!");
                	Graphics g = game.getGraphics();
                	heroAttack(g);
                	enemyAttack(g);
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
	
	private void heroAttack(Graphics g) {
		hero.attack(bob);
		drawText(g, bob.health < 0 ? "0" : Integer.toString(bob.health), 1367, 100);
		if (bob.health <= 0)
		{
			game.setScreen(new MainMenuScreen(game));
		}
	}
	
	private void enemyAttack(Graphics g) {
		bob.attack(hero);
		drawText(g, hero.health < 0 ? "0" : Integer.toString(hero.health), 407, 100);
		if (hero.health <= 0)
		{
			game.setScreen(new MainMenuScreen(game));
		}
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		
		g.drawPixmap(Assets.background, 0, 0, 7);
		g.drawLine(0, 700, 1920, 700, Color.BLACK);
		g.drawPixmap(Assets.attack, 670, 800);
		g.drawPixmap(Assets.warrior, 406, 402, 9);
		g.drawPixmap(Assets.ogre, 1315, 320, 5);
		drawText(g, Integer.toString(hero.health), 407, 100);
		drawText(g, Integer.toString(bob.health), 1367, 100);
	}

	public void drawText(Graphics g, String line, int x, int y) {
        int len = line.length();
        for (int i = 0; i < len; i++) {
            char character = line.charAt(i);

            if (character == ' ') {
                x += 73;
                continue;
            }

            int srcX = 0;
            int srcWidth = 0;
            if (character == '.') {
                srcX = 200;
                srcWidth = 10;
            } else {
                srcX = (character - '0') * 73;
                srcWidth = 73;
            }

            g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 93);
            x += srcWidth;
        }
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
