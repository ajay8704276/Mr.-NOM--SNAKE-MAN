package com.ajay.tcs.implementation;

import android.content.Context;
import android.os.Build;
import android.view.View;
import com.ajay.tcs.framework.Input;

import java.util.List;

/**
 * Created by Ajax on 10/25/2015.
 */
public class AndroidInput implements Input {


    AccelerometerHandler accelHandler;
    KeyboardHandler keyHandler;
    TouchHandler touchHandler;




    public AndroidInput(Context context, View view, float scaleX, float scaleY) {
        accelHandler = new AccelerometerHandler(context);
        keyHandler = new KeyboardHandler(view);
        if (Integer.parseInt(Build.VERSION.SDK) < 5)
            touchHandler = new SingleTouchHandler(view, scaleX, scaleY);
        else
            touchHandler = new MultiTouchHandler(view, scaleX, scaleY);
    }

    /**
     * takes a keyCode and returns whether the
     * corresponding key is currently pressed or not
     *
     * @param keyCode -
     * @return boolean based on key pressed or not
     */
    @Override
    public boolean isKeyPressed(int keyCode) {
        return keyHandler.isKeyPressed(keyCode);
    }

    /**
     * @param pointer - takes pointer as a parameter
     * @return boolean based on screen is touched or not
     */
    @Override
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

    /**
     * @param pointer -- receives coordinate as pointer
     * @return X coordinate
     */
    @Override
    public int getTouchX(int pointer) {
        return touchHandler.getTouchX(pointer);
    }

    /**
     * @param pointer -- receives coordinate as pointer
     * @return Y coordinate
     */
    @Override
    public int getTouchY(int pointer) {
        return touchHandler.getTouchY(pointer);
    }

    /**
     * @return acceleration along X coordinate
     */
    @Override
    public float getAccelX() {
        return accelHandler.accelerationX;
    }

    /**
     * @return acceleration along Y coordinate
     */
    @Override
    public float getAccelY() {
        return accelHandler.accelerationY;
    }

    /**
     * @return acceleration along Z coordinate
     */
    @Override
    public float getAccelZ() {
        return accelHandler.accelerationZ;
    }

    /**
     * @return list of key events occurred
     */
    @Override
    public List<android.view.KeyEvent> getKeyEvents() {
        return keyHandler.getKeyEvents();
    }

    /**
     * list of touch events occurred
     *
     * @return
     */
    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }
}
