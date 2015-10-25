package com.ajay.tcs.snakegame;

import com.ajay.tcs.framework.GameObjects;
import com.ajay.tcs.framework.Graphics;
import com.ajay.tcs.framework.Screen;

import java.io.IOException;

/**
 * Created by Ajax on 10/25/2015.
 */
public class LoadingScreen extends Screen {


    public LoadingScreen(GameObjects gameObjects) {

        super(gameObjects);

    }

    /**
     * @param deltaTime
     */
    @Override
    public void update(float deltaTime) {

        Graphics g = gameObjects.getGraphics();

        Assets.background = g.newPixmap("background.png", Graphics.PixmapFormat.RGB565);
        Assets.logo = g.newPixmap("logo.png", Graphics.PixmapFormat.ARGB4444);
        Assets.mainMenu = g.newPixmap("mainmenu.png", Graphics.PixmapFormat.ARGB4444);
        Assets.buttons = g.newPixmap("buttons.png", Graphics.PixmapFormat.ARGB4444);
        Assets.help1 = g.newPixmap("help1.png", Graphics.PixmapFormat.ARGB4444);
        Assets.help2 = g.newPixmap("help2.png", Graphics.PixmapFormat.ARGB4444);
        Assets.help3 = g.newPixmap("help3.png", Graphics.PixmapFormat.ARGB4444);
        Assets.numbers = g.newPixmap("numbers.png", Graphics.PixmapFormat.ARGB4444);
        Assets.ready = g.newPixmap("ready.png", Graphics.PixmapFormat.ARGB4444);
        Assets.pause = g.newPixmap("pausemenu.png", Graphics.PixmapFormat.ARGB4444);
        Assets.gameOver = g.newPixmap("gameover.png", Graphics.PixmapFormat.ARGB4444);
        Assets.headUp = g.newPixmap("headup.png", Graphics.PixmapFormat.ARGB4444);
        Assets.headLeft = g.newPixmap("headleft.png", Graphics.PixmapFormat.ARGB4444);
        Assets.headDown = g.newPixmap("headdown.png", Graphics.PixmapFormat.ARGB4444);
        Assets.headRight = g.newPixmap("headright.png", Graphics.PixmapFormat.ARGB4444);
        Assets.tail = g.newPixmap("tail.png", Graphics.PixmapFormat.ARGB4444);
        Assets.stain1 = g.newPixmap("stain1.png", Graphics.PixmapFormat.ARGB4444);
        Assets.stain2 = g.newPixmap("stain2.png", Graphics.PixmapFormat.ARGB4444);
        Assets.stain3 = g.newPixmap("stain3.png", Graphics.PixmapFormat.ARGB4444);



        try {
            Assets.click = gameObjects.getAudio().newSound("click.ogg");
            Assets.eat = gameObjects.getAudio().newSound("eat.ogg");
            Assets.bitten = gameObjects.getAudio().newSound("bitten.ogg");
        } catch (IOException e) {
            e.printStackTrace();
        }


        Settings.load(gameObjects.getFileIO());
        gameObjects.setScreen(new MainMenuScreen(gameObjects));


       // Assets.getAssetsInstance().setBackground("background.png", Graphics.PixmapFormat.RGB565);

    }

    /**
     * @param deltaTime
     */
    @Override
    public void present(float deltaTime) {

    }

    /**
     *
     */
    @Override
    public void pause() {

    }

    /**
     *
     */
    @Override
    public void resume() {

    }

    /**
     *
     */
    @Override
    public void dispose() {

    }
}
