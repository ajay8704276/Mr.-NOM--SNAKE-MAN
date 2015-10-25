package com.ajay.tcs.framework;

/**
 * Created by Ajax on 10/25/2015.
 */
public abstract class Screen {

    protected final GameObjects gameObjects;

    public Screen(GameObjects gameObjects){
        this.gameObjects = gameObjects;
    }


    /**
     *
     * @param deltaTime
     */
    public abstract void update(float deltaTime);

    /**
     *
     * @param deltaTime
     */
    public abstract void present(float deltaTime);

    /**
     *
     */
    public abstract void pause();

    /**
     *
     */
    public abstract void resume();

    /**
     *
     */
    public abstract void dispose();
}
