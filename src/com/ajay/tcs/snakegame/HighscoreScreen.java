package com.ajay.tcs.snakegame;

import com.ajay.tcs.framework.GameObjects;
import com.ajay.tcs.framework.Graphics;
import com.ajay.tcs.framework.Input;
import com.ajay.tcs.framework.Screen;

import java.util.List;

/**
 * Created by Ajax on 10/25/2015.
 */
public class HighscoreScreen extends Screen {

    String lines[] = new String[5];

    public HighscoreScreen(GameObjects gameObjects) {
        super(gameObjects);

        for (int i=0;i<5;i++){
            lines[i]= " " +(i+1)+ "." +Settings.highScores[i];
        }
    }

    /**
     * @param deltaTime
     */
    @Override
    public void update(float deltaTime) {

        List<Input.TouchEvent> touchEvents = gameObjects.getInput().getTouchEvents();
        gameObjects.getInput().getKeyEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                if (event.x < 64 && event.y > 416) {
                    if (Settings.soundEnabled)
                        Assets.click.play(1);
                    gameObjects.setScreen(new MainMenuScreen(gameObjects));
                    return;
                }
            }
        }

    }

    /**
     * @param deltaTime
     */
    @Override
    public void present(float deltaTime) {

        Graphics g = gameObjects.getGraphics();
        g.drawPixmap(Assets.background, 0, 0);
        g.drawPixmap(Assets.mainMenu, 64, 20, 0, 42, 196, 42);
        int y = 100;
        for (int i = 0; i < 5; i++) {
            drawText(g, lines[i], 20, y);
            y += 50;
        }
        g.drawPixmap(Assets.buttons, 0, 416, 64, 64, 64, 64);
    }

    private void drawText(Graphics g, String line, int x, int y) {

        int len = line.length();
        for (int i = 0; i < len; i++) {
            char character = line.charAt(i);
            if (character == ' ') {
                x += 20;
                continue;
            }
            int srcX = 0;
            int srcWidth = 0;
            if (character == '.') {
                srcX = 200;
                srcWidth = 10;
            } else {
                srcX = (character - '0') * 20;
                srcWidth = 20;
            }
            g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 32);
            x += srcWidth;
        }
    }

    /**
     *
     */
    @Override
    public void pause() {
        //do nothing

    }

    /**
     *
     */
    @Override
    public void resume() {

        //do nothing
    }

    /**
     *
     */
    @Override
    public void dispose() {

        //do nothing
    }
}
