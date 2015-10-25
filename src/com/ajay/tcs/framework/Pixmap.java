package com.ajay.tcs.framework;

/**
 * Created by Ajax on 10/25/2015.
 */
public interface Pixmap {

    public int getWidth();

    public int getHeight();

    public Graphics.PixmapFormat getFormat();

    public void dispose();
}
