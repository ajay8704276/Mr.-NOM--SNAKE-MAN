package com.ajay.tcs.snakegame;

import com.ajay.tcs.framework.GameObjects;
import com.ajay.tcs.framework.Graphics;
import com.ajay.tcs.framework.Input;
import com.ajay.tcs.framework.Screen;

import java.util.List;

/**
 * Created by Ajax on 10/26/2015.
 */
public class HelpScreen3 extends Screen {
    public HelpScreen3(GameObjects gameObjects) {
        super(gameObjects);
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
                if (event.x > 256 && event.y > 416) {
                    gameObjects.setScreen(new MainMenuScreen(gameObjects));
                    if (Settings.soundEnabled)
                        Assets.click.play(1);
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
        g.drawPixmap(Assets.help1, 64, 100);
        g.drawPixmap(Assets.buttons, 256, 416, 0, 64, 64, 64);
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
     *
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
