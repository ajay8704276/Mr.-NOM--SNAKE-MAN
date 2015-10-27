package com.ajay.tcs.framework;

import android.view.KeyEvent;

import java.util.List;

/**
 * Created by Ajax on 10/24/2015.
 */
public interface Input {

    public static class KeyEvent{

        public static final int KEY_DOWN = 0;
        public static final int KEY_UP = 1;

        public int type ;
        public int keyCode;
        public int keyChar;
    }

    public static class TouchEvent{

        public static final int TOUCH_DOWN = 0;
        public static final int TOUCH_UP = 1;
        public static final int TOUCH_DRAGGED = 2;


        public int type;
        public int x,y;
        public int pointer;

    }


    /**
     *takes a keyCode and returns whether the
     corresponding key is currently pressed or not
     * @param keyCode-
     * @return boolean based on key pressed or not
     */
    public boolean isKeyPressed(int keyCode);


    /**
     *
     * @param pointer- takes pointer as a parameter
     * @return boolean based on screen is touched or not
     */
    public boolean isTouchDown(int pointer);

    /**
     *
     * @param pointer -- receives coordinate as pointer
     * @return X coordinate
     */
    public int getTouchX(int pointer);

    /**
     *
     * @param pointer -- receives coordinate as pointer
     * @return Y coordinate
     */
    public int getTouchY(int pointer);

    /**
     *
     * @return acceleration along X coordinate
     */
    public float getAccelX();

    /**
     *
     * @return acceleration along Y coordinate
     */
    public float getAccelY();


    /**
     *
     * @return acceleration along Z coordinate
     */
    public float getAccelZ();

    /**
     *
     * @return list of key events occurred
     */
    public List<KeyEvent> getKeyEvents();

    /**
     * list of touch events occurred
     * @return
     */
    public List<TouchEvent> getTouchEvents();
}
