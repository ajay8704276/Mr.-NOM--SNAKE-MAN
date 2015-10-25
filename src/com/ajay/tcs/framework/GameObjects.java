package com.ajay.tcs.framework;

/**
 * Created by Ajax on 10/25/2015.
 */
public interface GameObjects {

    public Input getInput();

    public FileIO getFileIO();

    public Graphics getGraphics();

    public Audio getAudio();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();

    public Screen getStartScreen();
}
